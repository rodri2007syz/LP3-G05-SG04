package LAB6;

public class TiendaControlador {
    private CarritoModelo modelo;
    private TiendaVista vista;

    public TiendaControlador(CarritoModelo modelo, TiendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void listarProductos() {
        vista.mostrarProductos(modelo.getInventario());
    }

    public void agregarProductoAlCarrito() {
        String nombre = vista.solicitarNombre();
        int cantidad = vista.solicitarCantidad();
        if (cantidad <= 0) {
            vista.mostrarMensaje("La cantidad debe ser mayor a cero.");
            return;
        }
        
        if (modelo.agregarACarrito(nombre, cantidad)) {
            vista.mostrarMensaje("Producto(s) agregado(s) al carrito.");
        } else {
            vista.mostrarMensaje("Error: Producto no encontrado o stock insuficiente.");
        }
    }

    public void verCarrito() {
        double subtotal = modelo.calcularSubtotal();
        double descuento = modelo.getDescuentoPorcentaje();
        double envio = modelo.getCostoEnvio();
        double total = modelo.calcularTotal();
        
        vista.mostrarCarrito(modelo.getCarrito(), subtotal, descuento, envio, total);
    }
    
    public void eliminarProductoDelCarrito() {
        String nombre = vista.solicitarNombre();
        if (modelo.eliminarDeCarrito(nombre)) {
            vista.mostrarMensaje("Producto eliminado del carrito.");
        } else {
            vista.mostrarMensaje("Producto no encontrado en el carrito.");
        }
    }

    public void aplicarDescuento() {
        double porcentaje = vista.solicitarDescuento();
        if (porcentaje >= 0.0 && porcentaje <= 1.0) {
            modelo.setDescuento(porcentaje);
            vista.mostrarMensaje(String.format("Descuento del %.0f%% aplicado correctamente.", porcentaje * 100));
        } else {
            vista.mostrarMensaje("Porcentaje de descuento no valido (debe estar entre 0.0 y 1.0).");
        }
    }
    
    public void realizarCompra() {
        if (modelo.realizarCompra()) {
            vista.mostrarMensaje("COMPRA REALIZADA CON EXITO!");
            vista.mostrarMensaje("Tu carrito ha sido vaciado. Stock actualizado.");
        } else {
            vista.mostrarMensaje("No se puede realizar la compra: El carrito esta vacio.");
        }
    }
    
    public void verHistorial() {
        vista.mostrarHistorial(modelo.getHistorialCompras());
    }

    public void iniciarTienda() {
        String opcion;
        do {
            vista.mostrarMenuTienda();
            opcion = vista.solicitarOpcion();
            
            switch (opcion) {
                case "1": listarProductos(); break;
                case "2": agregarProductoAlCarrito(); break;
                case "3": verCarrito(); break;
                case "4": eliminarProductoDelCarrito(); break;
                case "5": aplicarDescuento(); break;
                case "6": realizarCompra(); break;
                case "7": verHistorial(); break;
                case "8": vista.mostrarMensaje("Volviendo al menu principal..."); break;
                default: vista.mostrarMensaje("Opcion no valida. Intentelo de nuevo.");
            }
        } while (!opcion.equals("8"));
    }
}