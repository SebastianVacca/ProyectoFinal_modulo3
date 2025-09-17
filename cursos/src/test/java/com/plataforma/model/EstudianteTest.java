package com.plataforma.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EstudianteTest {
    
    @Test
    void agregarCurso(){
              
        Estudiante estudiante1 = new Estudiante("E001", "Juan", "prueba1@email.com");
        Curso curso1 = new Curso("C001", "CursoTest", 2);  
                
        estudiante1.agregarCurso(curso1);
            
        assertEquals(1, estudiante1.getCursosInscritos().size());
    }

}
