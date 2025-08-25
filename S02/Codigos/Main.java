
package sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner input = new Scanner(System.in);
        int de, x=10;
        Curso[] Cursos;
		Cursos= new Curso[100];
		Estudiante[] Estudiantes;
		Estudiantes = new Estudiante[100];
		Profesor[] Profesores;
		Profesores = new Profesor[100];
		// Crear objetos e instanciar
        System.out.println("Sistema de Gestion de Matricula");
        while(x==10) {
	        System.out.println("Que Desea hacer? ");
	        System.out.println("1. Agregar curso \n2. Agregar Estudiante \n3. Agregar Profesor \n4. Matricular Alumno a Curso \n5. Asignar Profesor a Curso \n6. Mostrar Datos \n 7.Salir ");
	        de=input.nextInt();
	        if(de==1) {
	        		System.out.println("Cuantos Cursos desea agregar?");
	        		int cu=input.nextInt();
	        		for (int i=0; i<cu; i++) {
	        			String codcur,nomcur;
	        			int cc;
	        			System.out.println("Ingrese el codigo del Curso: ");
	        			codcur = input.next();
	        			System.out.println("Ingrese el nombre del Curso: ");
	        			nomcur = input.next();
	        			System.out.println("Ingrese la cantidad de Creditos que equilale el Curso: ");
	        			cc = input.nextInt();
	        			Cursos[i]= new Curso(codcur,nomcur,cc);
	        			sistema.agregarCurso(Cursos[i]);
	        		}
	        		System.out.println("Curso/s agregado/s Exitosamente! ");
	        		x=10;
	        }
	     // Agregación de objetos al sistema (Composición)
	     // Inscripción de estudiantes
	        if (de==2) {
	        		String nome, code,corre;
	        		System.out.println("Cuantos Alumnos desea agregar?");
	        		int ce=input.nextInt();
	        		for (int i=0; i<ce; i++) {
	        			System.out.println("Ingrese el nombre del Alumno: ");
	        			nome = input.next();
	        			System.out.println("Ingrese el codigo del Alumno: ");
	        			code = input.next();
	        			System.out.println("Ingrese el correo del Alumno: ");
	        			corre = input.next();
	        			Estudiantes[i]= new Estudiante(nome,code,corre);
	        			sistema.agregarEstudiante(Estudiantes[i]);
	        		}
	        		System.out.println("Alumno/s agregado/s Exitosamente! ");
	        		x=10;
	        		
	        }
	        if (de==3) {
        		String nomp, codp,corrp;
        		System.out.println("Cuantos Profesores desea agregar?");
        		int cp=input.nextInt();
        		for (int i=0; i<cp; i++) {
        			System.out.println("Ingrese el nombre del Profesor: ");
        			nomp = input.next();
        			System.out.println("Ingrese el codigo del Profesor: ");
        			codp = input.next();
        			System.out.println("Ingrese el correo del Profesor: ");
        			corrp = input.next();
        			Profesores[i]= new Profesor(nomp,codp,corrp);
        			sistema.agregarProfesor(Profesores[i]);
        		}
        		System.out.println("Profesor/es agregado/s Exitosamente! ");
        		x=10;
	        }
	        if(de==4) {
	        		System.out.println("Alumnos Registrados: ");
	        		for(int i=0;i<=100;i++) {
	        			System.out.println(i);
	        			Estudiantes[i].mostrarInformacion();
	        		}
	        		System.out.println("==========================================================");
	        		for(int i=0;i<=100;i++) {
	        			System.out.println(i);
	        			Cursos[i].mostrarInfo();
	        		}
	        		System.out.println("A que alumno Desea Matricular? (INGRESE EL CODIGO DEL ALUMNO): ");
	        		String da= input.next();
	        		System.out.println("A que curso? (INRESE EL CODIGO DEL CURSO): ");
	        		String dc= input.next();
	        		sistema.inscribirEstudianteACurso(da,dc);
	        }
	     // Asignación de profesor a curso (Agregación)
	        if(de==5) {
        		System.out.println("Profesores Registrados: ");
        		for(int i=0;i<=100;i++) {
        			System.out.println(i);
        			Profesores[i].mostrarInformacion();
        		}
        		System.out.println("==========================================================");
        		for(int i=0;i<=100;i++) {
        			System.out.println(i);
        			Cursos[i].mostrarInfo();
        		}
        		System.out.println("A que Profesor Desea Asignar? (INGRESE EL NUMERO DE PROFESOR): ");
        		int dp= input.nextInt();
        		System.out.println("A que curso? (INRESE EL NUMERO DE CURSO): ");
        		int dcp= input.nextInt();
        		Cursos[dcp].setProfesor(Profesores[dp]);
        		
	        }
	        if (de==6) {
        	 		// Mostrar reportes (Polimorfismo)
	        		sistema.mostrarInformacionDeTodos();
	        }
	        if (de==7) {
	        		break;
	        }
	       
        }
    }
}
