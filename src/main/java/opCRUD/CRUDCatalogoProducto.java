
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.CatalogoProductos;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CRUDCatalogoProducto {
    public void save(CatalogoProductos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
         

        try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando producto en el catalogo");
            session.persist(newcatpro);
            transaction.commit();
             System.out.println("Se guardo el producto en el catalogo");
            
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("El error en el metodo de guardar es: "+err);
                
            }

        } finally {
            session.close();
        }
       
    }

    public void update(CatalogoProductos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        

        try {
            transaction = session.beginTransaction();
            session.merge(newcatpro);
            transaction.commit();
            

        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                
            }
        } finally {
            session.close();
        }
    
    }
    
    public void delete(CatalogoProductos catpro){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            
            transaction = session.beginTransaction();
            session.remove(catpro);
            transaction.commit();

            
        }catch(Exception err){
            
            if (transaction != null) {
                transaction.rollback();
            }
            
        }finally {
            session.close();
        }
    }
//Creación de la tabla 
   public TableModel listToCatProt(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        List results=session.createQuery("from CatalogoProductos", CatalogoProductos.class).getResultList();
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
     return new DefaultTableModel(rows,columnNames);
   }
    
    public boolean ValidarCatalogo(String txtProducto){
        Session session= HibernateUtil.getSessionFactory().openSession();
        boolean encontrado=false;
        CatalogoProductos foundcatpro=new CatalogoProductos();
        try{
            foundcatpro=(CatalogoProductos)session.createQuery("SELECT * FROM CatalogoProductos WHERE nombreProducto=="+txtProducto, CatalogoProductos.class);
            if(foundcatpro != null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            System.out.println("Error al validar existencia del producto dentro del catalogo "+err+" Error: ValCAT");
        }
        
        return encontrado;
    }
}
