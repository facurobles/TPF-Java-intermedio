package TPFJavaInt.TPFJavaInt;

import TPFJavaInt.TPFJavaInt.controller.CEquipo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TpfJavaIntApplication {

    public static void main(String[] args) {
        //  SpringApplication.run(TpfJavaIntApplication.class, args);

        // CEquipo menu = new CEquipo();
        // menu.menu();
        ConfigurableApplicationContext context = SpringApplication.run(TpfJavaIntApplication.class, args);

        // Obtén la instancia de CEquipo desde el contexto de Spring
        CEquipo menu = context.getBean(CEquipo.class);

        // Llama al método menu
        menu.menu();
    }

}
