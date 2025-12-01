package Ejer1;

public class main {

    public static void main(String[] args) {
        

        PlataformaDeContenido plataforma = new PlataformaDeContenido();


        Usuario user1 = new Usuario("Anderson");
        Usuario user2 = new Usuario("Rodri");
        Usuario user3 = new Usuario("Pierol");
        Usuario user4 = new Usuario("Fernando");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(" INICIO DE SESION");
        
        plataforma.suscribir(user1);
        plataforma.suscribir(user2);
        
        System.out.println("------------------------------------------------------------------------------------");
        plataforma.publicarEvento("Actualizacion V2.0","regulacion de peliculas por pais");

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("GESTION - SUSCRIPCIONES ---");
        

        plataforma.suscribir(user3);
        plataforma.desuscribir(user2);
        plataforma.desuscribir(user4);
        System.out.println("------------------------------------------------------------------------------------");
        plataforma.publicarEvento("PROMO FLASH", "¡Solo por hoy, 30% de descuento en suscripciones premium!");


    }
}