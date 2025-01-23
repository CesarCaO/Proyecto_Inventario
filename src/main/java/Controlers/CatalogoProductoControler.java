
package Controlers;

import models.Catalogo_productos;
import models.Catalogo_productosDAO;
import Views.ViewCatalogoProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CatalogoProductoControler{
    
    
    Catalogo_productosDAO catproDAO;
    ViewCatalogoProducto viewcatpro;

    public CatalogoProductoControler(ViewCatalogoProducto viewcatpro) {
       
        this.viewcatpro = viewcatpro;
        this.catproDAO = new Catalogo_productosDAO();
        //Agregar el ActionListener de los botones
        this.viewcatpro.addInsertActionListener(new SaveActionListener());
        this.viewcatpro.addUpdateActionListener(new UpdateActionListener());
        this.viewcatpro.addDeleteActionListener(new DeleteActionListener());
        //Rellenar la tabla
        this.viewcatpro.actualizarTabla(catproDAO.getAll());
        
        
    }
    //Crear las clases para las operacione CRUD
    //Crear las clases para las operacione CRUD
    
    class SaveActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!viewcatpro.validacionNombre()){
                return;
            }
            Catalogo_productos newcatpro= new Catalogo_productos();
            
            newcatpro.setNombre_producto(viewcatpro.getTxtProducto());
            
            catproDAO.save(newcatpro);
            viewcatpro.actualizarTabla(catproDAO.getAll());//Actualizar tabla despues de una insercion
            viewcatpro.clean();
            
        }   
    }
    
    class UpdateActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!viewcatpro.validacionNombre()){
                return;
            }
            Catalogo_productos newcatpro= new Catalogo_productos();
            
            newcatpro.setNombre_producto(viewcatpro.getTxtProducto());
            
            catproDAO.update(newcatpro);
            viewcatpro.actualizarTabla(catproDAO.getAll());//Actualizar tabla despues de una insercion
            viewcatpro.clean();
        }   
    }
    
    class DeleteActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!viewcatpro.validacionNombre()){
                return;
            }
            Catalogo_productos newcatpro= new Catalogo_productos();
            
            newcatpro.setNombre_producto(viewcatpro.getTxtProducto());
            
            catproDAO.delete(newcatpro);
            viewcatpro.actualizarTabla(catproDAO.getAll());//Actualizar tabla despues de una insercion
            viewcatpro.clean();
        }   
    }
     
    
}
