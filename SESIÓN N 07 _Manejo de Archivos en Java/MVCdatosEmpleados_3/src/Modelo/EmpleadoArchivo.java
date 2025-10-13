package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoArchivo {

    private static final String NOMBRE_ARCHIVO = "datos\\empleados.txt";

    private static final String DELIMITADOR = ","; 

    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            return empleados;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(DELIMITADOR);

                if (partes.length == 3) {
                    try {
                        int numero = Integer.parseInt(partes[0].trim());
                        String nombre = partes[1].trim();
                        double sueldo = Double.parseDouble(partes[2].trim());
                        
                        empleados.add(new Empleado(numero, nombre, sueldo));
                    } catch (NumberFormatException e) {
                        System.err.println("Errordatos corruptos " + linea);
                    }
                }
            }
        } catch (FileNotFoundException e) {

            System.err.println("Archivo no encontrado");
        } catch (IOException e) {
            System.err.println("Error de lectura " + e.getMessage());
        }
        return empleados;
    }

    private void guardarTodos(List<Empleado> empleados) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            for (Empleado e : empleados) {
                String linea = e.getNumero() + DELIMITADOR + 
                               e.getNombre() + DELIMITADOR + 
                               e.getSueldo();
                bw.write(linea);
                bw.newLine();
            }
        }
    }


    public void agregarEmpleado(Empleado nuevoEmpleado) throws IOException, IllegalArgumentException {
        List<Empleado> empleados = leerEmpleados();
        
        for (Empleado e : empleados) {
            if (e.getNumero() == nuevoEmpleado.getNumero()) {
                throw new IllegalArgumentException("El numero de empleado ya existe: " + nuevoEmpleado.getNumero());
            }
        }
        
        empleados.add(nuevoEmpleado);
        guardarTodos(empleados);
    }

    public Empleado buscarEmpleado(int numero) {
        return leerEmpleados().stream()
                .filter(e -> e.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarEmpleado(int numero) throws IOException {
        List<Empleado> empleados = leerEmpleados();
        
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);
        
        if (eliminado) {
            guardarTodos(empleados);
        }
        return eliminado;
    }
}