
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
 @Table(name="estado_prestamo")
public class Estado_prestamo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_estado")
    private int id_estado;
    
    @Column(name="estado")
    private String estado;
    
    @OneToMany(mappedBy="estado_prestamo", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Estado_prestamo(int id_estado, String estado) {
        this.id_estado = id_estado;
        this.estado = estado;
    }
    
    public Estado_prestamo(){}

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_estado() {
        return id_estado;
    }

    public String getEstado() {
        return estado;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Estado de prestamos\n"+
                "ID: "+id_estado+"\n"+
                "Nombre del producto: "+estado+"\n";
    }
}
