package P11;

public class DescuentoPorcentualAcumulado implements EstrategiaDeDescuento {
    private static final double PORCENTAJE_DESCUENTO = 0.50; // 50%
    private static final int CANTIDAD_MINIMA = 3;

    @Override
    public double calcularPrecioFinal(Producto producto, int cantidad) {
        double precioTotal = producto.getPrecio() * cantidad;

        if (cantidad >= CANTIDAD_MINIMA) {
            // Descuento del 50% sobre el precio de UN producto.
            double descuentoUnitario = producto.getPrecio() * PORCENTAJE_DESCUENTO;
            System.out.println("  (Aplicando 50% de descuento sobre 1 unidad por Cantidad>=3)");
            return precioTotal - descuentoUnitario;
        } else {
            System.out.println("  (Aviso: Requiere 3 o más unidades para el Descuento Acumulado)");
            return precioTotal;
        }
    }

    @Override
    public String toString() {
        return "Descuento Acumulado (50% sobre 1 unid. si Cantidad>=3)";
    }
}