
package TPFJavaInt.TPFJavaInt.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EquipoDeCinco extends Equipo{
    
    public EquipoDeCinco(){};
    
    public EquipoDeCinco(String nombre){
        this.setNombre(nombre);   
        this.setTipo(false);
    }
    
    @Override
    public void agregarTitulares(){
        List<Jugador> titulares = new ArrayList<>();
        
        System.out.println("Ingrese datos de los jugadores titulares: ");
        for(int i=1; i<=2; i++){
           System.out.println("ciclo " + i);
            
           Scanner lectura = new Scanner (System.in);
           System.out.println("Ingrese su nombre: ");
           String nombre = lectura.next();  
           System.out.println("Ingrese su apellido: ");
           String apellido = lectura.next();  
           System.out.println("Ingrese su edad: ");
           int edad = lectura.nextInt();  
           System.out.println("Ingrese su número de camiseta: ");
           int nroCamiseta = lectura.nextInt();  

           Jugador jugador = new Jugador(nombre, apellido, edad, nroCamiseta, true);
           
           titulares.add(jugador);
        }
        this.setTitulares(titulares);
      }
    
    @Override
    public void agregarSuplentes(){
        List<Jugador> suplentes = new ArrayList<>();
        
        System.out.println("Ingrese datos de los jugadores suplentes: ");
        for(int i=1; i<=2; i++){            
           System.out.println("ciclo " + i);
           
           Scanner lectura = new Scanner (System.in);
           System.out.println("Ingrese su nombre: ");
           String nombre = lectura.next();  
           System.out.println("Ingrese su apellido: ");
           String apellido = lectura.next();  
           System.out.println("Ingrese su edad: ");
           int edad = lectura.nextInt();  
           System.out.println("Ingrese su número de camiseta: ");
           int nroCamiseta = lectura.nextInt();  

           Jugador jugador = new Jugador(nombre, apellido, edad, nroCamiseta, false);
           
           suplentes.add(jugador);
        }
        this.setSuplentes(suplentes);
    }
    
}
