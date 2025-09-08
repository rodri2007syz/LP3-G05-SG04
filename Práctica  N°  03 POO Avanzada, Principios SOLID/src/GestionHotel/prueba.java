// Main.java
package GestionHotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class prueba {
    public static void main(String[] args) {
        
        System.out.println("--- PRUEBA DEL SISTEMA DE RESERVAS ---");
        
        // Prueba de habitacion y controlador (SRP)
        Habitacion habitacionEstandar = new Habitacion("Estandar", 120.0);
        ControladorReserva controlador = new ControladorReserva();
        Cliente cliente = new Cliente();
        
        controlador.crearReserva(habitacionEstandar, cliente, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        
        // Prueba de cancelacion (OCP)
        // flexible
        Reserva reservaFlexible = new Reserva(habitacionEstandar, cliente, LocalDate.now().plusDays(2), LocalDate.now().plusDays(3), new PoliticaCancelacionFlexible());
        System.out.println("\nIntentando cancelar la reserva con politica flexible...");
        reservaFlexible.cancelar();
        
        // estricta
        Reserva reservaEstricta = new Reserva(habitacionEstandar, cliente, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2), new PoliticaCancelacionEstricta());
        System.out.println("\nIntentando cancelar la reserva con politica estricta...");
        reservaEstricta.cancelar();
        
        // Principio de Inversion de Dependencias
        System.out.println("\n--- PRUEBA DE NOTIFICACIONES ---");
        CanalNotificacion notificadorSMS = new EnviadorSMS();
        NotificadorReserva notificacion = new NotificadorReserva(notificadorSMS);
        notificacion.notificarCliente("Su reserva ha sido confirmada.");
        
        CanalNotificacion notificadorEmail = new EnviadorCorreo();
        NotificadorReserva notificacionEmail = new NotificadorReserva(notificadorEmail);
        notificacionEmail.notificarCliente("Su reserva ha sido confirmada.");
        
    }
}