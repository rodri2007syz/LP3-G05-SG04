package E1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPersonajes gestor = new GestorPersonajes();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- MENÚ GESTOR DE PERSONAJES -----");
            System.out.println("1. Añadir nuevo personaje");
            System.out.println("2. Mostrar todos los personajes");
            System.out.println("3. Modificar personaje por nombre");
            System.out.println("4. Borrar personaje por nombre");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea

                try {
                    switch (opcion) {
                        case 1:
                            añadirPersonaje(gestor, sc);
                            break;
                        case 2:
                            gestor.mostrarPersonajes();
                            break;
                        case 3:
                            modificarPersonaje(gestor, sc);
                            break;
                        case 4:
                            borrarPersonaje(gestor, sc);
                            break;
                        case 5:
                            System.out.println("Saliendo del gestor. ¡Hasta pronto!");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                } catch (Exception e) {
                    System.err.println("Ocurrió un error inesperado: " + e.getMessage());
                }
            } else {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                sc.nextLine(); // Limpiar el buffer
                opcion = 0;
            }

        } while (opcion != 5);

        sc.close();
    }

    private static void añadirPersonaje(GestorPersonajes gestor, Scanner sc) {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Vida (>0): ");
            int vida = sc.nextInt();
            System.out.print("Ataque (>0): ");
            int ataque = sc.nextInt();
            System.out.print("Defensa (>0): ");
            int defensa = sc.nextInt();
            System.out.print("Alcance (>0): ");
            int alcance = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
            gestor.añadirPersonaje(p);
        } catch (IllegalArgumentException e) {
            System.err.println("Error en los datos: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Error de entrada: Por favor, ingrese un número entero.");
            sc.nextLine(); // Limpiar el buffer
        }
    }

    private static void modificarPersonaje(GestorPersonajes gestor, Scanner sc) {
        try {
            System.out.print("Ingrese el nombre del personaje a modificar: ");
            String nombre = sc.nextLine();

            Personaje p = gestor.buscarPersonaje(nombre);
            if (p == null) {
                System.out.println("Personaje no encontrado.");
                return;
            }

            System.out.println("Modificando a: " + p.getNombre() + ". Ingrese nuevos valores:");
            System.out.print("Nueva Vida (" + p.getVida() + "): ");
            int vida = sc.nextInt();
            System.out.print("Nuevo Ataque (" + p.getAtaque() + "): ");
            int ataque = sc.nextInt();
            System.out.print("Nueva Defensa (" + p.getDefensa() + "): ");
            int defensa = sc.nextInt();
            System.out.print("Nuevo Alcance (" + p.getAlcance() + "): ");
            int alcance = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            gestor.modificarPersonaje(nombre, vida, ataque, defensa, alcance);
        } catch (java.util.InputMismatchException e) {
            System.err.println("Error de entrada: Por favor, ingrese un número entero.");
            sc.nextLine();
        }
    }

    private static void borrarPersonaje(GestorPersonajes gestor, Scanner sc) {
        System.out.print("Ingrese el nombre del personaje a borrar: ");
        String nombre = sc.nextLine();
        gestor.borrarPersonaje(nombre);
    }
}