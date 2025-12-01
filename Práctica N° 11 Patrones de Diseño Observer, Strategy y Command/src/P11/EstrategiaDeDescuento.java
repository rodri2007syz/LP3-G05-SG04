package P11;

public interface EstrategiaDeDescuento {
    /**
     * Calcula el precio final aplicando la lógica de descuento específica.
     * @param producto El producto al que se aplica el descuento.
     * @param cantidad La cantidad de unidades compradas.
     * @return El precio total final después del descuento.
     */
    double calcularPrecioFinal(Producto producto, int cantidad);
}