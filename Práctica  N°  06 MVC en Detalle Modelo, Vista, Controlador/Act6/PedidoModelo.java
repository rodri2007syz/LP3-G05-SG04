package Act6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historialPedidos;

    public PedidoModelo() {
        this.pedidos = new ArrayList<>();
        this.historialPedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            pedido.marcarEliminado();
            historialPedidos.add(pedido);
            pedidos.remove(indice);
            return true;
        }
        return false;
    }

    public boolean actualizarPedido(int indice, String nuevoNombre, String nuevoTipo) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            pedido.setNombrePlato(nuevoNombre);
            pedido.setTipo(nuevoTipo);
            return true;
        }
        return false;
    }

    public boolean marcarPedidoCompleto(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            pedido.marcarCompletado();
            historialPedidos.add(pedido);
            pedidos.remove(indice);
            return true;
        }
        return false;
    }

    public List<Pedido> buscarPorNombre(String nombre) {
        return pedidos.stream()
                .filter(p -> p.getNombrePlato().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Pedido> buscarPorTipo(String tipo) {
        return pedidos.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Pedido> getPedidos() { return pedidos; }
    public List<Pedido> getHistorialPedidos() { return historialPedidos; }
    
    public int getTotalPedidos() { return pedidos.size(); }
    
    public int getTotalPorTipo(String tipo) {
        return (int) pedidos.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .count();
    }
    
    public int getPedidosPendientes() {
        return (int) pedidos.stream()
                .filter(Pedido::estaPendiente)
                .count();
    }
}