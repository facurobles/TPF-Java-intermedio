
package TPFJavaInt.TPFJavaInt.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Jugador")
public class Jugador implements Serializable{
    
    
    //Atributes
    
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer nroCamiseta;
    private Boolean estado;          //si es true es titular,, si es false es suplente
    
    

    //Getters and Setters
    public int getId() {    
        return id;
    }
    
    public void setId(int id) {    
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(Integer nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    //Constructor
    public Jugador(){};
    
    public Jugador(String nombre, String apellido, Integer edad, Integer nroCamiseta, Boolean estado){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nroCamiseta = nroCamiseta;
        this.estado = estado;
    }
            
    
    //methods
    public void camiarEstado(){
        this.estado = !this.estado;
    }
    
}
