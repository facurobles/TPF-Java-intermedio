
package TPFJavaInt.TPFJavaInt.controller;

import TPFJavaInt.TPFJavaInt.Model.EquipoDeOnce;
import TPFJavaInt.TPFJavaInt.Service.SEquipo;
import jakarta.transaction.Transactional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CEquipo {
    
    @Autowired
    private SEquipo sEquipo;
    
    @Transactional
    public void menu(){
        System.out.println("""
                               Bienvenidx al Sistema de gestion de equipos de futbol 
                                
                               Ingrese una opcion del menu para continuar..""");
            
            int opcion = 100; 
            while(opcion != 0){
                System.out.println("""
                                   
                                   Menu: 
                                   Opcion 1: Ingresar nuevo equipo de 11 \n """);
                
                Scanner lectura = new Scanner (System.in);
                
                System.out.println("Ingrese una opcion: ");
                opcion  = lectura.nextInt();
                
                if(opcion == 1){
                    System.out.println("Ingrese nombre del equipo: ");
                    String nombre = lectura.next();  
                    
                    EquipoDeOnce equipo = new EquipoDeOnce(nombre);
                    
                    equipo.armarEquipo();
                    
                    sEquipo.save(equipo);
                    System.out.println("Equipo guardado con éxito");
                    }
            }
    }
}