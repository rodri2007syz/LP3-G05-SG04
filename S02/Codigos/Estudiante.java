package sistema;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {
    private static int contadorEstudiantes = 0;

    private List<Curso> cursosInscritos;

    public Estudiante(String nombre, String id, String email) {
        super(nombre, id, email);
        this.cursosInscritos = new ArrayList<>();
        Estudiante.contadorEstudiantes++;
    }

    public static int obtenerTotalEstudiantes() {
        return contadorEstudiantes;
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("---- Información del Estudiante ----");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Tipo de Usuario: " + TIPO_USUARIO_ESTUDIANTE);
        System.out.println("Número de cursos inscritos: " + cursosInscritos.size());
    }

    public void inscribirCurso(Curso curso) {
        cursosInscritos.add(curso);
    }

}
