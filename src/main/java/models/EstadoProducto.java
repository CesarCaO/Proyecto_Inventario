
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="estadoproducto")
public class EstadoProducto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idEstadoProducto")
    private int idEstadoProducto;
    
    @Column(name="estado")
    private String estado;
    
    @OneToMany(mappedBy="estadoProducto", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public EstadoProducto(int id_estadoProducto, String estado) {
        this.idEstadoProducto = id_estadoProducto;
        this.estado = estado;
    }
    
    public EstadoProducto(){}

    public void setId_estadoProducto(int id_estadoProducto) {
        this.idEstadoProducto = id_estadoProducto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_estadoProducto() {
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
