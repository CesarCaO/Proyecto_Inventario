
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
    @Column(name="idGabinete")
    private int idGabinete;
    
    @Column(name="numGabinete")
    private int numGabinete;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy="gabinete", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Gabinete(int idGabinete, int numGabinete, String descripcion) {
        this.idGabinete = idGabinete;
        this.numGabinete = numGabinete;
        this.descripcion = descripcion;
    }
    
    public Gabinete(){}

    public void setIdGabinete(int idGabinete) {
        this.idGabinete = idGabinete;
    }

    public void setNumGabinete(int numGabinete) {
        this.numGabinete = numGabinete;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdGabinete() {
        return idGabinete;
    }

    public int getNumGabinete() {
        return numGabinete;
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
                "ID: "+idGabinete+"\n"+
                "Numero de gabinete: "+numGabinete+"\n"+
                "Descripcion: "+descripcion+"\n";
    }
    
    
}
