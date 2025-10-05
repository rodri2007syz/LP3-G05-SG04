package LAB6;

import java.util.Scanner;

public class JuegoVista {
    private Scanner scanner;

    public JuegoVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Iniciar Combate");
        System.out.println("2. Ver Estado del Jugador");
        System.out.println("3. Equipar Arma");
        System.out.println("4. Ir a la Tienda");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    public int solicitarOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}