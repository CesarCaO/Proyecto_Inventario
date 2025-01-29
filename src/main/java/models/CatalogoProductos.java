
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CatalogoProductos")
public class CatalogoProductos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idCatpro")
    private int idCatpro;
    
    @Column(name="nombreProducto")
    private String nombreProducto;
    
    @OneToMany(mappedBy="catalogoProducto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public CatalogoProductos(int idCatpro, String nombre_producto) {
        this.idCatpro = idCatpro;
        this.nombreProducto = nombre_producto;
    }
    
    public CatalogoProductos(){}

    public void setId_catpro(int id_catpro) {
        this.idCatpro = id_catpro;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombreProducto = nombre_producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_catpro() {
        return idCatpro;
    }

    public String getNombre_producto() {
        return nombreProducto;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Catalogo del productos\n"+
                "ID: "+idCatpro+"\n"+
                "Nombre del producto"+nombreProducto+"\n";
    }
}
