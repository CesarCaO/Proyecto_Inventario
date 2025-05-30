
package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author darwi
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory=buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration cfg= new Configuration();
            cfg.configure("hibernate.cfg.xml");
            
            cfg.addAnnotatedClass(models.Administrador.class);
            cfg.addAnnotatedClass(models.CatalogoProductos.class);
            cfg.addAnnotatedClass(models.EstadoProducto.class);
            cfg.addAnnotatedClass(models.Gabinete.class);
            cfg.addAnnotatedClass(models.Marca.class);
            cfg.addAnnotatedClass(models.Producto.class);
            cfg.addAnnotatedClass(models.TipoProducto.class);
            
            return cfg.buildSessionFactory();
        }catch(Throwable ex){
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
            
        }
        
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     public static void shutdown() {
        getSessionFactory().close();
    }
}
