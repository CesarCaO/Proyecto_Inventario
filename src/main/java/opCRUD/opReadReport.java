
package opCRUD;

import Util.HibernateUtil;
import java.util.List;
import models.ProductoReportDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class opReadReport {
    
    
    public List opRead_Excel(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<ProductoReportDTO> listproductoR=null;
        Query<ProductoReportDTO> query;
        try{
        query= session.createQuery(" SELECT NEW models.ProductoReportDTO(p.numInventario, cp.nombreProducto, m.nombreMarca, tp.tipo, "
                        + "g.numGabinete, ep.estado, p.descripcion, p.modelo, p.serie, p.inventario_institucional, p.cantidadStock, "
                        + "p.fechaRegistro) FROM Producto p "
                        + "JOIN p.catalogoProducto cp "
                        + "JOIN p.marca m "
                        + "JOIN p.tipoProducto tp "
                        + "JOIN p.gabinete g "
                        + "JOIN p.estadoProducto ep", ProductoReportDTO.class);
        
        listproductoR=query.getResultList();
       
        }catch(Exception err){
            System.out.println("Error al leer los productos " + err + " Error: opReadReport");
        }finally{
            session.close();
        }
        return listproductoR;
    }
       
}
