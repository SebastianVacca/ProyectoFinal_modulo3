package com.plataforma;
import org.apache.logging.log4j.*;
import com.plataforma.exception.CursoLlenoException;
import com.plataforma.model.Curso;
import com.plataforma.model.Estudiante;
import com.plataforma.service.CursoService;
import com.plataforma.service.InscripcionService;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Main.class);
        CursoService cursoService = new CursoService();
        InscripcionService inscripcionService = new InscripcionService();

        //Creación de cursos
        Curso javaBasico = new Curso("C001", "Java Básico", 3);
        Curso pythonIntermedio = new Curso("C002", "Python Intermedio", 2);

        //Agregando cursos a la lista de cursos
        cursoService.agregarCurso(javaBasico);
        cursoService.agregarCurso(pythonIntermedio);

        //Creando estudiantes
        Estudiante estudiante1 = new Estudiante("E001", "Ana pérez", "ana@gmail.com");
        Estudiante estudiante2 = new Estudiante("E002", "Luis Gómez", "luis@gmail.com");
        Estudiante estudiante3 = new Estudiante("E003", "Marta Ruíz", "marta@gmail.com");
        Estudiante estudiante4 = new Estudiante("E004", "Juan Ruíz", "juan@gmail.com");


        //Inscribiendo estudiantes a cursos
        try {
            inscripcionService.InscribirEstudiante(pythonIntermedio, estudiante3);
            inscripcionService.InscribirEstudiante(pythonIntermedio, estudiante2);
            inscripcionService.InscribirEstudiante(javaBasico, estudiante1);
            inscripcionService.InscribirEstudiante(javaBasico, estudiante4);
        } catch (CursoLlenoException e) {
            logger.error("Error de isncripción: " + e.getMessage());
        }

        //Mostrar cursos y estudiantes inscritos
        System.out.println("--- Cursos Disponibles ---");
        for (Curso curso : cursoService.listarCursos()) {
            System.out.println(curso);
            System.out.println("Estudiantes inscritos: ");
            for (Estudiante estudiante : curso.getEstudiantesInscritos()) {
                System.out.println(" - " + estudiante);
            }
        }
        

    }
}