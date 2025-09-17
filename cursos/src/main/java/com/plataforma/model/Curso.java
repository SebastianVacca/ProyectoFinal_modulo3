package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String codigo;
    private String nombreCurso;
    private Integer capacidadMax;
    private List<Estudiante> estudiantesInscritos;

    public Curso(String codigo, String nombreCurso, Integer capacidadMax) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.capacidadMax = capacidadMax; 
        this.estudiantesInscritos = new ArrayList<>();       
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public boolean estaLleno(){
        return estudiantesInscritos.size() >= capacidadMax;
    }

    public void agregarEstudiante(Estudiante estudiante){
        if (!estaLleno()) {
            estudiantesInscritos.add(estudiante);
        }
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo= '" + codigo + '\'' +
                ", nombre= '" + nombreCurso + '\'' +
                ", capacidad= " + capacidadMax + 
                ", estudiantes Inscritos=" + estudiantesInscritos +
                '}';
    }
    

    

}
