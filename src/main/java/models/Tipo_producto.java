
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tipo_producto")
public class Tipo_producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tipoProducto")
    private int id_tipoProducto;
    
    @Column(name="tipo")
    private String tipo;
    
    @OneToMany(mappedBy="tipo_producto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Tipo_producto(int id_tipoProducto, String tipo) {
        this.id_tipoProducto = id_tipoProducto;
        this.tipo = tipo;
    }
    
    public Tipo_producto(){}
    
    public void setId_tipoProducto(int id_tipoProducto) {
        this.id_tipoProducto = id_tipoProducto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_tipoProducto() {
        return id_tipoProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
 @Override
    public String toString(){
        return "Tipo producto\n"+
                "ID: "+id_tipoProducto+"\n"+
                "Tipo: "+tipo+"\n";
    }
    
}
