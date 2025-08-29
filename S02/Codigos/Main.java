package sistema;

import java.util.Scanner;

public class Main {
    private static int numCursos = 0;
    private static int numEstudiantes = 0;
    private static int numProfesores = 0;
    
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner input = new Scanner(System.in);
        int de; // x=10 es redundante, el bucle while(true) es más limpio
        
        Curso[] Cursos = new Curso[100];
        Estudiante[] Estudiantes = new Estudiante[100];
        Profesor[] Profesores = new Profesor[100];
        
        System.out.println("Sistema de Gestion de Matricula");
        
        while(true) { // Usa un bucle infinito y sal con 'break'
            System.out.println("Que Desea hacer? ");
            System.out.println("1. Agregar curso \n2. Agregar Estudiante \n3. Agregar Profesor \n4. Matricular Alumno a Curso \n5. Asignar Profesor a Curso \n6. Mostrar Datos \n7. Salir ");
            
            try {
                de = input.nextInt();
                input.nextLine(); // Consumir el salto de línea

                switch (de) {
                    case 1:
                        System.out.println("Cuantos Cursos desea agregar?");
                        int cu = input.nextInt();
                        input.nextLine();
                        for (int i = 0; i < cu; i++) {
                            System.out.println("\nIngrese el codigo del Curso: ");
                            String codcur = input.nextLine();
                            System.out.println("Ingrese el nombre del Curso: ");
                            String nomcur = input.nextLine();
                            System.out.println("Ingrese la cantidad de Creditos que equivale el Curso: ");
                            int cc = input.nextInt();
                            input.nextLine();
                            Cursos[numCursos + i] = new Curso(codcur, nomcur, cc);
                            sistema.agregarCurso(Cursos[numCursos + i]);
                        }
                        numCursos += cu; // Incrementa el contador después del bucle
                        System.out.println("Curso/s agregado/s Exitosamente! ");
                        break;

                    case 2:
                        System.out.println("Cuantos Alumnos desea agregar?");
                        int ce = input.nextInt();
                        input.nextLine();
                        for (int i = 0; i < ce; i++) {
                            System.out.println("\nIngrese el nombre del Alumno: ");
                            String nome = input.nextLine();
                            System.out.println("Ingrese el codigo del Alumno: ");
                            String code = input.nextLine();
                            System.out.println("Ingrese el correo del Alumno: ");
                            String corre = input.nextLine();
                            Estudiantes[numEstudiantes + i] = new Estudiante(nome, code, corre);
                            sistema.agregarEstudiante(Estudiantes[numEstudiantes + i]);
                        }
                        numEstudiantes += ce; // Incrementa el contador
                        System.out.println("Alumno/s agregado/s Exitosamente! ");
                        break;
                    
                    case 3:
                        System.out.println("Cuantos Profesores desea agregar?");
                        int cp = input.nextInt();
                        input.nextLine();
                        for (int i = 0; i < cp; i++) {
                            System.out.println("\nIngrese el nombre del Profesor: ");
                            String nomp = input.nextLine();
                            System.out.println("Ingrese el codigo del Profesor: ");
                            String codp = input.nextLine();
                            System.out.println("Ingrese el correo del Profesor: ");
                            String corrp = input.nextLine();
                            Profesores[numProfesores + i] = new Profesor(nomp, codp, corrp);
                            sistema.agregarProfesor(Profesores[numProfesores + i]);
                        }
                        numProfesores += cp; // Incrementa el contador
                        System.out.println("Profesor/es agregado/s Exitosamente! ");
                        break;

                    case 4:
                        System.out.println("Alumnos Registrados: ");
                        for (int i = 0; i < numEstudiantes; i++) { // Bucle hasta el contador
                            System.out.println(i + ": ");
                            Estudiantes[i].mostrarInformacion();
                        }
                        System.out.println("==========================================================");
                        System.out.println("Cursos Registrados: ");
                        for (int i = 0; i < numCursos; i++) { // Bucle hasta el contador
                            System.out.println(i + ": ");
                            Cursos[i].mostrarInfo();
                        }
                        System.out.println("A que alumno desea Matricular? (INGRESE EL CODIGO DEL ALUMNO): ");
                        String da = input.nextLine();
                        System.out.println("A que curso? (INGRESE EL CODIGO DEL CURSO): ");
                        String dc = input.nextLine();
                        sistema.inscribirEstudianteACurso(da, dc);
                        break;
                    
                    case 5:
                        System.out.println("Profesores Registrados: ");
                        for (int i = 0; i < numProfesores; i++) {
                            System.out.println(i + ": ");
                            Profesores[i].mostrarInformacion();
                        }
                        System.out.println("==========================================================");
                        System.out.println("Cursos Registrados: ");
                        for (int i = 0; i < numCursos; i++) {
                            System.out.println(i + ": ");
                            Cursos[i].mostrarInfo();
                        }
                        System.out.println("A que Profesor Desea Asignar? (INGRESE EL NÚMERO DE PROFESOR): ");
                        int dp = input.nextInt();
                        System.out.println("A que curso? (INRESE EL NÚMERO DE CURSO): ");
                        int dcp = input.nextInt();
                        input.nextLine(); // Consumir el salto de línea
                        Cursos[dcp].setProfesor(Profesores[dp]);
                        break;
                    
                    case 6:
                        sistema.mostrarInformacionDeTodos();
                        break;
                    
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        input.close();
                        return; // Termina el método main
                    
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                input.nextLine(); // Limpiar el buffer de entrada
            }
        }
    }
}
