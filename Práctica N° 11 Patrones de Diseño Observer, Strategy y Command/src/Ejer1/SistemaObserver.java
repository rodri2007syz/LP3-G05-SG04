package Ejer1;

import java.util.ArrayList;
import java.util.List;

class Notificacion {
    private String titulo;
    private String mensaje;

    public Notificacion(String titulo, String mensaje) {
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Notificacion || Titulo: " + titulo + ", Mensaje: " + mensaje + "";
    }
}

class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }


    public void recibirNotificacion(Notificacion notificacion) {
        System.out.println( nombre + " ha recibido: " + notificacion.toString());
    }
    
    public String getNombre() {
        return nombre;
    }
}

class PlataformaDeContenido {

    private List<Usuario> suscriptores = new ArrayList<>();

    public void suscribir(Usuario usuario) {
        if (!suscriptores.contains(usuario)) {
            suscriptores.add(usuario);
            System.out.println( usuario.getNombre() + " se ha suscrito.");
        }
    }

    public void desuscribir(Usuario usuario) {
        if (suscriptores.remove(usuario)) {
            System.out.println(usuario.getNombre() + " se ha desuscrito.");
        }
    }

    public void publicarEvento(String titulo, String mensaje) {
        Notificacion evento = new Notificacion(titulo, mensaje);
        System.out.println(" PUBLICANDO EVENTO " + titulo + " ---");
        for (Usuario usuario : suscriptores) {
            usuario.recibirNotificacion(evento);
        }
    }
}