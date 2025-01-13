package CRUD;

import Util.HibernateUtil;
import Models.Catalogo_productos;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CRUDCatalogoProducto {

    public void save(Catalogo_productos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(newcatpro);
            transaction.commit();
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            session.close();
        }

    }

    public void update(Catalogo_productos newcatpro) {

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

}
