package com.plataforma.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.plataforma.exception.CursoNoEncontradoException;
import com.plataforma.model.Curso;


public class CursoServiceTest {
    
    @Test
    void agregarCurso(){
        CursoService cursoService = new CursoService();

        Curso curso1 = new Curso("C001", "Java", 5);
        cursoService.agregarCurso(curso1);

        List<Curso> cursos = cursoService.getCursos();
        assertTrue(cursos.contains(curso1));   
        assertEquals(1, cursos.size());
    }

    @Test
    void buscarCursoPorCodigoCursoExistente() throws CursoNoEncontradoException{
        CursoService cursoService = new CursoService();

        Curso curso1 = new Curso("C001", "Java", 5);
        Curso curso2 = new Curso("C002", "Python", 4);

        cursoService.agregarCurso(curso1);
        cursoService.agregarCurso(curso2);

        Curso resultadoBusqueda = cursoService.buscarCursoPorCodigo("C001");

        assertEquals("C001", resultadoBusqueda.getCodigo());       

    }

    @Test
    void buscarCursoPorCodigoCursoNoExistente() throws CursoNoEncontradoException{
        CursoService cursoService = new CursoService();

        Curso curso1 = new Curso("C001", "Java", 5);
        Curso curso2 = new Curso("C002", "Python", 4);

        cursoService.agregarCurso(curso1);
        cursoService.agregarCurso(curso2);

        Exception exception = assertThrows(CursoNoEncontradoException.class,
                () -> cursoService.buscarCursoPorCodigo("C003"));

        assertEquals("Curso no encontrado", exception.getMessage());
            

    }
    
}
