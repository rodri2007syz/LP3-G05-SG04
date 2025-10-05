package LAB6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarritoModelo {
    private List<Producto> inventario;
    // Carrito: <Producto, Cantidad>
    private Map<Producto, Integer> carrito; 
    private List<Map<Producto, Integer>> historialCompras;
    
    private double descuentoPorcentaje = 0.0;
    private final double costoEnvio = 15.0; // Costo fijo de envío

    public CarritoModelo() {
        this.inventario = new ArrayList<>();
        this.carrito = new HashMap<>();
        this.historialCompras = new ArrayList<>();
        inicializarInventario();
    }
    
    private void inicializarInventario() {
        // Inicializa el inventario con algunos productos
        inventario.add(new Producto("Laptop Pro", 1200.00, 5));
        inventario.add(new Producto("Teclado Mecánico", 85.50, 10));
        inventario.add(new Producto("Monitor 4K", 450.00, 3));
    }

    // Lógica principal del carrito
    
    public List<Producto> getInventario() { return inventario; }
    public Map<Producto, Integer> getCarrito() { return carrito; }
    public List<Map<Producto, Integer>> getHistorialCompras() { return historialCompras; }

    // Métodos de manipulación del Carrito
    public boolean agregarACarrito(String nombreProducto, int cantidad) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (p.getStock() >= cantidad) {
                    // Agrega o actualiza la cantidad en el carrito
                    carrito.put(p, carrito.getOrDefault(p, 0) + cantidad);
                    return true;
                }
            }
        }
        return false; // Producto no encontrado o stock insuficiente
    }

    public boolean eliminarDeCarrito(String nombreProducto) {
        for (Producto p : carrito.keySet()) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                carrito.remove(p);
                return true;
            }
        }
        return false;
    }
    
    // Cálculos Financieros
    
    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            subtotal += entry.getKey().getPrecio() * entry.getValue();
        }
        return subtotal;
    }
    
    public double aplicarDescuento(double subtotal) {
        return subtotal * (1 - this.descuentoPorcentaje);
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        double totalConDescuento = aplicarDescuento(subtotal);
        return totalConDescuento + costoEnvio;
    }
    
    public double getCostoEnvio() { return costoEnvio; }
    public double getDescuentoPorcentaje() { return descuentoPorcentaje; }
    
    public void setDescuento(double porcentaje) {
        if (porcentaje >= 0.0 && porcentaje <= 1.0) {
            this.descuentoPorcentaje = porcentaje;
        }
    }
    
    // Realizar Compra
    public boolean realizarCompra() {
        if (carrito.isEmpty()) {
            return false;
        }
        
        // 1. Actualizar Stock e Historial
        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            Producto p = entry.getKey();
            int cantidad = entry.getValue();
            p.setStock(p.getStock() - cantidad); // Restar del inventario
        }
        
        // 2. Guardar carrito en historial
        historialCompras.add(new HashMap<>(carrito));
        
        // 3. Vaciar carrito y resetear descuento
        carrito.clear();
        descuentoPorcentaje = 0.0;
        return true;
    }
}