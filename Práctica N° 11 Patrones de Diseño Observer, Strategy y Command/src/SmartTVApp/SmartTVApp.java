package SmartTVApp;
import java.util.Scanner;


public class SmartTVApp {

    public static void main(String[] args) {

        Subject sistemaNotificaciones = new Subject();
        

        NotifUsuarios usuarioPrincipal = new NotifUsuarios("Usuario: Pierol");
        

        sistemaNotificaciones.attach(usuarioPrincipal);
        


        System.out.println("--- INICIANDO SISTEMA SMART TV ---");
        
        TV miTV = new TV();
        RemoteControl controlRemoto = new RemoteControl();


        Command prenderTV = new TVONCommand(miTV);
        controlRemoto.setCommand(prenderTV);
        controlRemoto.pressButton(); // TV prendida


        Command abrirMenu = new TVMenuCommand(miTV);
        controlRemoto.setCommand(abrirMenu);
        controlRemoto.pressButton(); 

        


        
        double precioPelicula = 100; // Precio
        PriceCalculator calculadora = new PriceCalculator();

   
        calculadora.setDiscountStrategy(new NoDiscount());
        
        double precioFinal = calculadora.calculatePrice(precioPelicula);
        
        System.out.println("Pelicula seleccionada: 'Estreno 2025'");
        System.out.println("Precio de lista: " + precioPelicula);
        System.out.println("Aplicando descuento de Miembro del Club...");
        System.out.println("Precio a pagar: " + precioFinal);



        System.out.println("\n--- CONFIRMACIÓN ---");
        

        if(precioFinal < precioPelicula) {
            sistemaNotificaciones.notifObservers("Compra exitosa de 'Estreno 2025' por " + precioFinal + " (Ahorraste dinero!)");
        } else {
            sistemaNotificaciones.notifObservers("Compra exitosa de 'Estreno 2025' por " + precioFinal);
        }
        
        // Apagar la TV al terminar
        Command apagarTV = new TVOFFCommand(miTV);
        controlRemoto.setCommand(apagarTV);
        controlRemoto.pressButton();
    }
}