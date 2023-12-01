
package TPFJavaInt.TPFJavaInt.Service;

import TPFJavaInt.TPFJavaInt.Model.Jugador;
import TPFJavaInt.TPFJavaInt.Repository.RJugador;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SJugador {
    
    @Autowired
    private RJugador rJugador;
    
    @Transactional
    public void save(Jugador jugador){
        rJugador.save(jugador);
    }
    
}
