package GestionHotel;
public class HabitacionSimple implements ServicioLimpieza {
    @Override
    public void limpiar() {
        System.out.println("Habitacion simple siendo limpiada.");
    }
}