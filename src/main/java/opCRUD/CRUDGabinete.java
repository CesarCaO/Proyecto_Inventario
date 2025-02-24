
package opCRUD;

import Util.HibernateUtil;
import javax.swing.JOptionPane;
import models.Gabinete;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class CRUDGabinete {
    
    public void save(Gabinete newGabinete){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
         try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando producto en el catalogo");
            session.persist(newGabinete);
            transaction.commit();
             System.out.println("Se guardo el producto en el catalogo");
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                System.out.println("El error en el metodo de guardar es: "+err);
                JOptionPane.showMessageDialog(null,"Hubo un error al dar de alta el registro\n"+err+"\n Error SAVECRUD", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            session.close();
        }
    }
    
    public void update(Gabinete newGabinete, int numOldGabinete){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            
            newGabinete.setId_gabinete(NameToID(numOldGabinete));
            transaction = session.beginTransaction();
            session.merge(newGabinete);
            transaction.commit();
            

        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null,"Hubo un error al actualizar\n"+err+"\n Error UPDATECRUD", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            session.close();
        }
    }
    
   
    public int NameToID(int numero){
          Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idcatpro=-1;
          try{
              query=session.createQuery("SELECT idGabinete FROM Gabinete WHERE numGabinete =: numero",Integer.class);
              query.setParameter("numero",numero );
              idcatpro=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el id del Gabinete"+err+" Error: IDGAB", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          System.out.println(idcatpro);
          return idcatpro;
    }
}
