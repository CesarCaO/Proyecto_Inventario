
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
            
            cfg.addAnnotatedClass(Models.Administrador.class);
            cfg.addAnnotatedClass(Models.Catalogo_productos.class);
            cfg.addAnnotatedClass(Models.Estado_prestamo.class);
            cfg.addAnnotatedClass(Models.Estado_producto.class);
            cfg.addAnnotatedClass(Models.Gabinete.class);
            cfg.addAnnotatedClass(Models.Marca.class);
            cfg.addAnnotatedClass(Models.Producto.class);
            cfg.addAnnotatedClass(Models.Tipo_producto.class);
            
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
