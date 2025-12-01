package P11;

public class SinDescuento implements EstrategiaDeDescuento {
    @Override
    public double calcularPrecioFinal(Producto producto, int cantidad) {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Sin Descuento";
    }
}