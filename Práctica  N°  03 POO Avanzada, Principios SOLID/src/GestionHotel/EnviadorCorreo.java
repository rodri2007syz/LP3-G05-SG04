package GestionHotel;
public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }
}