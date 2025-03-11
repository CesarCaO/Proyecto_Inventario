
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TipoProducto")
public class TipoProducto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idTipoProducto")
    private int idTipoProducto;
    
    @Column(name="tipo")
    private String tipo;
    
    @OneToMany(mappedBy="tipoProducto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public TipoProducto(int idTipoProducto, String tipo) {
        this.idTipoProducto = idTipoProducto;
        this.tipo = tipo;
    }

    public TipoProducto(){}

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
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
                "ID: "+idTipoProducto+"\n"+
                "Tipo: "+tipo+"\n";
    }
    
}
