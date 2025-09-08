package GestionHotel;
public class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
    }
}