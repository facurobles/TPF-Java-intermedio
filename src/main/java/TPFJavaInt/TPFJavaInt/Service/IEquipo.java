
package TPFJavaInt.TPFJavaInt.Service;

import TPFJavaInt.TPFJavaInt.Model.Equipo;
import java.util.List;
import java.util.Optional;


public interface IEquipo {
    
    public void save(Equipo equipo);
    
    public List<Equipo> traerEquipos();
    
    public Optional<Equipo> traerEquipo(Integer id);
    
    public boolean existById (Integer id);
    
    public void eliminarEquipo(Integer id);
    
}
