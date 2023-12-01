
package TPFJavaInt.TPFJavaInt.Repository;

import TPFJavaInt.TPFJavaInt.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RJugador extends JpaRepository<Jugador, Integer>{
    
}
