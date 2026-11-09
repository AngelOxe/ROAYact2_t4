package API.de.materias.de.Angel.Yiban.Ruiz.Osante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatalogoMaterias {

    private final List<MateriaDTO> materias = new ArrayList<>();

    public CatalogoMaterias() {
        materias.add(new MateriaDTO(1L, "Lenguajes y Autómatas II", "Desarrollo"));
        materias.add(new MateriaDTO(2L, "Conmutación y Enrutamiento de Redes de Datos", "Redes"));
        materias.add(new MateriaDTO(3L, "Taller de Investigación I", "Investigación"));
        materias.add(new MateriaDTO(4L, "Programación Web", "Desarrollo"));
        materias.add(new MateriaDTO(5L, "Gestión de Proyectos de Software", "Gestión"));
        materias.add(new MateriaDTO(6L, "Sistemas Programables", "Electrónica"));
        materias.add(new MateriaDTO(7L, "Software para Toma de Decisiones", "Análisis de datos"));
    }

    public synchronized List<MateriaDTO> listar() {
        return List.copyOf(materias);
    }

    public synchronized MateriaDTO agregar(MateriaDTO nuevaMateria) {
    long nuevoId = materias.size() + 1L;

    MateriaDTO materiaGuardada = new MateriaDTO(
            nuevoId,
            nuevaMateria.getNombre(),
            nuevaMateria.getArea()
    );

    materias.add(materiaGuardada);
    return materiaGuardada;
}
}