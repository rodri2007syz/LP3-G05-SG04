package GestionHotel;
public class Habitacion {
    private String tipo;
    private double precioBase;
    private boolean estaDisponible;

    public Habitacion(String tipo, double precioBase) {
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.estaDisponible = true;
    }

    public void marcarReservada() { this.estaDisponible = false; }
    public void marcarDisponible() { this.estaDisponible = true; }
    
    public double getPrecioBase() { return precioBase; }
    public String getTipo() { return tipo; }
    public boolean estaDisponible() { return estaDisponible; }
}