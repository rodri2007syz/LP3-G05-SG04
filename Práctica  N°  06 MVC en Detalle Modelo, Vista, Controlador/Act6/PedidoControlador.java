package Act6;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipo) {
        if (!nombrePlato.isEmpty() && !tipo.isEmpty()) {
            Pedido pedido = new Pedido(nombrePlato, tipo);
            modelo.agregarPedido(pedido);
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipo + ")");
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacios.");
        }
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    public void eliminarPedido() {
        vista.mostrarPedidos(modelo.getPedidos());
        int indice = vista.solicitarIndice();
        if (modelo.eliminarPedido(indice)) {
            vista.mostrarMensaje("Pedido eliminado correctamente.");
        } else {
            vista.mostrarMensaje("Error: Numero de pedido no valido.");
        }
    }

    public void actualizarPedido() {
        vista.mostrarPedidos(modelo.getPedidos());
        int indice = vista.solicitarIndice();
        if (indice >= 0 && indice < modelo.getPedidos().size()) {
            String nuevoNombre = vista.solicitarNombrePlato();
            String nuevoTipo = vista.solicitarTipoPlato();
            if (modelo.actualizarPedido(indice, nuevoNombre, nuevoTipo)) {
                vista.mostrarMensaje("Pedido actualizado correctamente.");
            } else {
                vista.mostrarMensaje("Error al actualizar el pedido.");
            }
        } else {
            vista.mostrarMensaje("Error: Numero de pedido no valido.");
        }
    }

    public void buscarPorNombre() {
        String nombre = vista.solicitarNombrePlato();
        var resultados = modelo.buscarPorNombre(nombre);
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron pedidos con ese nombre.");
        } else {
            vista.mostrarPedidos(resultados);
        }
    }

    public void buscarPorTipo() {
        String tipo = vista.solicitarTipoPlato();
        var resultados = modelo.buscarPorTipo(tipo);
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron pedidos de ese tipo.");
        } else {
            vista.mostrarPedidos(resultados);
        }
    }

    public void marcarPedidoCompleto() {
        vista.mostrarPedidos(modelo.getPedidos());
        int indice = vista.solicitarIndice();
        if (modelo.marcarPedidoCompleto(indice)) {
            vista.mostrarMensaje("Pedido marcado como completado.");
        } else {
            vista.mostrarMensaje("Error: Numero de pedido no valido.");
        }
    }

    public void mostrarEstadisticas() {
        int total = modelo.getTotalPedidos();
        int pendientes = modelo.getPedidosPendientes();
        int entradas = modelo.getTotalPorTipo("Entrada");
        int principales = modelo.getTotalPorTipo("Principal");
        int postres = modelo.getTotalPorTipo("Postre");
        int bebidas = modelo.getTotalPorTipo("Bebida");
        
        vista.mostrarEstadisticas(total, pendientes, entradas, principales, postres, bebidas);
    }

    public void mostrarHistorial() {
        vista.mostrarMensaje("\n--- HISTORIAL DE PEDIDOS ---");
        vista.mostrarPedidos(modelo.getHistorialPedidos());
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            
            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipoPlato();
                    agregarPedido(nombre, tipo);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPorNombre();
                    break;
                case "6":
                    buscarPorTipo();
                    break;
                case "7":
                    marcarPedidoCompleto();
                    break;
                case "8":
                    mostrarEstadisticas();
                    break;
                case "9":
                    mostrarHistorial();
                    break;
                case "10":
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
            }
        } while (!opcion.equals("10"));
        vista.cerrarScanner();
    }
}