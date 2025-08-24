package sistema;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {
    // Atributo de clase (estático)
    private static int contadorEstudiantes = 0;
    
    // Atributo de instancia
    private List<Curso> cursosInscritos;

    public Estudiante(String nombre, String id, String email) {
        super(nombre, id, email);
        this.cursosInscritos = new ArrayList<>();
        // El contador de estudiantes se incrementa al crear un nuevo objeto
        Estudiante.contadorEstudiantes++;
    }

    // Método de clase (estático)
    public static int obtenerTotalEstudiantes() {
        return contadorEstudiantes;
    }

    // Implementación del método polimórfico
    @Override
    public void mostrarInformacion() {
        System.out.println("---- Información del Estudiante ----");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Tipo de Usuario: " + TIPO_USUARIO_ESTUDIANTE);
        System.out.println("Número de cursos inscritos: " + cursosInscritos.size());
    }

    // Métodos de instancia
    public void inscribirCurso(Curso curso) {
        cursosInscritos.add(curso);
    }
}