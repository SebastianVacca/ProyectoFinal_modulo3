package com.plataforma.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.plataforma.exception.CursoLlenoException;
import com.plataforma.service.InscripcionService;

public class CursoTest {

    @Test
    void agregarEstudiante(){
        Curso curso = new Curso("C001", "CursoTest", 2);
      
        assertEquals(0, curso.getEstudiantesInscritos().size());
    }
    
    @Test
    void agregarEstudianteConUnEstudiante() throws CursoLlenoException{
        InscripcionService inscripcionService = new InscripcionService();

        Curso curso1 = new Curso("C001", "CursoTest", 2);        
                
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "Prueba1@email.com");
        // Estudiante estudiante2 = new Estudiante("E002", "Juanito", "Prueba2@email.com");

        inscripcionService.InscribirEstudiante(curso1, estudiante1);

        assertEquals(1, curso1.getEstudiantesInscritos().size());
    }

    @Test
    void agregarEstudianteConMaximo() throws CursoLlenoException{
        InscripcionService inscripcionService = new InscripcionService();

        Curso curso1 = new Curso("C001", "CursoTest", 2);        
                
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "Prueba1@email.com");
        Estudiante estudiante2 = new Estudiante("E002", "Juanito", "Prueba2@email.com");

        inscripcionService.InscribirEstudiante(curso1, estudiante1);
        inscripcionService.InscribirEstudiante(curso1, estudiante2);

        assertEquals(2, curso1.getEstudiantesInscritos().size());
    }

    @Test
    void agregarEstudianteConMaximoSinCupo() throws CursoLlenoException{
        InscripcionService inscripcionService = new InscripcionService();

        Curso curso1 = new Curso("C001", "CursoTest", 2);        
                
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "Prueba1@email.com");
        Estudiante estudiante2 = new Estudiante("E002", "Juanito", "Prueba2@email.com");
        Estudiante estudiante3 = new Estudiante("E003", "Juancho", "Prueba3@email.com");

        inscripcionService.InscribirEstudiante(curso1, estudiante1);
        inscripcionService.InscribirEstudiante(curso1, estudiante2);
        assertThrows(CursoLlenoException.class, () -> {
            inscripcionService.InscribirEstudiante(curso1, estudiante3);
        });        

        assertEquals(2, curso1.getEstudiantesInscritos().size());
    }

      
    

}
