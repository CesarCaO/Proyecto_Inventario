
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idAdmin")
    private int idAdmin;
    
    @Column(name="cuentaAdmin")
    private int cuentaAdmin;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="contrasenia")
    private String contrasenia;
    
    @Column(name="telefono")
    private String telefono;
    
    @OneToMany(mappedBy="administrador", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Administrador(int idAdmin, int cuentaAdmin, String nombre, String contrasenia, String telefono) {
        this.idAdmin = idAdmin;
        this.cuentaAdmin = cuentaAdmin;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setCuentaAdmin(int cuentaAdmin) {
        this.cuentaAdmin = cuentaAdmin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public int getCuentaAdmin() {
        return cuentaAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    
    
    @Override
    public String toString(){
        return "Marca\n"+
                "ID: "+idAdmin+"\n"+
                "Numero de cuenta: "+cuentaAdmin+"\n"+
                "Nombre: "+nombre+"\n"+
                "Contrasenia: "+contrasenia+"\n"+
                "Telefono: "+telefono+"\n";
                
    }
    
}
