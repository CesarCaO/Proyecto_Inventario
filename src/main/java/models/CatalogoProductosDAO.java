
package models;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CatalogoProductosDAO {
    public boolean save(CatalogoProductos newcatpro) {

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

    public boolean update(CatalogoProductos newcatpro) {

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
    
    public List<CatalogoProductos> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CatalogoProductos> listcatpro= null;
        
        try{
            listcatpro=session.createQuery("FROM CatalogoProductos",CatalogoProductos.class).list();
            if(!listcatpro.isEmpty()){
            System.out.println("Se recuperaron: "+listcatpro.size()+" producto(s) dentro del catalgo de productos");
            }else{
                System.out.println("No se recuperó ningun registro");
            }
        }catch(Exception err){
            System.out.println("Error al obtener los productos del catalogo "+err);
        }finally{
            session.close();
        }
        return listcatpro;
    }
}
