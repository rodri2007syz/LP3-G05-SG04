package GestionHotel;
import java.time.LocalDate;
public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private PoliticaCancelacion politica;

    public Reserva(Habitacion habitacion, Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin, PoliticaCancelacion politica) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politica = politica;
    }

    public void cancelar() {
        if (politica.puedeCancelar(this)) {
            habitacion.marcarDisponible();
            System.out.println("Reserva cancelada con exito.");
        } else {
            System.out.println("La reserva no puede ser cancelada bajo esta politica.");
        }
    }

    public LocalDate getFechaInicio() { return fechaInicio; }
}