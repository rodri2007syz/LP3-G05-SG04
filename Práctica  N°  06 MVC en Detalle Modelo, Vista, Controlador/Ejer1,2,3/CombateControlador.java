package LAB6;

public class CombateControlador {
    private CombateModelo modelo;
    private CombateVista vista;

    public CombateControlador(CombateModelo modelo, CombateVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        modelo.iniciarCombate();
        vista.mostrarMensajeCombate(modelo.getMensajeCombate());
        
        if (!modelo.isEnCombate()) {
            return;
        }

        ejecutarCicloCombate();
    }

    private void ejecutarCicloCombate() {
        while (modelo.isEnCombate() && modelo.getJugador().estaVivo()) {
            vista.mostrarEstadoCombate(modelo.getJugador(), modelo.getEnemigoActual());
            vista.mostrarMenuCombate();
            
            int opcion = vista.solicitarOpcionCombate();
            
            switch (opcion) {
                case 1:
                    modelo.atacarEnemigo();
                    vista.mostrarMensajeCombate(modelo.getMensajeCombate());
                    break;
                    
                case 2:
                    vista.mostrarInventarioJugador(modelo.getJugador());
                    String objeto = vista.solicitarNombreObjeto();
                    modelo.usarObjeto(objeto);
                    vista.mostrarMensajeCombate(modelo.getMensajeCombate());
                    break;
                    
                case 3:
                    modelo.huir();
                    vista.mostrarMensajeCombate(modelo.getMensajeCombate());
                    break;
                    
                case 4:
                    vista.mostrarInventarioJugador(modelo.getJugador());
                    break;
                    
                case 5:
                    vista.mostrarEstadoCombate(modelo.getJugador(), modelo.getEnemigoActual());
                    break;
                    
                case 6:
                    modelo.huir();
                    return;
                    
                default:
                    vista.mostrarMensajeCombate("Opcion no valida.");
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void mostrarEstadoJugador() {
        vista.mostrarEstadoCombate(modelo.getJugador(), null);
        vista.mostrarInventarioJugador(modelo.getJugador());
        vista.mostrarArmaEquipada(modelo.getJugador());
    }

    public void equiparArma() {
        vista.mostrarInventarioJugador(modelo.getJugador());
        String nombreArma = vista.solicitarNombreArma();
        
        if (modelo.getJugador().equiparArma(nombreArma)) {
            vista.mostrarMensajeCombate("Arma equipada: " + nombreArma);
        } else {
            vista.mostrarMensajeCombate("No se pudo equipar el arma.");
        }
    }
}