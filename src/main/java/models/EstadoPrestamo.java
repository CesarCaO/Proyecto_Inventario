
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
 @Table(name="EstadoPrestamo")
public class EstadoPrestamo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idEstado")
    private int idEstado;
    
    @Column(name="estado")
    private String estado;
    
//    @OneToMany(mappedBy="estadoPrestamo", cascade=CascadeType.ALL,orphanRemoval=true)
//    private List<Producto> producto= new ArrayList<>();

    public EstadoPrestamo(int id_estado, String estado) {
        this.idEstado = id_estado;
        this.estado = estado;
    }
    
    public EstadoPrestamo(){}

    public void setId_estado(int id_estado) {
        this.idEstado = id_estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

//    public void setProducto(List<Producto> producto) {
//        this.producto = producto;
//    }

    public int getId_estado() {
        return idEstado;
    }

    public String getEstado() {
        return estado;
    }

//    public List<Producto> getProducto() {
//        return producto;
//    }
    
    @Override
    public String toString(){
        return "Estado de prestamos\n"+
                "ID: "+idEstado+"\n"+
                "Nombre del producto: "+estado+"\n";
    }
}
