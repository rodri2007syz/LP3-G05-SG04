
package GestionHotel;
import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    public boolean verificarDisponibilidad(List<Reserva> reservas, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Reserva r : reservas) {

            if (r.getFechaInicio().isBefore(fechaFin) && r.getFechaInicio().isAfter(fechaInicio)) {
                return false;
            }
        }
        return true;
    }
} 