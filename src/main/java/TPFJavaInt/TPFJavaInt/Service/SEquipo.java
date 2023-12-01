
package TPFJavaInt.TPFJavaInt.Service;

import TPFJavaInt.TPFJavaInt.Model.Equipo;
import TPFJavaInt.TPFJavaInt.Repository.REquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEquipo implements IEquipo{
    
    @Autowired
    private REquipo rEquipo;
    
    @Override
    public void save(Equipo equipo){
        rEquipo.save(equipo);
    }
    
}
