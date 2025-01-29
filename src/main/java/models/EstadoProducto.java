
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="estado_producto")
public class EstadoProducto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_estadoProducto")
    private int id_estadoProducto;
    
    @Column(name="estado")
    private String estado;
    
    @OneToMany(mappedBy="estadoProducto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public EstadoProducto(int id_estadoProducto, String estado) {
        this.id_estadoProducto = id_estadoProducto;
        this.estado = estado;
    }
    
    public EstadoProducto(){}

    public void setId_estadoProducto(int id_estadoProducto) {
        this.id_estadoProducto = id_estadoProducto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_estadoProducto() {
        return id_estadoProducto;
    }

    public String getEstado() {
        return estado;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Estado Producto\n"+
                "ID: "+id_estadoProducto+"\n"+
                "Estado: "+estado+"\n";
    }
    
}
