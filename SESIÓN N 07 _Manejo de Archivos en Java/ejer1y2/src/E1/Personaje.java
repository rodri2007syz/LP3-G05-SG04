package E1;

import java.io.Serializable;

public class Personaje implements Serializable {
    // Atributos
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    
    // El 'serialVersionUID' no es estrictamente necesario para esta solución simple de texto,
    // pero es buena práctica si se usara serialización de objetos (como se vio en la guía).
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que valida que los atributos sean mayores a cero.
     * @throws IllegalArgumentException si algún atributo es menor o igual a cero.
     */
    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0) {
            throw new IllegalArgumentException("Todos los atributos (vida, ataque, defensa, alcance) deben ser mayores que cero.");
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

    // Setters (para modificación, asumiendo que el nombre no cambia)
    // Se mantiene la validación para asegurar la integridad de los datos.
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

    /**
     * Devuelve la representación del personaje en formato de línea de archivo (CSV).
     * Formato: Nombre,Vida,Ataque,Defensa,Alcance
     */
    public String toFileString() {
        return String.format("%s,%d,%d,%d,%d", nombre, vida, ataque, defensa, alcance);
    }

    /**
     * Sobreescribe el método toString() para una visualización amigable en consola.
     */
    @Override
    public String toString() {
        return String.format("--- %s ---\n  Vida: %d, Ataque: %d, Defensa: %d, Alcance: %d",
                             nombre, vida, ataque, defensa, alcance);
    }
    
    /**
     * Método equals para verificar si un personaje ya existe (basado en el nombre).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return nombre.equalsIgnoreCase(personaje.nombre);
    }
    
    // Nota: Es buena práctica también sobrescribir hashCode, pero se omite por brevedad.
}