package LAB6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarritoModelo {
    private List<Producto> inventario;
    private Map<Producto, Integer> carrito; 
    private List<Map<Producto, Integer>> historialCompras;
    
    private double descuentoPorcentaje = 0.0;
    private final double costoEnvio = 15.0;

    public CarritoModelo() {
        this.inventario = new ArrayList<>();
        this.carrito = new HashMap<>();
        this.historialCompras = new ArrayList<>();
        inicializarInventario();
    }
    
    private void inicializarInventario() {
        inventario.add(new Producto("Laptop Pro", 1200.00, 5));
        inventario.add(new Producto("Teclado Mecanico", 85.50, 10));
        inventario.add(new Producto("Monitor 4K", 450.00, 3));
    }

    public List<Producto> getInventario() { return inventario; }
    public Map<Producto, Integer> getCarrito() { return carrito; }
    public List<Map<Producto, Integer>> getHistorialCompras() { return historialCompras; }

    public boolean agregarACarrito(String nombreProducto, int cantidad) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (p.getStock() >= cantidad) {
                    carrito.put(p, carrito.getOrDefault(p, 0) + cantidad);
                    return true;
                }
            }
        }
        return false;
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
    
    public boolean realizarCompra() {
        if (carrito.isEmpty()) {
            return false;
        }
        
        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            Producto p = entry.getKey();
            int cantidad = entry.getValue();
            p.setStock(p.getStock() - cantidad);
        }
        
        historialCompras.add(new HashMap<>(carrito));
        carrito.clear();
        descuentoPorcentaje = 0.0;
        return true;
    }
}