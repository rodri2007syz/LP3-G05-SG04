package GestionHotel;
import java.time.Duration;
import java.time.LocalDate;
public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        long horasHastaCheckIn = Duration.between(LocalDate.now().atStartOfDay(), reserva.getFechaInicio().atStartOfDay()).toHours();
        return horasHastaCheckIn > 24;
    }
}