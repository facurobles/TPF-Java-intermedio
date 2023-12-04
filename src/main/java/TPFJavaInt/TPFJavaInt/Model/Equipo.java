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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Entity
@Table(name = "Equipo")
public class Equipo implements Serializable{

    //Atributes
    //Mapeo entidad relacion
    @Id
    @Column(name = "id")
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

    private Integer puntos;
    private Integer cantPartidosJugados;

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

    //constructor
    public Equipo() {
    }

    ;
    
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.titulares = new ArrayList<>();
        this.suplentes = new ArrayList<>();
        this.directorTecnico = new Tecnico();
        this.puntos = 0;
        this.cantPartidosJugados = 0;
    }

    ;
    

    //TemplateMethods
    public void armarEquipo() {
        agregarTitulares();
        agregarSuplentes();
        agregarTecnico();
        mostrarEquipo();
    }

    //Paso 1
    public void agregarTitulares() {
        System.out.println("Ingrese datos de los jugadores titulares: ");
        for (int i = 1; i <= 11; i++) {
            System.out.println("ciclo " + i);

            Scanner lectura = new Scanner(System.in);
            System.out.println("Ingrese su nombre: ");
            String nombreTitular = lectura.next();
            System.out.println("Ingrese su apellido: ");
            String apellido = lectura.next();

            int edad;
            do {
                System.out.println("Ingrese su edad: ");
                while (!lectura.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    lectura.next();
                }
                edad = lectura.nextInt();
                if (edad <= 0) {
                    System.out.println("La edad debe ser un número entero positivo. Intente nuevamente.");
                }
            } while (edad <= 0);

            int nroCamiseta;
            do {
                System.out.println("Ingrese su número de camiseta: ");
                while (!lectura.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    lectura.next();
                }
                nroCamiseta = lectura.nextInt();
                if (nroCamiseta <= 0) {
                    System.out.println("El número de camiseta debe ser un número entero positivo. Intente nuevamente.");
                }
            } while (nroCamiseta <= 0);

            Jugador jugador = new Jugador(nombreTitular, apellido, edad, nroCamiseta, true);

            titulares.add(jugador);
        }
        this.setTitulares(titulares);
    }

    //Paso 2
    public void agregarSuplentes() {
        System.out.println("Ingrese datos de los jugadores suplentes: ");
        for (int i = 1; i <= 11; i++) {
            System.out.println("ciclo " + i);

            Scanner lectura = new Scanner(System.in);
            System.out.println("Ingrese su nombre: ");
            String nombreSuplente = lectura.next();
            System.out.println("Ingrese su apellido: ");
            String apellido = lectura.next();

            int edad;
            do {
                System.out.println("Ingrese su edad: ");
                while (!lectura.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    lectura.next();
                }
                edad = lectura.nextInt();
                if (edad <= 0) {
                    System.out.println("La edad debe ser un número entero positivo. Intente nuevamente.");
                }
            } while (edad <= 0);

            int nroCamiseta;
            do {
                System.out.println("Ingrese su número de camiseta: ");
                while (!lectura.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    lectura.next();
                }
                nroCamiseta = lectura.nextInt();
                if (nroCamiseta <= 0) {
                    System.out.println("El número de camiseta debe ser un número entero positivo. Intente nuevamente.");
                }
            } while (nroCamiseta <= 0);

            Jugador jugador = new Jugador(nombreSuplente, apellido, edad, nroCamiseta, false);

            suplentes.add(jugador);
        }
        this.setSuplentes(suplentes);
    }

    ;
    
    //Paso 3
    public void agregarTecnico() {
        System.out.println("Ingrese datos del Técnico: ");
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombreTecnico = lectura.next();
        System.out.println("Ingrese su apellido: ");
        String apellido = lectura.next();
        
        int edad;
            do {
                System.out.println("Ingrese su edad: ");
                while (!lectura.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    lectura.next();
                }
                edad = lectura.nextInt();
                if (edad <= 0) {
                    System.out.println("La edad debe ser un número entero positivo. Intente nuevamente.");
                }
            } while (edad <= 0);
            
        Tecnico tecnico = new Tecnico(nombreTecnico, apellido, edad);
        this.setDirectorTecnico(tecnico);
    }

    //Paso 4
    public void mostrarEquipo() {

        //lista de jugadores titulares
        String tit = nombresTitulares();

        //lista de jugadores suplentes
        String sup = nombresSuplentes();

        //Datos del equipo
        String datosEquipo = "Equipo: " + this.nombre + "\n"
                + "Director Técnico: " + this.directorTecnico.getNombre() + this.directorTecnico.getApellido() + "\n"
                + "Titulares: " + tit + "\n"
                + "Suplentes: " + sup + "\n"
                + "Puntos: " + String.valueOf(this.puntos) + "\n"
                + "Partidos Jugados: " + String.valueOf(this.cantPartidosJugados);

        System.out.println(datosEquipo);
    }

    //Other Methods
    public String nombresTitulares() {
        List<String> listaTitulares = this.titulares.stream().map((titular) -> titular.getApellido() + titular.getNombre()).collect(Collectors.toList());
        String nombresTitulares = listaTitulares.stream().collect(Collectors.joining(", "));
        return nombresTitulares;
    }

    public String nombresSuplentes() {
        List<String> listaSuplentes = this.suplentes.stream().map((suplente) -> suplente.getApellido() + suplente.getNombre()).collect(Collectors.toList());
        String nombresSuplentes = listaSuplentes.stream().collect(Collectors.joining(", "));
        return nombresSuplentes;
    }

    public void cambiarTecnico(Tecnico tecnico) {
        this.directorTecnico = tecnico;
    }
    
    
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
