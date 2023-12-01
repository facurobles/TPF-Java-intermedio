package TPFJavaInt.TPFJavaInt;

import TPFJavaInt.TPFJavaInt.controller.CEquipo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpfJavaIntApplication{
    
         
	public static void main(String[] args) {
            SpringApplication.run(TpfJavaIntApplication.class, args);
            
            CEquipo menu = new CEquipo();
            
            menu.menu();
        }

}
