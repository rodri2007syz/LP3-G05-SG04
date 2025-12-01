package P11;

public class DescuentoFijo implements EstrategiaDeDescuento {
    private static final double PORCENTAJE_DESCUENTO = 0.10; // 10%

    @Override
    public double calcularPrecioFinal(Producto producto, int cantidad) {
        double precioTotal = producto.getPrecio() * cantidad;
        return precioTotal * (1 - PORCENTAJE_DESCUENTO);
    }

    @Override
    public String toString() {
        return "Descuento Fijo (10% sobre el total)";
    }
}