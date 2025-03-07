
package opCRUD;

import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.CatalogoProductos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CRUDCatalogoProductos {
    public void save(CatalogoProductos newcatpro) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
         

        try {
            System.out.println("Transaction iniciada");
            transaction = session.beginTransaction();
            System.out.println("Guardando producto en el catalogo");
            session.persist(newcatpro);
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

    public void update(CatalogoProductos newcatpro, String oldcatproName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            
            newcatpro.setId_catpro(NameToID(oldcatproName));
            transaction = session.beginTransaction();
            session.merge(newcatpro);
            transaction.commit();
            

        } catch (Exception err) {

            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null,"Hubo un error al actualizar\n"+err+"\n Error UPDATECRUDAdmin", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            session.close();
        }
    
    }
    
    public boolean delete(CatalogoProductos delcatpro,String oldcatproName){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean completado=false;
        try{
            delcatpro.setId_catpro(NameToID(oldcatproName));
            transaction = session.beginTransaction();
            session.remove(delcatpro);
            transaction.commit();
            completado=true;

            
        }catch(Exception err){
            
            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null,"Hubo un error al eliminar\n"+err+"\n Error DElCRUDAdmin", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }finally {
            session.close();
        }
        return completado;

    }
    
    public List opRead(String crit){
        Session session=HibernateUtil.getSessionFactory().openSession();
        System.out.println(crit);
        List<CatalogoProductos> listcatpro=null;
        Query<CatalogoProductos> query;
        try{
            if(crit.equals("")){
                query=session.createQuery("FROM CatalogoProductos", CatalogoProductos.class);
                listcatpro=query.getResultList();

            }else{
                query=session.createQuery("FROM CatalogoProductos WHERE nombreProducto LIKE :crit", CatalogoProductos.class);
                query.setParameter("crit",crit+"%");
                listcatpro=query.getResultList();
                System.out.println(listcatpro);
            }
        }catch(Exception err){
             
             JOptionPane.showMessageDialog(null,"Error al leer los productos del catalogo "+err+" Error: opRead", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listcatpro;
    }
//Creación de la tabla 
   public TableModel listToCatPro(List results){
        
        
        Vector columnNames=new Vector();
        Vector rows=new Vector();
        
        CatalogoProductos catpro;
        
        columnNames.addElement("Nombre Producto");
        
        Iterator itCatPro=results.iterator();
        
        while(itCatPro.hasNext()){
            catpro=(CatalogoProductos)itCatPro.next();
            Vector newRow=new Vector();
            newRow.addElement(catpro.getNombre_producto());
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
        List<CatalogoProductos> results;
        switch(field){
            case "Nombre del Producto":
                results=opRead(crit);
                tm=listToCatPro(results);
            break;
        }
        return tm;
    }
    
    public boolean ValidarCatalogo(String txtProducto){
        Session session= HibernateUtil.getSessionFactory().openSession();
        
        CatalogoProductos foundcatpro=new CatalogoProductos();
        boolean encontrado=false;
        try{
            Query<CatalogoProductos> query=session.createQuery("FROM CatalogoProductos WHERE nombreProducto= :nombre", CatalogoProductos.class);
            query.setParameter("nombre", txtProducto);
            foundcatpro=query.uniqueResult();
            if(foundcatpro != null){
                encontrado=true;
                return encontrado;
            }
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error al validar existencia del producto dentro del catalogo "+err+" Error: ValCAT", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            session.close();
        }
        
        return encontrado;
    }
    
    public int NameToID(String name){
          Session session= HibernateUtil.getSessionFactory().openSession();
          Query<Integer>query;
          int idcatpro=-1;
          try{
              query=session.createQuery("SELECT idCatpro FROM CatalogoProductos WHERE nombreProducto =: nombre",Integer.class);
              query.setParameter("nombre",name );
              idcatpro=query.uniqueResult();
          }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error al encontrar el id del producto dentro del catalogo "+err+" Error: IDCAT", "Error", JOptionPane.ERROR_MESSAGE);
          }finally{
              session.close();
          }
          System.out.println(idcatpro);
          return idcatpro;
    }
    
}
