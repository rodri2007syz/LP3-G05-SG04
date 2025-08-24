package sistema;

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();

        // Crear objetos e instanciar
        Estudiante estudiante1 = new Estudiante("Ana Pérez", "E001", "ana.p@un.edu");
        Estudiante estudiante2 = new Estudiante("Luis García", "E002", "luis.g@un.edu");
        Profesor profesor1 = new Profesor("Dr. Juarez", "P001", "jjuarez@un.edu");
        
        Curso curso1 = new Curso("PROG101", "Programación I", 5);
        Curso curso2 = new Curso("CALC202", "Cálculo Avanzado", 4);

        // Agregación de objetos al sistema (Composición)
        sistema.agregarEstudiante(estudiante1);
        sistema.agregarEstudiante(estudiante2);
        sistema.agregarProfesor(profesor1);
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);
        
        // Asignación de profesor a curso (Agregación)
        curso1.setProfesor(profesor1);

        // Inscripción de estudiantes
        sistema.inscribirEstudianteACurso("E001", "PROG101");
        sistema.inscribirEstudianteACurso("E002", "PROG101");
        sistema.inscribirEstudianteACurso("E001", "CALC202");
        
        // Mostrar reportes (Polimorfismo)
        sistema.mostrarInformacionDeTodos();
    }
}