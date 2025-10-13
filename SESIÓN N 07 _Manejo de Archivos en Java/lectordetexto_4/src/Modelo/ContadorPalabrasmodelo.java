package Modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContadorPalabrasmodelo {

    private int totalLineas;
    private int totalPalabras;
    private int totalCaracteres;
    private double promedioPalabrasPorLinea;
    private Map<String, Integer> palabrasFrecuentes;

    public ContadorPalabrasmodelo() {
        this.palabrasFrecuentes = new HashMap<>();
        resetearContadores();
    }
    
    private void resetearContadores() {
        this.totalLineas = 0;
        this.totalPalabras = 0;
        this.totalCaracteres = 0;
        this.promedioPalabrasPorLinea = 0.0;
        this.palabrasFrecuentes.clear();
    }

    public void analizarArchivo(File archivo) throws IOException {
        resetearContadores();

        Pattern patronPalabra = Pattern.compile("[\\p{L}0-9]+");
        
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();
 
                String lineaLimpia = linea.toLowerCase();

                lineaLimpia = lineaLimpia.replaceAll("\\p{Punct}", " "); 
                
                Matcher matcher = patronPalabra.matcher(lineaLimpia);
                
                while (matcher.find()) {
                    totalPalabras++;
                    String palabra = matcher.group();

                    palabrasFrecuentes.put(palabra, palabrasFrecuentes.getOrDefault(palabra, 0) + 1);
                }
            }
        }
        
        if (totalLineas > 0) {
            promedioPalabrasPorLinea = (double) totalPalabras / totalLineas;
        }
    }

    public Map<String, Integer> getPalabrasMasFrecuentes() {
        Map<String, Integer> resultado = new HashMap<>();
        for (Map.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            if (entry.getValue() > 1) { 
                resultado.put(entry.getKey(), entry.getValue());
            }
        }
        return resultado;
    }


    public int getTotalLineas() { 
    	return totalLineas; 
    	}
    public int getTotalPalabras() { 
    	return totalPalabras; 
    	}
    public int getTotalCaracteres() { 
    	return totalCaracteres; 
    	}
    public double getPromedioPalabrasPorLinea() { 
    	return promedioPalabrasPorLinea; 
    	}
}