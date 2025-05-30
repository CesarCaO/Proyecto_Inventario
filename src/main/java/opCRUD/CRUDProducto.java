
package opCRUD;

import Util.HibernateUtil;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.CatalogoProductos;
import models.EstadoProducto;
import models.Gabinete;
import models.Marca;
import models.Producto;
import models.ProductoTableDTO;
import models.TipoProducto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CRUDProducto {
    CRUDCatalogoProductos crudCatPro=new CRUDCatalogoProductos();
    CRUDGabinete crudGabinete = new CRUDGabinete();
    CRUDMarca crudMarca = new CRUDMarca();
    CRUDTipoProducto crudTipoPro= new CRUDTipoProducto();
    CRUDEstadoProducto crudEstPro= new CRUDEstadoProducto();
    
    public boolean save(Producto producto, String marca, String tipoProducto, String catalogoProducto, int numGabinete, String estadoProducto){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean completado=false;

        try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            //Buscar los objetos a relacionar
            Marca relMarca = session.getReference(Marca.class, crudMarca.ToID(marca));
            TipoProducto relTipoPro = session.getReference(TipoProducto.class, crudTipoPro.ToID(tipoProducto));
            CatalogoProductos relCalPro = session.getReference(CatalogoProductos.class, crudCatPro.ToID(catalogoProducto));
            Gabinete relGabinete = session.getReference(Gabinete.class, crudGabinete.ToID(numGabinete));
            EstadoProducto relEstPro = session.getReference(EstadoProducto.class, crudEstPro.ToID(estadoProducto));

            //Hacer las relaciones
            producto.setMarca(relMarca);
            producto.setTipoProducto(relTipoPro);
            producto.setCatalogoProducto(relCalPro);
            producto.setGabinete(relGabinete);
            producto.setEstadoProducto(relEstPro);
            System.out.println("Guardando registro");
            session.persist(producto);
            
            session.flush();
            
            int generateId=producto.getIdProducto();
            String numInv=generarNumInventario(generateId);
            
            producto.setNumInventario(numInv);
            
            session.merge(producto);
            transaction.commit();
            System.out.println("Se guardo el registro");
            completado=true;
        } catch (Exception err) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        } 
        return completado;
    }
    
    public boolean update(Producto producto, String marca, String tipoProducto, String catalogoProducto, int numGabinete, String estadoProducto, String numInventario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean completado=false;
        
        try{
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            
            Producto updateProducto=session.get(Producto.class, ToID(numInventario));//Ubicar la instancia a actualizar
            
            if(updateProducto== null){
                throw new IllegalArgumentException("Producto con número de inventario " + numInventario + " no existe.");
            }
            //Buscar los objetos a relacionar
            Marca relMarca = session.find(Marca.class, crudMarca.ToID(marca));
            if(relMarca==null){
               throw new IllegalArgumentException("Marca " + marca + " no existe.");
            }
            TipoProducto relTipoPro = session.find(TipoProducto.class, crudTipoPro.ToID(tipoProducto));
            if(relTipoPro==null){
                throw new IllegalArgumentException("El tipo de producto " + tipoProducto + " no existe.");
            }
            CatalogoProductos relCalPro = session.find(CatalogoProductos.class, crudCatPro.ToID(catalogoProducto));
            if(relCalPro==null){
               throw new IllegalArgumentException("Producto con número de inventario " + catalogoProducto + " no existe.");
            }
            Gabinete relGabinete = session.find(Gabinete.class, crudGabinete.ToID(numGabinete));
            if(relGabinete==null){
               throw new IllegalArgumentException("El gabinete número " + numGabinete + " no existe.");
            }
            
            
            EstadoProducto relEstPro = session.find(EstadoProducto.class, crudEstPro.ToID(estadoProducto));
            if(relEstPro==null){
                throw new IllegalArgumentException("El estado del producto: " + estadoProducto + " no existe.");
            }
            
            //Hacer las relaciones
            updateProducto.setMarca(relMarca);
            updateProducto.setTipoProducto(relTipoPro);
            updateProducto.setCatalogoProducto(relCalPro);
            updateProducto.setGabinete(relGabinete);
            updateProducto.setEstadoProducto(relEstPro);
            /////////////////////////////////////
            
            updateProducto.setNumInventario(producto.getNumInventario());
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setModelo(producto.getModelo());
            updateProducto.setSerie(producto.getSerie());
            updateProducto.setInventario_institucional(producto.getInventario_institucional());
            updateProducto.setCantidadStock(producto.getCantidadStock());
            updateProducto.setFechaRegistro(producto.getFechaRegistro());
            
            if(producto.getImagen()!=null){
                System.out.print("Dentro de la validación de la imagen");
                updateProducto.setImagen(producto.getImagen());
            }
            
            transaction.commit();
            completado = true;
        }catch(Exception err){
            if (transaction != null) {
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return completado;
    }
    
    public boolean delete(String numInventario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Producto delProducto;
        boolean completado=false;
        
        try{
            transaction=session.beginTransaction();
            delProducto=session.find(Producto.class, ToID(numInventario));
            session.remove(delProducto);
            session.flush();
            session.clear();
            transaction.commit();
            completado=true;
        }catch(Exception err){
            if (transaction != null) {
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return completado;
    }
    
    public int ToID(String numInv){
          Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int id=-1;
          try{
              query=session.createQuery("SELECT idProducto FROM Producto WHERE numInventario =: numInv",Integer.class);
              query.setParameter("numInv",numInv);
              id=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el ID\n "+err+" \nError: ToID", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          System.out.println(id);
          return id;
    }
    
    public List opRead(String crit, String field){
        
       Session session=HibernateUtil.getSessionFactory().openSession();
       System.out.println("El criterio es: "+crit);
       System.out.println("El campo es: "+field);
       List<ProductoTableDTO> listproducto=null;
       Query<ProductoTableDTO> query;
       
        try {
            if (crit.equals("")) {
                query = session.createQuery("SELECT NEW models.ProductoTableDTO(p.idProducto,p.numInventario, cp.nombreProducto, m.nombreMarca, tp.tipo, "
                        + "g.numGabinete, ep.estado, p.descripcion, p.modelo, p.serie, p.inventario_institucional, p.cantidadStock, "
                        + "p.fechaRegistro, p.imagen) FROM Producto p "
                        + "JOIN p.catalogoProducto cp "
                        + "JOIN p.marca m "
                        + "JOIN p.tipoProducto tp "
                        + "JOIN p.gabinete g "
                        + "JOIN p.estadoProducto ep ORDER BY p.idProducto DESC", ProductoTableDTO.class);
                listproducto = query.getResultList();
                System.out.println("Productos encontrados (sin criterio): " + listproducto.size());
            } else {
                query = session.createQuery("SELECT NEW models.ProductoTableDTO(p.idProducto, p.numInventario, cp.nombreProducto, m.nombreMarca, tp.tipo, "
                        + "g.numGabinete, ep.estado, p.descripcion, p.modelo, p.serie, p.inventario_institucional, p.cantidadStock, "
                        + "p.fechaRegistro,p.imagen) FROM Producto p "
                        + "JOIN p.catalogoProducto cp "
                        + "JOIN p.marca m "
                        + "JOIN p.tipoProducto tp "
                        + "JOIN p.gabinete g "
                        + "JOIN p.estadoProducto ep "
                        + "WHERE "
                        + "CAST( " + field + " AS string) LIKE :crit ORDER BY p.idProducto DESC", ProductoTableDTO.class);
                query.setParameter("crit",crit+"%");
                listproducto=query.getResultList();
                System.out.println("Productos encontrados (con criterio): " + listproducto.size());
                
            }
        } catch (Exception err) {
            System.out.println("Error al leer los productos " + err + " Error: opRead");
        } finally {
            
            session.close();
        }
            return listproducto;
    }
    public TableModel listTo(List<ProductoTableDTO> results) {

        Vector columnNames = new Vector();
        Vector rows = new Vector();
        ImageIcon imagen, barcode;

        columnNames.add("Número de inventario");
        columnNames.add("Nombre");
        columnNames.add("Marca");
        columnNames.add("Tipo");
        columnNames.add("Gabinete");
        columnNames.add("Estado");
        columnNames.add("Descripción");
        columnNames.add("Modelo");
        columnNames.add("Serie");
        columnNames.add("Inventario UAEH");
        columnNames.add("Stock");
        columnNames.add("Fechas de registro");
        columnNames.add("Imagen");

        for (ProductoTableDTO dto : results) {
            Vector<Object> newRow = new Vector();
            newRow.add(dto.getNumInventario());
            newRow.add(dto.getNombreProducto());
            newRow.add(dto.getMarca());
            newRow.add(dto.getTipoProducto());
            newRow.add(dto.getNumGabinete());
            newRow.add(dto.getEstadoProducto());
            newRow.add(dto.getDescripcion());
            newRow.add(dto.getModelo());
            newRow.add(dto.getSerie());
            newRow.add(dto.getInventario_institucional());
            newRow.add(dto.getCantidadStock());
            newRow.add(dto.getFechaRegistro());
            newRow.add(BytesToImage(dto.getImagen()));

            rows.add(newRow);
        }

        return new DefaultTableModel(rows, columnNames) {
            @Override
            public Class<?> getColumnClass(int column){
                if(column==12){
                    return ImageIcon.class;
                }
       
                return super.getColumnClass(column);
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    
    public TableModel opBuscar(String field, String crit){
        TableModel tm=null;
        List<ProductoTableDTO> results=null;
        switch(field){
            case "Número de Inventario"->{
                results=opRead(crit,"numInventario");
                break;
            }
            case "Nombre"->{
                results=opRead(crit,"nombreProducto");
                break;
            }
            case "Marca"->{
                results=opRead(crit,"nombreMarca");
                break;
            }
            case "Tipo de producto"->{
                results=opRead(crit,"tipo");
                break;
            }
            case "Gabinete"->{
                results=opRead(crit,"numGabinete");
                break;
            }
            case "Estado del producto"->{
                results=opRead(crit,"estado");
                break;
            }
            case "Modelo"->{
                results=opRead(crit,"modelo");
                break;
            }
            case "Número de serie"->{
                results=opRead(crit, "serie");
                break;
            }
            case "Número de inventario institucional"->{
                results=opRead(crit,"inventario_institucional");
                break;
            }
            
    }
        return tm=listTo(results);
    }
    
    public ImageIcon BytesToImage(byte[] imageBytes) {
        
        if(imageBytes == null  || imageBytes.length == 0){
            return new ImageIcon();
        }
        try(ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes))
        {
            BufferedImage imagen = ImageIO.read(bis);
            
            int newWidth = 80;
            int newHeight = (imagen.getHeight()*newWidth) / imagen.getWidth();
            
            Image imagenEscalada = imagen.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            
            return new ImageIcon(imagenEscalada);
        }catch(IOException err){
            return new ImageIcon();
        }
    }
     
     
     public String generarNumInventario(int ID){
        
        DecimalFormat df = new DecimalFormat("000000");
        String numeroFormateado = df.format(ID);
        return numeroFormateado;
    }
    
}
