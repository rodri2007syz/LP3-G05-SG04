package LAB6;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int saludMaxima;
    private int nivel;
    private List<Producto> inventario;
    private Producto armaEquipada;
    private int defensa;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.saludMaxima = 100;
        this.nivel = 1;
        this.inventario = new ArrayList<>();
        this.defensa = 5;
        inicializarInventarioInicial();
    }

    private void inicializarInventarioInicial() {
        inventario.add(new Producto("Espada de Madera", 0, 1));
        inventario.add(new Producto("Pocion de Salud", 0, 3));
        equiparArma("Espada de Madera");
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getSaludMaxima() { return saludMaxima; }
    public int getNivel() { return nivel; }
    public List<Producto> getInventario() { return inventario; }
    public Producto getArmaEquipada() { return armaEquipada; }
    public int getDefensa() { return defensa; }

    public int atacar() {
        if (armaEquipada != null) {
            int dañoBase = calcularDañoBase();
            return dañoBase + (nivel * 2);
        }
        return 5 + nivel;
    }

    private int calcularDañoBase() {
        String nombreArma = armaEquipada.getNombre();
        if (nombreArma.contains("Espada")) return 15;
        else if (nombreArma.contains("Hacha")) return 20;
        else if (nombreArma.contains("Arco")) return 12;
        else if (nombreArma.contains("Varita")) return 18;
        return 10;
    }

    public void recibirDaño(int daño) {
        int dañoReal = Math.max(1, daño - defensa);
        this.salud = Math.max(0, this.salud - dañoReal);
    }

    public void curar(int cantidad) {
        this.salud = Math.min(saludMaxima, this.salud + cantidad);
    }

    public boolean usarObjeto(String nombreObjeto) {
        for (Producto item : inventario) {
            if (item.getNombre().equalsIgnoreCase(nombreObjeto)) {
                if (item.getNombre().contains("Pocion")) {
                    curar(30);
                    item.setStock(item.getStock() - 1);
                    if (item.getStock() <= 0) {
                        inventario.remove(item);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equiparArma(String nombreArma) {
        for (Producto item : inventario) {
            if (item.getNombre().equalsIgnoreCase(nombreArma) && 
                (item.getNombre().contains("Espada") || item.getNombre().contains("Hacha") || 
                 item.getNombre().contains("Arco") || item.getNombre().contains("Varita"))) {
                this.armaEquipada = item;
                return true;
            }
        }
        return false;
    }

    public void agregarAlInventario(Producto producto) {
        for (Producto item : inventario) {
            if (item.getNombre().equals(producto.getNombre())) {
                item.setStock(item.getStock() + producto.getStock());
                return;
            }
        }
        inventario.add(new Producto(producto.getNombre(), producto.getPrecio(), producto.getStock()));
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public void subirNivel() {
        nivel++;
        saludMaxima += 20;
        salud = saludMaxima;
        defensa += 2;
    }
}