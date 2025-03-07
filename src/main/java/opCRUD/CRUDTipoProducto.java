
package opCRUD;

import Util.HibernateUtil;
import javax.swing.JOptionPane;
import models.TipoProducto;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CRUDTipoProducto {
    public void save(TipoProducto newtipoPro){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
         try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando registro");
            session.persist(newtipoPro);
            transaction.commit();
             System.out.println("Se guardo el registro");
            
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
    public void update(TipoProducto newtipoPro, String tipoPro){
        
        
    }
}
