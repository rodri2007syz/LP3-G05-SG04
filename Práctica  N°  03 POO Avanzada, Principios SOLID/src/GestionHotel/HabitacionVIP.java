package GestionHotel;
public class HabitacionVIP implements ServicioLimpieza, ServicioComida {
    @Override
    public void limpiar() {
        System.out.println("Habitacion VIP siendo limpiada.");
    }
    @Override
    public void entregarComida() {
        System.out.println("Comida entregada en la habitacion VIP.");
    }
}