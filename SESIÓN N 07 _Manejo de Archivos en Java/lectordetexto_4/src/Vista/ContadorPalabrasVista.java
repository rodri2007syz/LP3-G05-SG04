package Vista;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Map;
import Modelo.*;
public class ContadorPalabrasVista {

    public File seleccionarArchivo() {
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione un archivo de texto para analizar");
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return selector.getSelectedFile(); 
        }
        return null;
    }

    public void mostrarResultados(ContadorPalabrasmodelo modelo, File archivo) {
        System.out.println("\n--- Resultados del Analisis ---"); 
        System.out.println("Archivo: " + archivo.getName());
        System.out.println("--------------------------------");
        
        System.out.println("Total de lineas: " + modelo.getTotalLineas());
        System.out.println("Total de palabras: " + modelo.getTotalPalabras());
        System.out.println("Total de caracteres " + modelo.getTotalCaracteres());
        System.out.printf("Promedio de palabras por linea", modelo.getPromedioPalabrasPorLinea());
        
        System.out.println("\n--- Palabras mas frecuentes (repeticiones) ---");
        Map<String, Integer> frecuentes = modelo.getPalabrasMasFrecuentes();
        if (frecuentes.isEmpty()) {
            System.out.println("No se encontraron palabras que se repitan.");
        } else {
            frecuentes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
                .forEach(entry -> System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " veces"));
        }
        System.out.println("--------------------------------");
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error de Lectura", JOptionPane.ERROR_MESSAGE);
    }
}