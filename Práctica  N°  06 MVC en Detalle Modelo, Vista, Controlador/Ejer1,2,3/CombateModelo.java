package LAB6;

import java.util.ArrayList;
import java.util.List;

public class CombateModelo {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Enemigo enemigoActual;
    private boolean enCombate;
    private String mensajeCombate;

    public CombateModelo(Jugador jugador) {
        this.jugador = jugador;
        this.enemigos = new ArrayList<>();
        this.enCombate = false;
        inicializarEnemigos();
    }

    private void inicializarEnemigos() {
        enemigos.add(new Enemigo("Goblin", 1));
        enemigos.add(new Enemigo("Orco", 2));
        enemigos.add(new Enemigo("Arana Gigante", 3));
        enemigos.add(new Enemigo("Esqueleto", 2));
        enemigos.add(new Enemigo("Mago Oscuro", 4));
    }

    public void iniciarCombate() {
        if (enemigos.isEmpty()) {
            mensajeCombate = "¡Todos los enemigos han sido derrotados!";
            return;
        }
        
        enemigoActual = enemigos.get((int)(Math.random() * enemigos.size()));
        enCombate = true;
        mensajeCombate = "¡Un " + enemigoActual.getNombre() + " nivel " + 
                         enemigoActual.getNivel() + " aparece!";
    }

    public void atacarEnemigo() {
        if (!enCombate || enemigoActual == null) return;

        int daño = jugador.atacar();
        enemigoActual.recibirDaño(daño);
        mensajeCombate = "¡Atacas al " + enemigoActual.getNombre() + " causando " + daño + " de daño!";

        if (!enemigoActual.estaVivo()) {
            mensajeCombate += "\n¡Has derrotado al " + enemigoActual.getNombre() + "!";
            jugador.subirNivel();
            mensajeCombate += "\n¡Has subido al nivel " + jugador.getNivel() + "!";
            enemigos.remove(enemigoActual);
            enCombate = false;
            return;
        }

        int dañoEnemigo = enemigoActual.atacar();
        jugador.recibirDaño(dañoEnemigo);
        mensajeCombate += "\nEl " + enemigoActual.getNombre() + " te ataca causando " + 
                         dañoEnemigo + " de daño.";

        if (!jugador.estaVivo()) {
            mensajeCombate += "\n¡Has sido derrotado!";
            enCombate = false;
        }
    }

    public void usarObjeto(String nombreObjeto) {
        if (!enCombate) return;

        if (jugador.usarObjeto(nombreObjeto)) {
            mensajeCombate = "Usas " + nombreObjeto + " y recuperas salud.";
            
            int dañoEnemigo = enemigoActual.atacar();
            jugador.recibirDaño(dañoEnemigo);
            mensajeCombate += "\nEl " + enemigoActual.getNombre() + " te ataca causando " + 
                             dañoEnemigo + " de daño.";
        } else {
            mensajeCombate = "No tienes ese objeto en el inventario.";
        }
    }

    public void huir() {
        if (enCombate) {
            mensajeCombate = "Logras huir del combate.";
            enCombate = false;
        }
    }

    public Jugador getJugador() { return jugador; }
    public Enemigo getEnemigoActual() { return enemigoActual; }
    public boolean isEnCombate() { return enCombate; }
    public String getMensajeCombate() { return mensajeCombate; }
    public List<Enemigo> getEnemigos() { return enemigos; }
}