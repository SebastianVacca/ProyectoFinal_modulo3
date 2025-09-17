package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String id;
    private String nombre;
    private String email;
    private List<Curso> cursosInscritos;
    
    public Estudiante(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cursosInscritos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }
    
    public void agregarCurso(Curso curso){
        this.cursosInscritos.add(curso);
    }
    
    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
