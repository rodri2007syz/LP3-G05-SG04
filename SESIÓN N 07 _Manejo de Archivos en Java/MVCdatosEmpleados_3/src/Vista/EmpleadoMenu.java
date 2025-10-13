package Vista;

import Modelo.Empleado;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmpleadoMenu {
    private final Scanner scanner = new Scanner(System.in);
    
    public int mostrarMenu() {
        System.out.println("\n-------------------------------------------");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar un empleado por su numero");
        System.out.println("4. Eliminar un empleado por su numero");
        System.out.println("5. Salir del programa");
        System.out.print("Selecciona una opcion: ");
        
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }


    public void mostrarListaEmpleados(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("\n---Empleados registrados ---");
        empleados.forEach(System.out::println);
        System.out.println("--------------------------");
    }

  
    public Empleado solicitarDatosNuevoEmpleado() {
        try {
            System.out.print("Ingrese Numero: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese Sueldo: ");
            double sueldo = scanner.nextDouble();
            scanner.nextLine(); 
            
            return new Empleado(numero, nombre, sueldo);
        } catch (InputMismatchException e) {
            mostrarMensajeError("Error de entrada ingresar tipos de datos correctos numero, sueldo.");
            scanner.nextLine(); 
            return null;
        }
    }
    

    public int solicitarNumeroEmpleado() {
        try {
            System.out.print("Ingrese el numero de empleado: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); 
            return numero;
        } catch (InputMismatchException e) {
            mostrarMensajeError("El numero debe ser un valor entero.");
            scanner.nextLine(); 
            return -1;
        }
    }


    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println("Empleado encontrado");
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
    

    public void mostrarMensajeExito(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMensajeError(String mensaje) {
        System.err.println(mensaje);
    }
}