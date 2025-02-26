
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="EstadoProducto")
public class EstadoProducto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idEstadoProducto")
    private int idEstadoProducto;
    
    @Column(name="estado")
    private String estado;
    
    @OneToMany(mappedBy="estadoProducto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public EstadoProducto(int idEstadoProducto, String estado) {
        this.idEstadoProducto = idEstadoProducto;
        this.estado = estado;
    }

    public EstadoProducto (){}

    public void setIdEstadoProducto(int idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdEstadoProducto() {
        return idEstadoProducto;
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
                "ID: "+idEstadoProducto+"\n"+
                "Estado: "+estado+"\n";
    }
    
}
