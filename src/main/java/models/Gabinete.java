
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="gabinete")
public class Gabinete {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_gabinete")
    private int id_gabinete;
    
    @Column(name="num_gabinete")
    private int num_gabinete;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy="gabinete", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Gabinete(int id_gabinete, int num_gabinete, String descripcion) {
        this.id_gabinete = id_gabinete;
        this.num_gabinete = num_gabinete;
        this.descripcion = descripcion;
    }
    
    public Gabinete (){}
    
    public void setId_gabinete(int id_gabinete) {
        this.id_gabinete = id_gabinete;
    }

    public void setNum_gabinete(int num_gabinete) {
        this.num_gabinete = num_gabinete;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_gabinete() {
        return id_gabinete;
    }

    public int getNum_gabinete() {
        return num_gabinete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Gabinete\n"+
                "ID: "+id_gabinete+"\n"+
                "Numero de gabinete: "+num_gabinete+"\n"+
                "Descripcion: "+descripcion+"\n";
    }
    
    
}
