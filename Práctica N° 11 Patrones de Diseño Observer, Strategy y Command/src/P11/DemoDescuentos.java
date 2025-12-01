package P11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DemoDescuentos {

    public static void main(String[] args) {
        // 1. Definir el Producto y la Cantidad
        Producto producto = new Producto("Smartwatch Pro", 150.00);
        int cantidad = 3; // PRUEBA: Cambia a 1, 2 o 3 para ver las reglas en acción.

        // 2. Mapear las estrategias disponibles
        Map<Integer, EstrategiaDeDescuento> estrategias = new HashMap<>();
        estrategias.put(1, new SinDescuento());
        estrategias.put(2, new DescuentoFijo());
        estrategias.put(3, new DescuentoPorcentual());
        estrategias.put(4, new DescuentoPorcentualAcumulado());

        // 3. Inicializar la calculadora con una estrategia por defecto
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios(estrategias.get(1));
        Scanner scanner = new Scanner(System.in);

        int opcion;
        double precioOriginal = producto.getPrecio() * cantidad;

        do {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("CÁLCULO DE PRECIOS CON PATRÓN STRATEGY");
            System.out.println("Producto: " + producto.getNombre() + " | Cantidad: " + cantidad);
            System.out.println("Precio Original (Sin Desc.): $" + String.format("%.2f", precioOriginal));
            System.out.println("------------------------------------------------------------");
            System.out.println("Selecciona una estrategia de descuento:");
            System.out.println("1. " + estrategias.get(1));
            System.out.println("2. " + estrategias.get(2));
            System.out.println("3. " + estrategias.get(3));
            System.out.println("4. " + estrategias.get(4));
            System.out.println("5. Salir");
            System.out.println("=".repeat(60));
            System.out.print("Ingresa el número de la opción: ");

            try {
                opcion = scanner.nextInt();
                if (estrategias.containsKey(opcion)) {
                    // Cambiar la estrategia en tiempo de ejecución
                    calculadora.establecerEstrategia(estrategias.get(opcion));

                    // Calcular y mostrar el resultado
                    double precioFinal = calculadora.calcularPrecioFinal(producto, cantidad);
                    System.out.println("Precio Final con Descuento: **$" + String.format("%.2f", precioFinal) + "**");

                } else if (opcion != 5) {
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                scanner.next(); // Consumir la entrada no válida
                opcion = 0;
            }

        } while (opcion != 5);

        scanner.close();
        System.out.println("\n¡Programa de descuentos finalizado!");
    }
}