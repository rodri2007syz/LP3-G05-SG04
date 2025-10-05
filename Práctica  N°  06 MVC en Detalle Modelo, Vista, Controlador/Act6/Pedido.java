package Act6;

public class Pedido {
    private String nombrePlato;
    private String tipo;
    private String estado; // "pendiente", "completado", "eliminado"

    public Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato;
        this.tipo = "General";
        this.estado = "pendiente";
    }

    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.estado = "pendiente";
    }

    public String getNombrePlato() { return nombrePlato; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    
    public void setNombrePlato(String nombrePlato) { this.nombrePlato = nombrePlato; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public void marcarCompletado() { this.estado = "completado"; }
    public void marcarEliminado() { this.estado = "eliminado"; }
    public boolean estaPendiente() { return "pendiente".equals(estado); }
    public boolean estaCompletado() { return "completado".equals(estado); }
}