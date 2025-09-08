package GestionHotel;
public class NotificadorReserva {
    private final CanalNotificacion canal;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }

    public void notificarCliente(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}