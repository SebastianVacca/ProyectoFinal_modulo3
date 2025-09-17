package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;
import com.plataforma.exception.CursoNoEncontradoException;
import com.plataforma.model.Curso;


public class CursoService {

    private static final Logger logger = LogManager.getLogger(CursoService.class);
    private List<Curso> cursos;

    public CursoService(){
        this.cursos = new ArrayList<>();
    }

    /**
     * Función que permite agregar un curso a la lista de cursos
     * @param curso
     */
    public void agregarCurso(Curso curso){
        cursos.add(curso);
        logger.info("Curso agregado: " + curso.getNombreCurso());
    }

    /**
     * Permite retornar unas de lista de cursos
     * @return
     */
    public List<Curso> listarCursos(){
        return cursos;
    }

    public Curso buscarCursoPorCodigo(String codigo) throws CursoNoEncontradoException{
        
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        logger.warn("Curso no encontrado: " + codigo);
        throw new CursoNoEncontradoException("Curso no encontrado");
    }
    

    
}
