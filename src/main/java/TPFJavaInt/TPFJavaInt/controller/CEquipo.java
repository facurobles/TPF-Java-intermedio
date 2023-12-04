
package TPFJavaInt.TPFJavaInt.controller;

import TPFJavaInt.TPFJavaInt.Model.Equipo;
import TPFJavaInt.TPFJavaInt.Service.IEquipo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CEquipo extends Equipo{
    
    @Autowired
    private IEquipo iEquipo;
    
    
    //sirve para validar que el Id ingresado es Entero y positivo
    public Integer validadorPositivo(String mensaje){       
        Scanner scanner =  new Scanner (System.in);
        int id;
        do {
                System.out.println(mensaje);
                while (!scanner.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    scanner.next();
                }
                id = scanner.nextInt();
                if (id <= 0) {
                    System.out.println("Debe ingresar un número entero positivo. Intente nuevamente.");
                }
            } while (id <= 0);
        return id;
    }
    
    
    @Transactional
    public void listarEquipos(){
        List<Equipo> lista = iEquipo.traerEquipos();
        List<String> listaNombresEquipos = lista.stream().map((equipo) -> equipo.getId() + ". " + equipo.getNombre()).collect(Collectors.toList());
        String cadenaNombres = listaNombresEquipos.stream().collect(Collectors.joining("\n"));
        System.out.println("Equipos registrados: \n" + cadenaNombres);
    };
    
    @Transactional
    public void detalleEquipo(){
         int id = this.validadorPositivo("Ingrese ID del equipo que desea ver en detalle: ");
         
         if(iEquipo.existById(id)){
             Equipo equipo = iEquipo.traerEquipo(id).get();
             equipo.mostrarEquipo();
         }
         else{System.out.println("El ID ingresado no corresponde a un equipo registrado.");}
            
    };
    
    @Transactional 
    public void eliminarEquipo(){
         int id = this.validadorPositivo("Ingrese ID del equipo que desea eliminar: ");

         if(iEquipo.existById(id)){
             iEquipo.eliminarEquipo(id);
             System.out.println("Equipo eliminado con éxito");
         }
         else{System.out.println("El ID ingresado no corresponde a un equipo registrado.");}
        
    }
    
    @Transactional
    public void partido(){
        Equipo equipo1;
        Equipo equipo2;
        int id1 = this.validadorPositivo("Ingrese ID de uno de los equipos que jugó el partido: ");
        if(iEquipo.existById(id1)){
             equipo1 = iEquipo.traerEquipo(id1).get();
         }
        else{
            System.out.println("El ID ingresado no corresponde a un equipo registrado.");
            return;}
        int goles1 = this.validadorPositivo("Ingrese cantidad de goles realizados por este equipo: ");
        
        int id2 = this.validadorPositivo("Ingrese ID del otro equipo que jugó el partido: ");
        if(iEquipo.existById(id2)){
             equipo2 = iEquipo.traerEquipo(id2).get();
         }
        else{
            System.out.println("El ID ingresado no corresponde a un equipo registrado.");
            return;}
        int goles2 = this.validadorPositivo("Ingrese cantidad de goles realizados por este equipo: ");

        
        if (goles1 > goles2){
            equipo1.setPuntos(equipo1.getPuntos()+3);
            equipo1.setCantPartidosJugados(equipo1.getCantPartidosJugados()+1);
            equipo2.setCantPartidosJugados(equipo2.getCantPartidosJugados()+1);
        }
        else if(goles1 < goles2){
            equipo2.setPuntos(equipo1.getPuntos()+3);
            equipo2.setCantPartidosJugados(equipo1.getCantPartidosJugados()+1);
            equipo1.setCantPartidosJugados(equipo1.getCantPartidosJugados()+1);
        }
        else{
            equipo1.setPuntos(equipo1.getPuntos()+1);
            equipo2.setPuntos(equipo2.getPuntos()+1);
            equipo1.setCantPartidosJugados(equipo1.getCantPartidosJugados()+1);
            equipo2.setCantPartidosJugados(equipo2.getCantPartidosJugados()+1);
        }
        System.out.println("Partido registrado con éxito");
    }
    
    
    @Transactional
    public void menu(){
        System.out.println("""
                               Bienvenidx al Sistema de gestion de equipos de futbol 
                                
                               Ingrese una opcion del menu para continuar..""");
            
            int opcion = 100; 
            while(opcion != 0){
                System.out.println("""
                                   
                                   Menu: 
                                   Opcion 1: Ingresar nuevo equipo de 11.
                                   Opción 2: Ver equipos registrados. 
                                   Opcion 3: Ver detalles de equipo.
                                   Opcion 4: Eliminar equipo.
                                   Opcion 5: Registrar partido jugado.
                                   Opcion 0: Salir.\n""");
                
                Scanner lectura = new Scanner (System.in);
                
                System.out.println("Ingrese una opcion: ");
                opcion  = lectura.nextInt();
                
                if(opcion == 1){
                    System.out.println("Ingrese nombre del equipo: ");
                    String nombre = lectura.next();  
                    
                    Equipo equipo = new Equipo(nombre);
                    
                    equipo.armarEquipo();
                    
                    iEquipo.save(equipo);
                    System.out.println("Equipo guardado con éxito");
                    }
                if(opcion == 2){
                    this.listarEquipos();
                }
                if(opcion == 3){
                    this.detalleEquipo();
                }
                if(opcion == 4){
                    this.eliminarEquipo();
                }
                if(opcion == 5){
                    this.partido();
                }
            }
    }
}