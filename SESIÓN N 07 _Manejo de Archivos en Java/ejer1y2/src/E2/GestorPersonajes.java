package E2; 

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import java.util.Comparator; 

public class GestorPersonajes {
    private final List<Personaje> personajes;
    private static final String NOMBRE_ARCHIVO = "personajes.txt";

    public GestorPersonajes() {
        this.personajes = new ArrayList<>();
        cargarPersonajes();
    }

    
    private void cargarPersonajes() {
        personajes.clear(); 
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("Archivo de personajes no encontrado. Iniciando gestor con lista vacía.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
 
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    try {
                        String nombre = datos[0].trim();
                        int vida = Integer.parseInt(datos[1].trim());
                        int ataque = Integer.parseInt(datos[2].trim());
                        int defensa = Integer.parseInt(datos[3].trim());
                        int alcance = Integer.parseInt(datos[4].trim());
                        
                        personajes.add(new Personaje(nombre, vida, ataque, defensa, alcance));
                    } catch (NumberFormatException e) {
                       
                        System.err.println("Error al parsear línea (Dato no numérico): " + linea + ". Detalle: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                       
                        System.err.println("Error al parsear línea (Valor inválido): " + linea + ". Detalle: " + e.getMessage());
                    }
                }
            }
            System.out.println("✅ " + personajes.size() + " personajes cargados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error de lectura al cargar personajes: " + e.getMessage());
        }
    }

   
    private void guardarCambios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO, false))) { 
            for (Personaje p : personajes) {
                pw.println(p.toFileString());
            }
            
        } catch (IOException e) {
            System.err.println("Error de escritura al guardar cambios: " + e.getMessage());
        }
    }

    
    public Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; 
    }

    
    public boolean añadirPersonaje(Personaje nuevo) {
        if (buscarPersonaje(nuevo.getNombre()) != null) {
            System.out.println("❌ Error: El personaje con nombre '" + nuevo.getNombre() + "' ya existe.");
            return false;
        }
        personajes.add(nuevo);
        guardarCambios(); 
        System.out.println("✅ Personaje '" + nuevo.getNombre() + "' añadido exitosamente.");
        return true;
    }

   
    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("Lista de personajes vacía.");
            return;
        }
        System.out.println("\n--- LISTA DE PERSONAJES (" + personajes.size() + ") ---");
        for (Personaje p : personajes) {
            System.out.println(p);
        }
        System.out.println("------------------------------------");
    }

    /**
     * Modifica los atributos de un personaje existente y guarda los cambios.
     */
    public boolean modificarPersonaje(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        Personaje p = buscarPersonaje(nombre);
        if (p == null) {
            System.out.println("❌ Error: Personaje '" + nombre + "' no encontrado para modificar.");
            return false;
        }

        try {
            p.setVida(nuevaVida);
            p.setAtaque(nuevoAtaque);
            p.setDefensa(nuevaDefensa);
            p.setAlcance(nuevoAlcance);
            guardarCambios(); // GUARDADO AUTOMÁTICO
            System.out.println("✅ Personaje '" + nombre + "' modificado exitosamente.");
            System.out.println("Nuevo Estado: " + p);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error al modificar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Borra un personaje de la lista y guarda los cambios.
     */
    public boolean borrarPersonaje(String nombre) {
        Personaje p = buscarPersonaje(nombre);
        if (p == null) {
            System.out.println("❌ Error: Personaje '" + nombre + "' no encontrado para borrar.");
            return false;
        }

        boolean removido = personajes.remove(p);
        if (removido) {
            guardarCambios(); // GUARDADO AUTOMÁTICO
            System.out.println("✅ Personaje '" + nombre + "' borrado exitosamente.");
        }
        return removido;
    }
    
    
    public void mostrarEstadisticas() {
        int totalPersonajes = personajes.size();
        if (totalPersonajes == 0) {
            System.out.println("No hay personajes para calcular estadísticas.");
            return;
        }

        double totalVida = 0;
        double totalAtaque = 0;
        double totalDefensa = 0;
        double totalAlcance = 0;

        for (Personaje p : personajes) {
            totalVida += p.getVida();
            totalAtaque += p.getAtaque();
            totalDefensa += p.getDefensa();
            totalAlcance += p.getAlcance();
        }

        System.out.println("\n--- ESTADÍSTICAS GENERALES ---");
        System.out.println("Total de Personajes: " + totalPersonajes);
        System.out.printf("Promedio de Vida: %.2f\n", totalVida / totalPersonajes);
        System.out.printf("Promedio de Ataque: %.2f\n", totalAtaque / totalPersonajes);
        System.out.printf("Promedio de Defensa: %.2f\n", totalDefensa / totalPersonajes);
        System.out.printf("Promedio de Alcance: %.2f\n", totalAlcance / totalPersonajes);
        System.out.println("------------------------------------");
    }

    /**
     * Muestra los personajes ordenados según un atributo y orden especificados.
     * (Funcionalidad: Filtrar Personajes por Atributos)
     */
    public void filtrarPersonajesPorAtributo(String atributo, String orden) {
        List<Personaje> listaOrdenada = new ArrayList<>(this.personajes);
        
        // Define el comparador basado en el atributo
        Comparator<Personaje> comparator;
        switch (atributo.toLowerCase()) {
            case "vida":
                comparator = Comparator.comparing(Personaje::getVida);
                break;
            case "ataque":
                comparator = Comparator.comparing(Personaje::getAtaque);
                break;
            case "defensa":
                comparator = Comparator.comparing(Personaje::getDefensa);
                break;
            case "alcance":
                comparator = Comparator.comparing(Personaje::getAlcance);
                break;
            default:
                System.out.println("❌ Atributo no válido. Use: vida, ataque, defensa o alcance.");
                return;
        }
        
        // Aplica el orden (Ascendente por defecto, Descendente si se especifica)
        if (orden.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }

        listaOrdenada.sort(comparator);

        System.out.println("\n--- LISTA ORDENADA POR " + atributo.toUpperCase() + " (" + orden.toUpperCase() + ") ---");
        for (Personaje p : listaOrdenada) {
            System.out.println(p);
        }
        System.out.println("------------------------------------");
    }

    /**
     * Permite actualizar un solo atributo del personaje.
     * (Funcionalidad: Actualizar Atributos Individuales)
     */
    public boolean actualizarAtributoIndividual(String nombre, String atributo, int nuevoValor) {
        Personaje p = buscarPersonaje(nombre);
        if (p == null) {
            System.out.println("❌ Error: Personaje '" + nombre + "' no encontrado.");
            return false;
        }

        try {
            switch (atributo.toLowerCase()) {
                case "vida":
                    p.setVida(nuevoValor);
                    break;
                case "ataque":
                    p.setAtaque(nuevoValor);
                    break;
                case "defensa":
                    p.setDefensa(nuevoValor);
                    break;
                case "alcance":
                    p.setAlcance(nuevoValor);
                    break;
                default:
                    System.out.println("❌ Atributo no válido. Use: vida, ataque, defensa o alcance.");
                    return false;
            }
            guardarCambios(); // GUARDADO AUTOMÁTICO
            System.out.println("✅ Atributo '" + atributo + "' de '" + nombre + "' actualizado a " + nuevoValor + ".");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
            return false;
        }
    }
} 