package sistema;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public SistemaGestion() {
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void inscribirEstudianteACurso(String idEstudiante, String codigoCurso) {
        Estudiante estudiante = buscarEstudiante(idEstudiante);
        Curso curso = buscarCurso(codigoCurso);

        if (estudiante != null && curso != null) {
            estudiante.inscribirCurso(curso);
            System.out.println("Inscripción exitosa: " + estudiante.getNombre() + " se ha inscrito en " + curso.getNombre());
        } else {
            System.out.println("Error: Estudiante o Curso no encontrado.");
        }
    }


    private Estudiante buscarEstudiante(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private Curso buscarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public void mostrarInformacionDeTodos() {
        System.out.println("\n--- Reporte General del Sistema ---");
        System.out.println("Total de estudiantes: " + Estudiante.obtenerTotalEstudiantes());
        System.out.println("Total de cursos: " + Curso.obtenerTotalCursos());
        
        System.out.println("\n--- Información de Personas ---");
        for (Estudiante e : estudiantes) {
            e.mostrarInformacion(); 
        }
        for (Profesor p : profesores) {
            p.mostrarInformacion(); 
        }
    }

}
