
package opCRUD;

import models.Producto;

public class CRUDProducto {
    CRUDAdmin crudAdmin= new CRUDAdmin();
    CRUDCatalogoProductos crudCatPro=new CRUDCatalogoProductos();
    CRUDGabinete crudGabinete = new CRUDGabinete();
    CRUDMarca crudMarca = new CRUDMarca();
    
    public void save(Producto producto, String marca, String tipoProducto, String catalogoProducto, int numGabinete, String estadoProducto, int cuentaAdmin){
        
        
    }
}
