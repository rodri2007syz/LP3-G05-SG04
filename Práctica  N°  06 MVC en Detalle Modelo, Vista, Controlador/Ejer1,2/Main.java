package LAB6;

public class Main {
    public static void main(String[] args) {
        // Inicialización de los componentes MVC
        CarritoModelo modelo = new CarritoModelo();
        TiendaVista vista = new TiendaVista();
        TiendaControlador controlador = new TiendaControlador(modelo, vista);
        
        // Iniciar la aplicación
        controlador.iniciar();
    }
}