package GestionHotel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorReserva {
    private List<Reserva> reservas = new ArrayList<>();
    private GestorDisponibilidadHabitacion gestorDisponibilidad = new GestorDisponibilidadHabitacion();

    public void crearReserva(Habitacion habitacion, Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin) {
        if (gestorDisponibilidad.verificarDisponibilidad(reservas, fechaInicio, fechaFin)) {
            Reserva nuevaReserva = new Reserva(habitacion, cliente, fechaInicio, fechaFin, new PoliticaCancelacionFlexible());
            reservas.add(nuevaReserva);
            habitacion.marcarReservada();
            System.out.println("Reserva creada con exito.");
        } else {
            System.out.println("La habitacion no esta disponible en las fechas seleccionadas.");
        }
    }
}