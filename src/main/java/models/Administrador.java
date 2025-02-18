
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Administrador")
public class Administrador implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idAdmin")
    private int idAdmin;
    
    @Column(name="cuentaAdmin")
    private int cuentaAdmin;
    
    @Column(name="apellidoPaterno")
    private String apellidoPaterno;
    
    @Column(name="apellidoMaterno")
    private String apellidoMaterno;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="contrasenia")
    private String contrasenia;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="correoE")
    private String correoE;
    
    @OneToMany(mappedBy="administrador", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Administrador(int idAdmin, int cuentaAdmin, String apellidoPaterno, String apellidoMaterno, String nombre, String contrasenia, String telefono, String correo) {
        this.idAdmin = idAdmin;
        this.cuentaAdmin = cuentaAdmin;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.correoE = correo;
    }

   public Administrador(){}

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setCuentaAdmin(int cuentaAdmin) {
        this.cuentaAdmin = cuentaAdmin;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    public void setCorreo(String correo) {
        this.correoE = correo;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
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

    public String getCorreo() {
        return correoE;
    }

    public List<Producto> getProducto() {
        return producto;
    }
   
   
        
   
    @Override
    public String toString(){
        return "Marca\n"+
                "ID: "+idAdmin+"\n"+
                "Numero de cuenta: "+cuentaAdmin+"\n"+
                "Apellido Paterno: "+apellidoPaterno+
                "Apellido Materno: "+apellidoMaterno+
                "Nombre: "+nombre+"\n"+
                "Contrasenia: "+contrasenia+"\n"+
                "Telefono: "+telefono+"\n"+
                "Correo: "+correoE+"\n";
                
    }
    
}
