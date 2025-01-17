
package models;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Catalogo_productosDAO {
    public boolean save(Catalogo_productos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
         boolean bandera= false;

        try {
            transaction = session.beginTransaction();
            session.persist(newcatpro);
            transaction.commit();
            bandera=true;
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("El error en el metodo de guardar es: "+err);
                bandera=false;
            }

        } finally {
            session.close();
        }
       return bandera;
    }

    public boolean update(Catalogo_productos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean bandera= false;

        try {
            transaction = session.beginTransaction();
            session.merge(newcatpro);
            transaction.commit();
            bandera=true;

        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                bandera=false;
            }
        } finally {
            session.close();
        }
    return bandera;
    }
    
    public void delete(Catalogo_productos catpro){
        
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
    
    public List<Catalogo_productos> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<Catalogo_productos> listcatpro= null;
        
        try{
            listcatpro=session.createQuery("Select nombre_producto from catalogo_productos",Catalogo_productos.class).list();
            System.out.println("Se recuperaron: "+listcatpro.size()+" producto(s) dentro del catalgo de productos");
        }catch(Exception err){
            System.out.println("Error al obtener los productos del catalogo");
        }finally{
            session.close();
        }
        return listcatpro;
    }
}
