package P11;

public class CalculadoraDePrecios {
    private EstrategiaDeDescuento estrategia;

    /**
     * Constructor que inicializa el Contexto con una estrategia por defecto.
     * @param estrategia La estrategia inicial de descuento.
     */
    public CalculadoraDePrecios(EstrategiaDeDescuento estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Permite cambiar la estrategia de descuento en tiempo de ejecución.
     * Este es el poder principal del Patrón Strategy.
     * @param nuevaEstrategia La nueva estrategia a aplicar.
     */
    public void establecerEstrategia(EstrategiaDeDescuento nuevaEstrategia) {
        this.estrategia = nuevaEstrategia;
    }

    /**
     * Delega la lógica de cálculo a la estrategia actual.
     * @param producto El producto a calcular.
     * @param cantidad La cantidad.
     * @return El precio final calculado.
     */
    public double calcularPrecioFinal(Producto producto, int cantidad) {
        System.out.println("\n--- Aplicando: " + this.estrategia.toString() + " ---");
        return this.estrategia.calcularPrecioFinal(producto, cantidad);
    }
}