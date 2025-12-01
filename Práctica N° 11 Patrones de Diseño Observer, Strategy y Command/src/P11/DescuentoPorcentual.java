package P11;

public class DescuentoPorcentual implements EstrategiaDeDescuento {
    private static final double PORCENTAJE_DESCUENTO = 0.30; // 30%
    private static final int CANTIDAD_REQUERIDA = 2;

    @Override
    public double calcularPrecioFinal(Producto producto, int cantidad) {
        double precioTotal = producto.getPrecio() * cantidad;

        if (cantidad == CANTIDAD_REQUERIDA) {
            System.out.println("  (Aplicando 30% de descuento por 2 unidades)");
            return precioTotal * (1 - PORCENTAJE_DESCUENTO);
        } else {
            System.out.println("  (Aviso: Requiere exactamente 2 unidades para 30% OFF)");
            return precioTotal;
        }
    }

    @Override
    public String toString() {
        return "Descuento Porcentual (30% si Cantidad=2)";
    }
}