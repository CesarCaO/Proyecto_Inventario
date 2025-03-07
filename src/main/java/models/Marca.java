package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Marca")
public class Marca implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idMarca")
    private int idMarca;
    
    @Column(name="nombreMarca")
    private String nombreMarca;
    
    @OneToMany(mappedBy="marca", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Marca(int id_marca, String nombreMarca) {
        this.idMarca = id_marca;
        this.nombreMarca = nombreMarca;
    }

    public Marca(){}

    public void setIdMarca(int id_marca) {
        this.idMarca = id_marca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    
    
    @Override
    public String toString(){
        return "Marca\n"+
                "ID: "+idMarca+"\n"+
                "Nombre de la Marca"+nombreMarca+"\n";
    }
    
    
    
    
}
