
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.EstadoProducto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class CRUDEstadoProducto {
    
    public boolean save(EstadoProducto newEstPro){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean completado=false;
        
         try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            session.persist(newEstPro);
            transaction.commit();
            completado=true;
             
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
    
    public boolean update(EstadoProducto newEstPro, String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        EstadoProducto updateEstPro;
        boolean completado=false;
        try {
           
            transaction = session.beginTransaction();
            updateEstPro=session.get(EstadoProducto.class, ToID(nombre));
            updateEstPro.setEstado(newEstPro.getEstado());
            session.flush();
            session.clear();
            transaction.commit();
            completado=true;
            
        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null,"Hubo un error al actualizar\n"+err+"\n Error UPDATECRUD", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            session.close();
        }
        return completado;
    }
    
    public boolean delete(String estado){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        EstadoProducto delEstPro;
        boolean completado = false;
        try{
            transaction = session.beginTransaction();
            System.out.println("Transaction iniciada");
            delEstPro=session.find(EstadoProducto.class, ToID(estado));
            System.out.println("Eliminar registro");
            session.remove(delEstPro);
            session.flush();
            session.clear();
            transaction.commit();
            completado = true;
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                System.out.println("Hubo un problema al eliminar "+err+ " Error: DeteleCRUD");
            }
        }finally{
            session.close();
        }
        return completado;
    }
    public int ToID(String estado){
        Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idEstPro=-1;
          try{
              query=session.createQuery("SELECT idEstadoProducto FROM EstadoProducto WHERE estado =: estado",Integer.class);
              query.setParameter("estado",estado);
              idEstPro=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el id del estado del producto"+err+" Error: IDGAB", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          return idEstPro;
    }
    
    public boolean ValidarEstadoProducto(String estado){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        EstadoProducto foundAdmin;
        boolean encontrado=false;
        try{
            Query<EstadoProducto> query=session.createQuery("FROM EstadoProducto WHERE estado= :estado", EstadoProducto.class);
            query.setParameter("estado",estado);
            foundAdmin=query.uniqueResult();
            if(foundAdmin!= null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error al validar existencia del Estado Producto "+err+" Error: ValExt", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        
        return encontrado;
    }
    
    public List opRead(String crit, String field){//Este metodo recupera los registros de la base de datos mediante consultas
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<EstadoProducto> listadmin=null;
        Query<EstadoProducto> query;
         try{
            if(crit.equals("")){
                query=session.createQuery("FROM EstadoProducto", EstadoProducto.class);
                listadmin=query.getResultList();
            }
        }catch(Exception err){
             
             JOptionPane.showMessageDialog(null,"Error en la lectura "+err+" Error: opRead", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listadmin; 
    }
    
    public TableModel listTo(List results){///Este metodo crea la tabla de la interfaz
        
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        EstadoProducto estpro;
        
        columnNames.addElement("Estado del producto");
       
        Iterator itEstPro=results.iterator();
        
        while(itEstPro.hasNext()){
            estpro=(EstadoProducto)itEstPro.next();
            Vector newRow=new Vector();
            newRow.addElement(estpro.getEstado());
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
        List<EstadoProducto> results;
        results=opRead(crit,field);
        tm=listTo(results);
        return tm;
    }
}
