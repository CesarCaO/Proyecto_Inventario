
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


/**
 * Esta clase contiene las operaciones CRUD del catalogo de productos
 */
public class CRUDCatalogoProductos {
    public boolean save(CatalogoProductos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean completado = false;
         

        try {
            System.out.println("Iniciando transaccion");
            transaction = session.beginTransaction();
            System.out.println("Guardando producto en el catalogo");
            session.persist(newcatpro);
            completado=true;
            transaction.commit();
             System.out.println("Se guardo el producto en el catalogo");
            
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("Hubo un error al dar de alta el registro en el catalogo\n"+err+"\n Error SAVECRUD");
            }
        } finally {
            session.close();
            System.out.println("Sesion cerrada");
        }
       return completado;
    }

    public boolean update(CatalogoProductos newcatpro, String oldcatproName) { //Funcion de actualizacion del catalogo de productos
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        CatalogoProductos updateCatPro;
        boolean completado = false;
        try {
            
            transaction = session.beginTransaction();
            System.out.print("Iniciando transaccion");
            updateCatPro=session.get(CatalogoProductos.class, ToID(oldcatproName));
            System.out.println("Iniciando actualizacion del producto en el catalodo");
            updateCatPro.setNombre_producto(newcatpro.getNombre_producto());
            session.flush();
            session.clear();
            transaction.commit();
            completado=true;

        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("Hubo un error al actualizar el registro del catalogo\n"+err+"\n Error UPDATECRUD");
            }
        } finally {
            session.close();
            System.out.println("Sesion cerrada");
        }
    return completado;
    }
    
    public boolean delete(String oldcatproName){//Función delete del catalogo de productos 
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        CatalogoProductos delcatpro;
        boolean completado= false;
        try{
            transaction = session.beginTransaction();
            System.out.println("Transaction iniciada");
            delcatpro=session.find(CatalogoProductos.class, ToID(oldcatproName));
            System.out.println("Eliminando registro");
            session.remove(delcatpro);
            System.out.println("Registro eliminado");
            session.flush();
            session.clear();
            transaction.commit();
            completado=true;
            
        }catch(Exception err){
            
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Hubo un error al dar de baja el registro\n"+err+"\n Error DELETECRUD");
            }
            
        }finally {
            session.close();
            System.out.print("Sesion cerrada");
        }
       return completado;
    }
    
    public List opRead(String crit){//Función para recuperar los registros de la base de datos
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
   public TableModel listToCatPro(List results){ //Función pra crear la tabla de la interfaz Catalogo de productos
        
        
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
   
    public TableModel opBuscar(String field, String crit){//Función para buscar registros
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
    
    public boolean ValidarCatalogo(String txtProducto){//Función para validar la existencia del producto en el catalogo
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
    
    public int ToID(String name){//Convertir el nombre en un ID
        
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
