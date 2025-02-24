
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Administrador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class CRUDAdmin {
    
    public void save(Administrador newadmin){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try{
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando administrador");
            session.persist(newadmin);
            transaction.commit();
            System.out.println("Se guardo administrador");
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                JOptionPane.showMessageDialog(null,"Hubo un problema al Guardar "+err+ " Error: SaveCRUD", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }finally{
            session.close();
        }
    }
    
     public void update(Administrador newadmin, int numCuenta){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Administrador oldadmin= new Administrador();
        
        try{
            System.out.println("Transaction iniciada");
            newadmin.setIdAdmin(ToID(numCuenta));
            if(newadmin.getContrasenia()==null){
                oldadmin=session.get(Administrador.class, newadmin.getIdAdmin());
                newadmin.setContrasenia(oldadmin.getContrasenia());
            }
            transaction = session.beginTransaction();
            System.out.println("Actualizar administrador");
            session.merge(newadmin);
            transaction.commit();
            System.out.println("Se actualizó administrador");
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                System.out.println("Hubo un problema al actualizar "+err+ " Error: UpdateCRUD");
            }
        }finally{
            session.close();
        }
    }
    
     public void delete(Administrador deladmin, int numCuenta){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try{
            System.out.println("Transaction iniciada");
            deladmin.setIdAdmin(ToID(numCuenta));
            transaction = session.beginTransaction();
            System.out.println("Eliminar administrador");
            session.remove(deladmin);
            transaction.commit();
            System.out.println("Se eliminó administrador");
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                System.out.println("Hubo un problema al eliminar "+err+ " Error: UpdateCRUD");
            }
        }finally{
            session.close();
        }
         
     }
    
    public boolean ValidarAdministrador(int numAdmin){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        Administrador foundAdmin;
        boolean encontrado=false;
        try{
            Query<Administrador> query=session.createQuery("FROM Administrador WHERE cuentaAdmin= :cuenta", Administrador.class);
            query.setParameter("cuenta",numAdmin);
            foundAdmin=query.uniqueResult();
            if(foundAdmin!= null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error al validar existencia del Administrador "+err+" Error: ValCAT", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        
        return encontrado;
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
//*******************************************  Metodos para buscar y crear la tabla ******************************************//
    public List opRead(String crit, String field){//Este metodo recupera los registros de la base de datos mediante consultas
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<Administrador> listcatpro=null;
        Query<Administrador> query;
         try{
            if(crit.equals("")){
                query=session.createQuery("FROM Administrador", Administrador.class);
                listcatpro=query.getResultList();

            }else{
                query=session.createQuery("FROM Administrador WHERE CAST("+ field +" AS string) LIKE :crit", Administrador.class);
                query.setParameter("crit",crit+"%");
                listcatpro=query.getResultList();
                System.out.println(listcatpro);
            }
        }catch(Exception err){
             
             JOptionPane.showMessageDialog(null,"Error al leer el administrador "+err+" Error: opRead", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listcatpro; 
    }
    
    public TableModel listToAdmin(List results){///Este metodo crea la tabla de la interfaz
        
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        Administrador admin;
        
        columnNames.addElement("Número de cuenta");
        columnNames.addElement("Apellido Paterno");
        columnNames.addElement("Apellido Materno");
        columnNames.addElement("Nombre(s)");
        columnNames.addElement("Correo electrónico");
        columnNames.addElement("Teléfono");
       
        Iterator itCatPro=results.iterator();
        
        while(itCatPro.hasNext()){
            admin=(Administrador)itCatPro.next();
            Vector newRow=new Vector();
            newRow.addElement(admin.getCuentaAdmin());
            newRow.addElement(admin.getApellidoPaterno());
            newRow.addElement(admin.getApellidoMaterno());
            newRow.addElement(admin.getNombre());
            newRow.addElement(admin.getCorreo());
            newRow.addElement(admin.getTelefono());
            rows.addElement(newRow);
        }
     return new DefaultTableModel(rows,columnNames){
         @Override
         public boolean isCellEditable(int row, int column){
             return false;
         }
     };
   }
    
    public TableModel opBuscar(String field, String crit){ ///Este metodo determina el campo con el cual se van a buscar los registro dentro de la base de datos
        TableModel tm=null;
        List<Administrador> results;
        switch(field){
            case "Número de cuenta" -> {
                results=opRead(crit, "cuentaAdmin");
                tm=listToAdmin(results);
            }
            
            case "Nombre del administrador" ->{
                results=opRead(crit,"nombre");
                tm=listToAdmin(results);
            }
            case "Apellido paterno del administrador" ->{
                results=opRead(crit,"apellidoPaterno");
                tm=listToAdmin(results);
            }
            case "Apellido materno del administrador" ->{
                results=opRead(crit,"apellidoMaterno");
                tm=listToAdmin(results);
            }
            case "Teléfono"->{
                results=opRead(crit,"telefono");
                tm=listToAdmin(results);
            }
        }
        return tm;
    }
}


