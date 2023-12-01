package TPFJavaInt.TPFJavaInt.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Entity
@Table(name="Equipo")
public abstract class Equipo {

    //Atributes
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "equipo_titulares", joinColumns = @JoinColumn(name = "equipo_id"), inverseJoinColumns = @JoinColumn(name = "titular_id"))
    private List<Jugador> titulares;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "equipo_suplentes", joinColumns = @JoinColumn(name = "equipo_id"), inverseJoinColumns = @JoinColumn(name = "suplente_id"))
    private List<Jugador> suplentes;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tecnico_id")
    private Tecnico directorTecnico;
    
    private Integer puntos = 0;
    private Integer cantPartidosJugados = 0;
    private Boolean tipo;                        // si es true es Futbol 11 , si es false es Futbol de salon

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Jugador> titulares) {
        this.titulares = titulares;
    }

    public List<Jugador> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(List<Jugador> suplentes) {
        this.suplentes = suplentes;
    }

    public Tecnico getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(Tecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getCantPartidosJugados() {
        return cantPartidosJugados;
    }

    public void setCantPartidosJugados(Integer cantPartidosJugados) {
        this.cantPartidosJugados = cantPartidosJugados;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    //TemplateMethods
    public void armarEquipo() {
        agregarTitulares();
        agregarSuplentes();
        agregarTecnico();
        mostrarEquipo();
    }

    //Paso 1
    public abstract void agregarTitulares();

    //Paso 2
    public abstract void agregarSuplentes();
    
    //Paso 3
    public void agregarTecnico() {
        System.out.println("Ingrese datos del Técnico: ");
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombreTecnico = lectura.next();
        System.out.println("Ingrese su apellido: ");
        String apellido = lectura.next();
        System.out.println("Ingrese su edad: ");
        int edad = lectura.nextInt();
        Tecnico tecnico = new Tecnico(nombreTecnico, apellido, edad);
        this.directorTecnico = tecnico;
    }

    //Paso 4
    public void mostrarEquipo() {

        //version de futbol
        String version;
        if (this.tipo) {
            version = "Fútbol Once";
        } else {
            version = "Fútbol Salón";
        }

        //lista de jugadores titulares
        String tit = nombresTitulares();

        //lista de jugadores suplentes
        String sup = nombresSuplentes();

        //Datos del equipo
        String datosEquipo = "Equipo: " + this.nombre + "\n"
                + "Director Técnico: " + this.directorTecnico.getNombre() + this.directorTecnico.getApellido() + "\n"
                + "Tipo de juego: " + version + "\n"
                + "Titulares: " + tit + "\n"
                + "Suplentes: " + sup + "\n"
                + "Puntos: " + String.valueOf(this.puntos) + "\n"
                + "Partidos Jugados: " + String.valueOf(this.cantPartidosJugados);
        
        System.out.println(datosEquipo);
    }

    //Other Methods
    public String nombresTitulares() {
        List<String> listaTitulares = this.titulares.stream().map((titular) -> titular.getApellido()).collect(Collectors.toList());
        String nombresTitulares = listaTitulares.stream().collect(Collectors.joining(", "));
        return nombresTitulares;
    }

    public String nombresSuplentes() {
        List<String> listaSuplentes = this.suplentes.stream().map((suplente) -> suplente.getApellido()).collect(Collectors.toList());
        String nombresSuplentes = listaSuplentes.stream().collect(Collectors.joining(", "));
        return nombresSuplentes;
    }

    public void cambiarTecnico(Tecnico tecnico) {
        this.directorTecnico = tecnico;
    }

    ///this.titulares.stream().anyMatch((titular) -> jugadorSale == titular.getNombre())
    //usar esta porcion de codigo en la clase de negocio para verificar que el jugador ingresado
    //efectivamente esta en la lista de titulares si no pedir que se ingrese nuevamete
    public void cambiarJugadores(String jugadorSale, String jugadorEntra) {
        for (Jugador jugador : this.titulares) {
            if (jugador.getNombre().equals(jugadorSale)) {
                this.titulares.remove(jugador);
                this.suplentes.add(jugador);
            }
            if (jugador.getNombre().equals(jugadorEntra)) {
                this.titulares.remove(jugador);
                this.suplentes.add(jugador);
            }
        }
    }
}
