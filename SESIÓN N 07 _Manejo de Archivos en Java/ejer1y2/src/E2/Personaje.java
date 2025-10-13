package E2; // Importante: mantén esta línea si usas paquetes, sino quítala.

import java.io.Serializable;

public class Personaje implements Serializable {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private static final long serialVersionUID = 1L;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0) {
            throw new IllegalArgumentException("Todos los atributos deben ser mayores que cero.");
        }
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }

    // Setters con validación
    public void setVida(int vida) {
        if (vida <= 0) throw new IllegalArgumentException("La vida debe ser mayor que cero.");
        this.vida = vida;
    }
    public void setAtaque(int ataque) {
        if (ataque <= 0) throw new IllegalArgumentException("El ataque debe ser mayor que cero.");
        this.ataque = ataque;
    }
    public void setDefensa(int defensa) {
        if (defensa <= 0) throw new IllegalArgumentException("La defensa debe ser mayor que cero.");
        this.defensa = defensa;
    }
    public void setAlcance(int alcance) {
        if (alcance <= 0) throw new IllegalArgumentException("El alcance debe ser mayor que cero.");
        this.alcance = alcance;
    }

    // Método para la persistencia en archivo de texto
    public String toFileString() {
        return String.format("%s,%d,%d,%d,%d", nombre, vida, ataque, defensa, alcance);
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s | Vida: %d | Ataque: %d | Defensa: %d | Alcance: %d",
                             nombre, vida, ataque, defensa, alcance);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return nombre.equalsIgnoreCase(personaje.nombre);
    }
}