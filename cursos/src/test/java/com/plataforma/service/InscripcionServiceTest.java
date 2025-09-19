package com.plataforma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.plataforma.exception.CursoLlenoException;
import com.plataforma.exception.EstudianteNoEncontradoException;
import com.plataforma.model.Curso;
import com.plataforma.model.Estudiante;
import com.plataforma.model.Inscripcion;


public class InscripcionServiceTest {
    
    @Test
    void InscribirEstudianteCurso() throws CursoLlenoException{
        InscripcionService inscripcionService = new InscripcionService();       
        Curso curso = new Curso("C001", "Java", 2);
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "juan@email.com");
        
        inscripcionService.InscribirEstudiante(curso, estudiante1);        
        
        assertEquals(1, curso.getEstudiantesInscritos().size());        
    }
    @Test
    void InscribirEstudianteCursoSinCupo() throws CursoLlenoException{
        InscripcionService inscripcionService = new InscripcionService();      
        Curso curso = new Curso("C001", "Java", 1);
       
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "juan@email.com");
        Estudiante estudiante2 = new Estudiante("E002", "Jose", "jose@email.com");
        
        inscripcionService.InscribirEstudiante(curso, estudiante1);   
        
        CursoLlenoException exception = assertThrows(CursoLlenoException.class,
        () -> inscripcionService.InscribirEstudiante(curso, estudiante2));
               
        assertEquals("Curso lleno", exception.getMessage());        
        assertEquals(1, curso.getEstudiantesInscritos().size());        
    }

    @Test
    void BuscarInscripcionPorEstudiante() throws Exception {
        InscripcionService inscripcionService = new InscripcionService();
        Curso curso = new Curso("C001", "Java", 1);
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "juan@email.com");
        
        
        inscripcionService.InscribirEstudiante(curso, estudiante1);
        List<Inscripcion> resultado = inscripcionService.BuscarInscripcionPorEstudiante(estudiante1);

        assertEquals("E001", resultado.get(0).getEstudiante().getId());
    }

    @Test
    void BuscarInscripcionPorEstudianteNoEncontrado() {
        InscripcionService inscripcionService = new InscripcionService();
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "juan@email.com");

        EstudianteNoEncontradoException exception = assertThrows(EstudianteNoEncontradoException.class,
        () ->  inscripcionService.BuscarInscripcionPorEstudiante(estudiante1));

        assertEquals("No hay inscricpciones para el estudiante", exception.getMessage());

    }
    
}
