
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CatalogoProductos")
public class CatalogoProductos implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idCatpro")
    private int idCatpro;
    
    @Column(name="nombreProducto")
    private String nombreProducto;
    
    @OneToMany(mappedBy="catalogoProductos", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public CatalogoProductos(int idCatpro, String nombreProducto) {
        this.idCatpro = idCatpro;
        this.nombreProducto = nombreProducto;
    }
    
    public CatalogoProductos(){}

    public int getIdCatpro() {
        return idCatpro;
    }

    public void setIdCatpro(int idCatpro) {
        this.idCatpro = idCatpro;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    
    
  
    
    @Override
    public String toString(){
        return "Catalogo del productos\n"+
                "ID: "+idCatpro+"\n"+
                "Nombre del producto"+nombreProducto+"\n";
    }
}
