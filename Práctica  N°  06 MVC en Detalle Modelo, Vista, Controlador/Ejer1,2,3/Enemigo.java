package LAB6;

public class Enemigo {
    private String nombre;
    private int salud;
    private int saludMaxima;
    private int nivel;
    private int dañoBase;

    public Enemigo(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.saludMaxima = 50 + (nivel * 10);
        this.salud = saludMaxima;
        this.dañoBase = 8 + (nivel * 2);
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getSaludMaxima() { return saludMaxima; }
    public int getNivel() { return nivel; }

    public int atacar() {
        return dañoBase + (int)(Math.random() * 5);
    }

    public void recibirDaño(int daño) {
        this.salud = Math.max(0, this.salud - daño);
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}