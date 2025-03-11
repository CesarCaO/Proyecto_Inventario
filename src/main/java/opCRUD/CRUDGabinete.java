
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
        Gabinete updateGabinete;
        try {
            
            transaction = session.beginTransaction();
            updateGabinete=session.get(Gabinete.class, ToID(numOldGabinete));
            updateGabinete.setNumGabinete(newGabinete.getNumGabinete());
            updateGabinete.setDescripcion(newGabinete.getDescripcion());
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
    
     public void delete(int numero){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Gabinete delGab;
        try{
            transaction = session.beginTransaction();
            System.out.println("Transaction iniciada");
            delGab=session.find(Gabinete.class, ToID(numero));
            System.out.println("Eliminar registro");
            session.remove(delGab);
            session.flush();
            session.clear();
            transaction.commit();
        }catch(Exception err){
            if(transaction!=null){
                transaction.rollback();
                System.out.println("Hubo un problema al eliminar "+err+ " Error: UpdateCRUD");
            }
        }finally{
            session.close();
        }
         
     }
    public int ToID(int numero){
          Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idGabinete=-1;
          try{
              query=session.createQuery("SELECT idGabinete FROM Gabinete WHERE numGabinete =: numero",Integer.class);
              query.setParameter("numero",numero );
              idGabinete=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el id del Gabinete"+err+" Error: IDGAB", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          System.out.println(idGabinete);
          return idGabinete;
    }
    
    public boolean validarGabinete(int numero){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        Gabinete foundGabinete;
        boolean encontrado=false;
        
        try{
             Query<Gabinete> query=session.createQuery("FROM Gabinete WHERE numGabinete= :numero", Gabinete.class);
            query.setParameter("numero",numero);
            foundGabinete=query.uniqueResult();
            if(foundGabinete!= null){
                encontrado=true;
                return encontrado;
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error al validar existencia del Gabinete "+err+" Error: ValCAT", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        
        return encontrado;
    }
    
    
    //*******************************************  Metodos para buscar y crear la tabla ******************************************//
    public List opRead(String crit, String field){//Este metodo recupera los registros de la base de datos mediante consultas
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<Gabinete> listcatpro=null;
        Query<Gabinete> query;
         try{
            if(crit.equals("")){
                query=session.createQuery("FROM Gabinete", Gabinete.class);
                listcatpro=query.getResultList();

            }else{
                query=session.createQuery("FROM Gabinete WHERE CAST("+ field +" AS string) LIKE :crit",Gabinete.class);
                query.setParameter("crit",crit+"%");
                listcatpro=query.getResultList();
                System.out.println(listcatpro);
            }
        }catch(Exception err){
             
             JOptionPane.showMessageDialog(null,"Error al leer el gabinete "+err+" Error: opRead", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listcatpro; 
    }
    
    public TableModel ListTo(List results){///Este metodo crea la tabla de la interfaz
        
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        Gabinete gabinete;
        
        columnNames.addElement("Número de gabinete");
        columnNames.addElement("Descripción del gabinete");
        
       
        Iterator itGabinete=results.iterator();
        
        while(itGabinete.hasNext()){
            gabinete=(Gabinete)itGabinete.next();
            Vector newRow=new Vector();
            newRow.addElement(gabinete.getNumGabinete());
            newRow.addElement(gabinete.getDescripcion());
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
        List<Gabinete> results;
        results=opRead(crit,field);
        tm=ListTo(results);
        return tm;
    }
}
