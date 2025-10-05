package Act6;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo de plato (Entrada, Principal, Postre, Bebida): ");
        return scanner.nextLine();
    }

    public int solicitarIndice() {
        System.out.print("Introduce el numero del pedido: ");
        try {
            return Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("\n--- LISTA DE PEDIDOS ---");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.printf("%d. %s - %s [%s]\n", 
                    i + 1, 
                    pedido.getNombrePlato(), 
                    pedido.getTipo(),
                    pedido.getEstado());
            }
            System.out.println("------------------------");
        }
    }

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTION DE PEDIDOS ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido por Nombre");
        System.out.println("6. Buscar Pedido por Tipo");
        System.out.println("7. Marcar Pedido como Completo");
        System.out.println("8. Mostrar Estadisticas");
        System.out.println("9. Ver Historial de Pedidos");
        System.out.println("10. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opcion: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEstadisticas(int total, int pendientes, int entradas, int principales, int postres, int bebidas) {
        System.out.println("\n--- ESTADISTICAS ---");
        System.out.println("Total de pedidos: " + total);
        System.out.println("Pedidos pendientes: " + pendientes);
        System.out.println("Entradas: " + entradas);
        System.out.println("Platos principales: " + principales);
        System.out.println("Postres: " + postres);
        System.out.println("Bebidas: " + bebidas);
        System.out.println("-------------------");
    }

    public void cerrarScanner() {
        scanner.close();
    }
}