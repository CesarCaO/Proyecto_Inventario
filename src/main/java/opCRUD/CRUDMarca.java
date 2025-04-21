
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Marca;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class CRUDMarca {
    
    public boolean save(Marca newMarca){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean  completado = false;
         try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando registro");
            session.persist(newMarca);
            transaction.commit();
            completado = true;
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
     return completado;
    }
    
    public boolean delete(String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Marca delmarca;
        boolean completado = false;
        try{
            transaction = session.beginTransaction();
            System.out.println("Transaction iniciada");
            delmarca=session.find(Marca.class, ToID(nombre));
            System.out.println("Eliminar registro");
            session.remove(delmarca);
            session.flush();
            session.clear();
            transaction.commit();
            completado=true;
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                System.out.println("Hubo un problema al eliminar "+err+ " Error: UpdateCRUD");
            }
        }finally{
            session.close();
        }
       
       return completado;  
     }
    
    public boolean update(Marca newMarca, String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Marca updateMarca;
        boolean complete = false;
        try {  
            transaction = session.beginTransaction();
            updateMarca=session.get(Marca.class, ToID(nombre));
            updateMarca.setNombreMarca(newMarca.getNombreMarca());
            session.flush();
            session.clear();
            transaction.commit();
            complete = true;
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null,"Hubo un error al actualizar\n"+err+"\n Error UPDATECRUD", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            session.close();
        }
      return complete;
    }
    
    public int ToID(String marca){
          Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idGabinete=-1;
          try{
              query=session.createQuery("SELECT idMarca FROM Marca WHERE nombreMarca =: marca",Integer.class);
              query.setParameter("marca",marca);
              idGabinete=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el ID de la marca\n "+err+" \nError: ToID", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          System.out.println(idGabinete);
          return idGabinete;
    }
    
    public boolean ValidarExistencia(String nombre){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        Marca foundMarca;
        boolean encontrado=false;
        try{
            Query<Marca> query=session.createQuery("FROM Marca WHERE nombreMarca= :nombre", Marca.class);
            query.setParameter("nombre",nombre);
            foundMarca=query.uniqueResult();
            if(foundMarca!= null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error al validar existencia del la marca "+err+" Error: ValCAT", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        
        return encontrado;
        
    }
    
    public List opRead(String crit, String field){//Este metodo recupera los registros de la base de datos mediante consultas
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<Marca> listresults=null;
        Query<Marca> query;
         try{
            if(crit.equals("")){
                query=session.createQuery("FROM Marca", Marca.class);
                listresults=query.getResultList();

            }else{
                query=session.createQuery("FROM Marca WHERE "+ field +"  LIKE :crit",Marca.class);
                query.setParameter("crit",crit+"%");
                listresults=query.getResultList();
                System.out.println(listresults);
            }
        }catch(Exception err){
             
             JOptionPane.showMessageDialog(null,"Error al leer las marcas "+err+" Error: opRead", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listresults; 
    }
    
    public TableModel ListTo(List results){///Este metodo crea la tabla de la interfaz
        
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        Marca marca;
        
        columnNames.addElement("Nombre de la marca");
       
        Iterator itMarca=results.iterator();
        
        while(itMarca.hasNext()){
            marca=(Marca)itMarca.next();
            Vector newRow=new Vector();
            newRow.addElement(marca.getNombreMarca());
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
        List<Marca> results;
        results=opRead(crit,field);
        tm=ListTo(results);
        return tm;
    }
    
}
