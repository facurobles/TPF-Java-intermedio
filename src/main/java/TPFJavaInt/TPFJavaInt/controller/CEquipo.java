
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
    
    
    @Transactional
    public void listarEquipos(){
        List<Equipo> lista = iEquipo.traerEquipos();
        List<String> listaNombresEquipos = lista.stream().map((equipo) -> equipo.getId() + equipo.getNombre()).collect(Collectors.toList());
        String cadenaNombres = listaNombresEquipos.stream().collect(Collectors.joining("\n"));
        System.out.println("Equipos registrados: \n" + cadenaNombres);
    };
    
    @Transactional
    public void detalleEquipo(){
         Scanner scanner =  new Scanner (System.in);
         
         int id;
            do {
                System.out.println("Ingrese Id del equipo que desea ver en detalle: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Debe ingresar un número, intente nuevamente:");
                    scanner.next();
                }
                id = scanner.nextInt();
                if (id <= 0) {
                    System.out.println("La edad debe ser un número entero positivo. Intente nuevamente.");
                }
            } while (id <= 0);
         
         if(iEquipo.existById(id)){
             Equipo equipo = iEquipo.traerEquipo(id).get();
             equipo.mostrarEquipo();
         }
         else{System.out.println("El Id ingresado no corresponde a algun equipo registrado.");}
            
    };
    
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
                                   opcion 3: Ver detalles de equipo.
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
            }
    }
}