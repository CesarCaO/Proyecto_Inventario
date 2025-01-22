
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
 @Table(name="estadoPrestamo")
public class EstadoPrestamo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idEstado")
    private int idEstado;
    
    @Column(name="estado")
    private String estado;
    
    //@OneToMany(mappedBy="estado_prestamo", cascade=CascadeType.ALL,orphanRemoval=true)
    //private List<Producto> producto= new ArrayList<>();

    public EstadoPrestamo(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
  
    public int getIdEstado() {
        return idEstado;
    }
    
     public String getEstado() {
        return estado;
    }

   
//    public void setProducto(List<Producto> producto) {
//        this.producto = producto;
//    }
   

//    public List<Producto> getProducto() {
//        return producto;
//    }
    @Override
    public String toString() {
        return "Estado de prestamos\n"+
                "ID: "+idEstado+"\n"+
                "Nombre del producto: "+estado+"\n";
    }
}
