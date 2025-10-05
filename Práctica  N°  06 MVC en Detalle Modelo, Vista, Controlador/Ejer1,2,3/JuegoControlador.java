package LAB6;

public class JuegoControlador {
    private JuegoModelo modelo;
    private JuegoVista vista;
    private CombateControlador combateControlador;
    private TiendaControlador tiendaControlador;

    public JuegoControlador() {
        this.modelo = new JuegoModelo();
        this.vista = new JuegoVista();
        this.combateControlador = new CombateControlador(
            modelo.getCombateModelo(), 
            new CombateVista()
        );
        this.tiendaControlador = new TiendaControlador(
            modelo.getTiendaModelo(),
            new TiendaVista()
        );
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenuPrincipal();
            opcion = vista.solicitarOpcion();
            
            switch (opcion) {
                case 1:
                    combateControlador.iniciarCombate();
                    break;
                case 2:
                    combateControlador.mostrarEstadoJugador();
                    break;
                case 3:
                    combateControlador.equiparArma();
                    break;
                case 4:
                    tiendaControlador.iniciarTienda();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del juego. ¡Hasta pronto!");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
            }
        } while (opcion != 5);
        
        vista.cerrarScanner();
    }
}