
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="catalogo_productos")
public class Catalogo_productos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_catpro")
    private int id_catpro;
    
    @Column(name="nombre_producto")
    private String nombre_producto;
    
    @OneToMany(mappedBy="catalogo_producto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Catalogo_productos(int id_catpro, String nombre_producto) {
        this.id_catpro = id_catpro;
        this.nombre_producto = nombre_producto;
    }
    
    public Catalogo_productos(){}

    public void setId_catpro(int id_catpro) {
        this.id_catpro = id_catpro;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_catpro() {
        return id_catpro;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Catalogo del productos\n"+
                "ID: "+id_catpro+"\n"+
                "Nombre del producto"+nombre_producto+"\n";
    }
}
