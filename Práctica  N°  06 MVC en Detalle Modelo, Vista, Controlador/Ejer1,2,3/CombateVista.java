package LAB6;

import java.util.Scanner;

public class CombateVista {
    private Scanner scanner;

    public CombateVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n=== ESTADO DE COMBATE ===");
        System.out.printf("JUGADOR: %s | Salud: %d/%d | Nivel: %d | Arma: %s\n",
                jugador.getNombre(), jugador.getSalud(), jugador.getSaludMaxima(),
                jugador.getNivel(), 
                jugador.getArmaEquipada() != null ? jugador.getArmaEquipada().getNombre() : "Ninguna");
        
        if (enemigo != null) {
            System.out.printf("ENEMIGO: %s | Salud: %d/%d | Nivel: %d\n",
                    enemigo.getNombre(), enemigo.getSalud(), enemigo.getSaludMaxima(),
                    enemigo.getNivel());
        }
        System.out.println("==========================");
    }

    public void mostrarMensajeCombate(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarInventarioJugador(Jugador jugador) {
        System.out.println("\n--- INVENTARIO DEL JUGADOR ---");
        if (jugador.getInventario().isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        
        System.out.printf("%-20s %-10s\n", "OBJETO", "CANTIDAD");
        System.out.println("--------------------------------");
        for (Producto item : jugador.getInventario()) {
            System.out.printf("%-20s %-10d\n", item.getNombre(), item.getStock());
        }
        System.out.println("--------------------------------");
    }

    public void mostrarMenuCombate() {
        System.out.println("\n--- OPCIONES DE COMBATE ---");
        System.out.println("1. Atacar");
        System.out.println("2. Usar objeto");
        System.out.println("3. Huir");
        System.out.println("4. Ver inventario");
        System.out.println("5. Ver estado");
        System.out.println("6. Salir del combate");
    }

    public int solicitarOpcionCombate() {
        System.out.print("Selecciona una opcion: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String solicitarNombreObjeto() {
        System.out.print("Introduce el nombre del objeto: ");
        return scanner.nextLine();
    }

    public String solicitarNombreArma() {
        System.out.print("Introduce el nombre del arma a equipar: ");
        return scanner.nextLine();
    }

    public void mostrarArmaEquipada(Jugador jugador) {
        if (jugador.getArmaEquipada() != null) {
            System.out.println("Arma equipada: " + jugador.getArmaEquipada().getNombre());
        } else {
            System.out.println("No tienes arma equipada.");
        }
    }
}