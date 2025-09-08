package GestionHotel;
public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false;
    }
}