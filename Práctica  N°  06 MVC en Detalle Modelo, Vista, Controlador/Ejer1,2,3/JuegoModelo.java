package LAB6;

public class JuegoModelo {
    private Jugador jugador;
    private CombateModelo combateModelo;
    private CarritoModelo tiendaModelo;

    public JuegoModelo() {
        this.jugador = new Jugador("Heroe");
        this.combateModelo = new CombateModelo(jugador);
        this.tiendaModelo = new CarritoModelo();
    }

    public Jugador getJugador() { return jugador; }
    public CombateModelo getCombateModelo() { return combateModelo; }
    public CarritoModelo getTiendaModelo() { return tiendaModelo; }
}