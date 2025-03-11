
package opCRUD;

import Util.HibernateUtil;
import javax.swing.JOptionPane;
import models.Administrador;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;


public class LoginUtil {
    public Administrador obtenerAdmin(int numCuenta){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Administrador admin= null;
        
        try{
            admin=session.get(Administrador.class, ToID(numCuenta));
            return admin;
        }catch(Exception err){
            
            JOptionPane.showMessageDialog(null, "Error al validar el administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        return admin;
        
    }
    
    public boolean validarContrasenia(String inputPassword, Administrador admin){
       boolean valida=false;
        
        try{
            if(BCrypt.checkpw(inputPassword, admin.getContrasenia())){
                System.out.println("La contraseña es correcta");
                return valida=true;
            }else{
                 JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "Error al validar la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
        }finally{
            inputPassword=null;
        }
        
        return valida;
       
    }
    public int ToID(int numCuenta){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Integer>query;
        int idAdmin=-1;
        
        try{
            query=session.createQuery("SELECT idAdmin FROM  Administrador WHERE cuentaAdmin =:numCuenta",Integer.class);
            query.setParameter("numCuenta", numCuenta);
            idAdmin=query.uniqueResult();
        }catch(Exception err){
            System.out.println("Error al encontrar el id del Administrador\n"+err+" Error: ToID");
        }finally{
            session.close();
        }
        return idAdmin;
    }
}
