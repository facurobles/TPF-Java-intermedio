
package TPFJavaInt.TPFJavaInt.Repository;

import TPFJavaInt.TPFJavaInt.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REquipo extends JpaRepository<Equipo, Integer>{
    
}
