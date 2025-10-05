package LAB6;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TiendaVista {
    private Scanner scanner;

    public TiendaVista() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarProductos(List<Producto> inventario) {
        System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
        System.out.printf("%-20s %-10s %-5s\n", "NOMBRE", "PRECIO", "STOCK");
        System.out.println("----------------------------------------");
        for (Producto p : inventario) {
            System.out.printf("%-20s $%-9.2f %-5d\n", 
                              p.getNombre(), p.getPrecio(), p.getStock());
        }
        System.out.println("----------------------------------------");
    }

    public void mostrarCarrito(Map<Producto, Integer> carrito, double subtotal, double descuento, double envio, double total) {
        System.out.println("\n--- TU CARRITO DE COMPRAS ---");
        if (carrito.isEmpty()) {
            System.out.println("El carrito esta vacio.");
            return;
        }
        
        System.out.printf("%-20s %-10s %-10s %-10s\n", "PRODUCTO", "CANTIDAD", "PRECIO/U", "TOTAL");
        System.out.println("----------------------------------------------------------");
        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            Producto p = entry.getKey();
            int cantidad = entry.getValue();
            System.out.printf("%-20s %-10d $%-9.2f $%-9.2f\n", 
                              p.getNombre(), cantidad, p.getPrecio(), p.getPrecio() * cantidad);
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Descuento (%.0f%%): -$%.2f\n", descuento * 100, subtotal * descuento);
        System.out.printf("Costo de Envio: $%.2f\n", envio);
        System.out.printf("TOTAL A PAGAR: $%.2f\n", total);
        System.out.println("----------------------------------------------------------");
    }
    
    public void mostrarHistorial(List<Map<Producto, Integer>> historial) {
        System.out.println("\n--- HISTORIAL DE COMPRAS ---");
        if (historial.isEmpty()) {
            System.out.println("No hay compras registradas.");
            return;
        }
        int i = 1;
        for (Map<Producto, Integer> compra : historial) {
            System.out.println("\nCompra #" + i++);
            compra.forEach((p, cant) -> System.out.printf(" - %s x %d\n", p.getNombre(), cant));
        }
        System.out.println("----------------------------");
    }

    public String solicitarNombre() {
        System.out.print("Introduce el nombre del producto: ");
        return scanner.nextLine();
    }

    public int solicitarCantidad() {
        System.out.print("Introduce la cantidad: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            mostrarMensaje("Entrada no valida. Introduce un numero.");
            return 0;
        }
    }
    
    public double solicitarDescuento() {
        System.out.print("Introduce el porcentaje de descuento (e.g., 0.10 para 10%): ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            mostrarMensaje("Entrada no valida.");
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void mostrarMenuTienda() {
        System.out.println("\n--- MENU TIENDA ---");
        System.out.println("1. Listar Productos (Inventario)");
        System.out.println("2. Agregar Producto al Carrito");
        System.out.println("3. Ver Carrito y Calcular Total");
        System.out.println("4. Eliminar Producto del Carrito");
        System.out.println("5. Aplicar Descuento");
        System.out.println("6. Realizar Compra");
        System.out.println("7. Ver Historial de Compras");
        System.out.println("8. Volver al Menu Principal");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opcion: ");
        return scanner.nextLine();
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}