
package Controlers;

import models.Catalogo_productos;
import models.Catalogo_productosDAO;
import Views.CatalogoProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CatalogoProductoControler implements ActionListener{
    
    private Catalogo_productos catpro;
    private Catalogo_productosDAO catproDAO;
    private CatalogoProducto viewcatpro;

    public CatalogoProductoControler(Catalogo_productos catpro, Catalogo_productosDAO catproDAO, CatalogoProducto viewcatpro) {
        this.catpro = catpro;
        this.catproDAO = catproDAO;
        this.viewcatpro = viewcatpro;
        //Agregar el ActionListener de los botones
        this.viewcatpro.btnAgregar.addActionListener(this);
        this.viewcatpro.btnActualizar.addActionListener(this);
        this.viewcatpro.btnEliminar.addActionListener(this);
        //Rellenar la tabla
        this.viewcatpro.actualizarTabla(catproDAO.getAll());
        
        
    }
    
    //metodo para iniciar la vista
    
    public void iniciar(){
        
        viewcatpro.setTitle("Catalogo de productos");
        viewcatpro.setLocationRelativeTo(null);
        
    }
    @Override
   public void actionPerformed(ActionEvent e){
       
       if(e.getSource() == viewcatpro.btnAgregar){
           catpro.setNombre_producto(viewcatpro.txtProducto.getText());
           
           if(catproDAO.save(catpro)){
               JOptionPane.showMessageDialog(null, "Registro guardado");
               limpiar();
           }else{
               JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro");
               limpiar();
           }
       }
       
        if(e.getSource() == viewcatpro.btnActualizar){
           catpro.setNombre_producto(viewcatpro.txtProducto.getText());
           
           if(catproDAO.update(catpro)){
               JOptionPane.showMessageDialog(null, "Registro modificado");
               limpiar();
           }else{
               JOptionPane.showMessageDialog(null, "Hubo un problema al modificar el registro");
               limpiar();
           }
       }
   }
   
   public void limpiar(){
       viewcatpro.txtProducto.setText(null);
   }
    
    
    
}
