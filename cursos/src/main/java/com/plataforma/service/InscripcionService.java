package com.plataforma.service;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;
import com.plataforma.exception.CursoLlenoException;
import com.plataforma.exception.EstudianteNoEncontradoException;
import com.plataforma.model.Curso;
import com.plataforma.model.Estudiante;
import com.plataforma.model.Inscripcion;

public class InscripcionService {
    
    private static final Logger logger = LogManager.getLogger(InscripcionService.class);
    private List<Inscripcion> inscripciones;

    public InscripcionService(){
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Función creada para inscribir un estudiante a un curso
     * @param curso
     * @param estudiante
     * @throws CursoLlenoException
     */
    public void InscribirEstudiante(Curso curso, Estudiante estudiante) throws CursoLlenoException{
        if (curso.estaLleno()) {    
            logger.error("Inscripción fallida, No se puede inscribir en el curso {}: cupo lleno", curso.getNombreCurso());
            throw new CursoLlenoException("Curso lleno");
        }

        curso.agregarEstudiante(estudiante);
        Inscripcion inscripcion = new Inscripcion(estudiante, curso);
        inscripciones.add(inscripcion);
        logger.info("Estudiante {} inscrito satisfactoriamente en el curso {}", estudiante.getNombre(), curso.getNombreCurso());

    }

    /**
     * Permite buscar las inscripciones que tiene un estudiante
     * @param estudiante
     * @return
     * @throws EstudianteNoEncontradoException
     */
    public List<Inscripcion> BuscarInscripcionPorEstudiante(Estudiante estudiante) throws EstudianteNoEncontradoException{
        //se crea una lista para guardar las inscripciones del estudiantes
        List<Inscripcion> inscripcionesEstudiante = new ArrayList<>();

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getEstudiante().getId().equals(estudiante.getId())) {
                inscripcionesEstudiante.add(inscripcion);                
            }
        }

        // si no se encuentran inscripciones se registra un aviso en los Logs
        if (inscripcionesEstudiante.isEmpty()) {
            logger.warn("No se encontraron inscripciones para el estudiante {}", estudiante.getNombre());
            throw new EstudianteNoEncontradoException("No hay inscricpciones para el estudiante");
        } else {
            logger.info("Se encontraron las siguientes inscricpciones {} para el estudiante con el id {}",
                    inscripcionesEstudiante.toArray(), estudiante.getId());
        }
        return inscripcionesEstudiante;
    }
}
