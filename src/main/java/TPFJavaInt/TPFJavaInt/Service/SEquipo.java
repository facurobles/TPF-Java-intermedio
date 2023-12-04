
package TPFJavaInt.TPFJavaInt.Service;

import TPFJavaInt.TPFJavaInt.Model.Equipo;
import TPFJavaInt.TPFJavaInt.Repository.REquipo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEquipo implements IEquipo{
    
    @Autowired
    public REquipo rEquipo;
    
    @Override
    public void save(Equipo equipo){
        rEquipo.save(equipo);
    }

    @Override
    public List<Equipo> traerEquipos() {
        return rEquipo.findAll();
    }

    @Override
    public Optional<Equipo> traerEquipo(Integer id) {
        return rEquipo.findById(id);
    }

    @Override
    public boolean existById(Integer id) {
        return rEquipo.existsById(id);
    }

    @Override
    public void eliminarEquipo(Integer id) {
        rEquipo.deleteById(id);
    }

    
}
