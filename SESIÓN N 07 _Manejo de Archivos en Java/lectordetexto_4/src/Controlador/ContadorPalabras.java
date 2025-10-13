package Controlador;
import java.io.File;
import java.io.IOException;
import Vista.*;
import Modelo.*;
public class ContadorPalabras {

    private ContadorPalabrasmodelo modelo;
    private ContadorPalabrasVista vista;

    public ContadorPalabras(ContadorPalabrasmodelo modelo, ContadorPalabrasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean archivoValido = false;
        
        while (!archivoValido) {
            File archivo = vista.seleccionarArchivo();
            
            if (archivo == null) {
                System.out.println("Analisis cancelado");
                break; 
            }
            
            try {
                if (!archivo.exists() || archivo.isDirectory()) {
                     vista.mostrarMensajeError("El archivo seleccionado no existe intente de nuevo.");
                     continue; 
                }
                
                modelo.analizarArchivo(archivo);
                vista.mostrarResultados(modelo, archivo);
                archivoValido = true; 
                
            } catch (IOException e) {
                vista.mostrarMensajeError("Error de lectura " + e.getMessage() + ". Intente con otro archivo.");
            }
        }
    }
    
    public static void main(String[] args) {
        ContadorPalabrasmodelo modelo = new ContadorPalabrasmodelo();
        ContadorPalabrasVista vista = new ContadorPalabrasVista();
        ContadorPalabras controlador = new ContadorPalabras(modelo, vista);
        
        controlador.iniciar();
    }
}