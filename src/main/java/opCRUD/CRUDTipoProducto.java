
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.TipoProducto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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
    public void update(TipoProducto newtipoPro,String tipoPro){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        TipoProducto updateTipoPro;
        try {
            transaction = session.beginTransaction();
            updateTipoPro=session.get(TipoProducto.class, ToID(tipoPro));
            updateTipoPro.setTipo(newtipoPro.getTipo());
            session.flush();
            session.clear();
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
    
    public void delete(String tipoPro){
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        TipoProducto delTipoPro=new TipoProducto();
        try{
            transaction = session.beginTransaction();
            System.out.println("Transaction iniciada");
            delTipoPro=session.find(TipoProducto.class, ToID(tipoPro));
            System.out.println("Eliminar registro");
            session.remove(delTipoPro);
            session.flush();
            session.clear();
            transaction.commit();
            System.out.println("Se eliminó el registro");
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                System.out.println("Hubo un problema al eliminar "+err+ " Error: DeleteCRUD");
            }
        }finally{
            session.close();
        }
    }
    
    public boolean ValidarTipo(String tipoPro){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        TipoProducto foundAdmin;
        boolean encontrado=false;
        try{
            Query<TipoProducto> query=session.createQuery("FROM TipoProducto WHERE tipo= :tipo", TipoProducto.class);
            query.setParameter("tipo",tipoPro);
            foundAdmin=query.uniqueResult();
            if(foundAdmin!= null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error al validar existencia del tipo del producto "+err+" Error: ValExt", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        
        return encontrado;
        
    }
    
    public int ToID(String tipoPro){
        Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idEstPro=-1;
          try{
              query=session.createQuery("SELECT idTipoProducto FROM TipoProducto WHERE tipo =: tipo",Integer.class);
              query.setParameter("tipo",tipoPro);
              idEstPro=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el id del estado del producto"+err+" Error: IDGAB", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          return idEstPro;
    }
    
 /////////////////////////////Crear y rellenar la tabla////////////////////////////////
     public List opRead(String crit, String field){//Este metodo recupera los registros de la base de datos mediante consultas
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<TipoProducto> listadmin=null;
        Query<TipoProducto> query;
         try{
            if(crit.equals("")){
                query=session.createQuery("FROM TipoProducto", TipoProducto.class);
                listadmin=query.getResultList();
            }
        }catch(Exception err){
             
             JOptionPane.showMessageDialog(null,"Error en la lectura "+err+" Error: opRead", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listadmin; 
    }
     
    public TableModel listTo(List results){
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        TipoProducto tipoPro;
        
        columnNames.addElement("Tipo del producto");
       
        Iterator itTipoPro=results.iterator();
        
        while(itTipoPro.hasNext()){
            tipoPro=(TipoProducto)itTipoPro.next();
            Vector newRow=new Vector();
            newRow.addElement(tipoPro.getTipo());
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
        List<TipoProducto> results;
        results=opRead(crit, field);
        tm=listTo(results);
        return tm;
    }
 /////////////////////////////////////////////////////////////////////////////////////
}
