
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.CatalogoProductos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CRUDCatalogoProductos {
    public boolean save(CatalogoProductos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean completado = false;
         

        try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando producto en el catalogo");
            session.persist(newcatpro);
            completado=true;
            transaction.commit();
             System.out.println("Se guardo el producto en el catalogo");
            
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("El error en el metodo de guardar es: "+err);
                System.out.println("Hubo un error al dar de alta el registro\n"+err+"\n Error SAVECRUD");
            }
        } finally {
            session.close();
        }
       return completado;
    }

    public boolean update(CatalogoProductos newcatpro, String oldcatproName) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        CatalogoProductos updateCatPro;
        boolean completado = false;
        try {
            
            transaction = session.beginTransaction();
            updateCatPro=session.get(CatalogoProductos.class, ToID(oldcatproName));
            updateCatPro.setNombre_producto(newcatpro.getNombre_producto());
            session.flush();
            session.clear();
            transaction.commit();
            completado=true;

        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("Hubo un error al actualizar el registro\n"+err+"\n Error UPDATECRUD");
            }
        } finally {
            session.close();
        }
    return completado;
    }
    
    public boolean delete(String oldcatproName){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        CatalogoProductos delcatpro;
        boolean completado= false;
        try{
            transaction = session.beginTransaction();
            System.out.println("Transaction iniciada");
            delcatpro=session.find(CatalogoProductos.class, ToID(oldcatproName));
            System.out.println("Eliminar registro");
            session.remove(delcatpro);
            session.flush();
            session.clear();
            transaction.commit();

            
        }catch(Exception err){
            
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Hubo un error al dar de baja el registro\n"+err+"\n Error DELETECRUD");
            }
            
        }finally {
            session.close();
        }
       return completado;
    }
    
    public List opRead(String crit){
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<CatalogoProductos> listcatpro=null;
        Query<CatalogoProductos> query;
        try{
            if(crit.equals("")){
                query=session.createQuery("FROM CatalogoProductos", CatalogoProductos.class);
                listcatpro=query.getResultList();

            }else{
                query=session.createQuery("FROM CatalogoProductos WHERE nombreProducto LIKE :crit", CatalogoProductos.class);
                query.setParameter("crit",crit+"%");
                listcatpro=query.getResultList();
                System.out.println(listcatpro);
            }
        }catch(Exception err){
             
             System.out.println("Error al leer los productos del catalogo "+err+" Error: opRead");
        }
        return listcatpro;
    }
//Creación de la tabla 
   public TableModel listToCatPro(List results){
        
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        CatalogoProductos catpro;
        
        columnNames.addElement("Nombre Producto");
        
        Iterator itCatPro=results.iterator();
        
        while(itCatPro.hasNext()){
            catpro=(CatalogoProductos)itCatPro.next();
            Vector newRow=new Vector();
            newRow.addElement(catpro.getNombre_producto());
            rows.addElement(newRow);
        }
     return new DefaultTableModel(rows,columnNames){
         @Override
         public boolean isCellEditable(int row, int column){
             return false;
         }
     };
   }
   
    public TableModel opBuscar(String field, String crit){
        TableModel tm=null;
        List<CatalogoProductos> results;
        switch(field){
            case "Nombre del Producto":
                results=opRead(crit);
                tm=listToCatPro(results);
            break;
        }
        return tm;
    }
    
    public boolean ValidarCatalogo(String txtProducto){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        CatalogoProductos foundcatpro=new CatalogoProductos();
        boolean encontrado=false;
        try{
            Query<CatalogoProductos> query=session.createQuery("FROM CatalogoProductos WHERE nombreProducto= :nombre", CatalogoProductos.class);
            query.setParameter("nombre", txtProducto);
            foundcatpro=query.uniqueResult();
            if(foundcatpro != null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            System.out.println("Error al validar existencia del producto dentro del catalogo "+err+" Error: ValCRUD");
        }finally{
            session.close();
        }
        
        return encontrado;
    }
    
    public int ToID(String name){
          Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idcatpro=-1;
          try{
              query=session.createQuery("SELECT idCatpro FROM CatalogoProductos WHERE nombreProducto =: nombre",Integer.class);
              query.setParameter("nombre",name );
              idcatpro=query.uniqueResult();
          }catch(Exception err){
                System.out.println("Error al encontrar el id del producto dentro del catalogo ");
          }finally{
              session.close();
          }
          System.out.println(idcatpro);
          return idcatpro;
    }
    
}
