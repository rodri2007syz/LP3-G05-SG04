package sistema;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
    private List<Curso> cursosAsignados;

    public Profesor(String nombre, String id, String email) {
        super(nombre, id, email);
        this.cursosAsignados = new ArrayList<>();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("---- Información del Profesor ----");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Tipo de Usuario: " + TIPO_USUARIO_PROFESOR);
        System.out.println("Cursos Asignados: " + cursosAsignados.size());
    }

    public void asignarCurso(Curso curso) {
        cursosAsignados.add(curso);
    }
}