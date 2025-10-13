package E1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class GestorPersonajes {
    private final List<Personaje> personajes;
    private static final String NOMBRE_ARCHIVO = "personajes.txt";

    public GestorPersonajes() {
        this.personajes = new ArrayList<>();
        cargarPersonajes(); // Cargar personajes al inicializar
    }

    /**
     * Carga los personajes desde el archivo de texto.
     */
    private void cargarPersonajes() {
        personajes.clear(); // Limpia la lista actual antes de cargar
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("Archivo de personajes no encontrado. Iniciando gestor con lista vacía.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // El archivo usa el formato: Nombre,Vida,Ataque,Defensa,Alcance
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

    /**
     * Guarda el estado actual de la lista de personajes en el archivo (sobrescribiendo).
     * Se ejecuta automáticamente tras cada modificación.
     */
    private void guardarCambios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO, false))) { // 'false' para sobrescribir
            for (Personaje p : personajes) {
                pw.println(p.toFileString());
            }
            // System.out.println("💾 Cambios guardados automáticamente.");
        } catch (IOException e) {
            System.err.println("Error de escritura al guardar cambios: " + e.getMessage());
        }
    }

    // --- Métodos de gestión de personajes ---

    /**
     * Busca y devuelve un personaje por su nombre.
     */
    public Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // Personaje no encontrado
    }

    /**
     * Añade un nuevo personaje a la lista y guarda los cambios.
     */
    public boolean añadirPersonaje(Personaje nuevo) {
        if (buscarPersonaje(nuevo.getNombre()) != null) {
            System.out.println("❌ Error: El personaje con nombre '" + nuevo.getNombre() + "' ya existe.");
            return false;
        }
        personajes.add(nuevo);
        guardarCambios(); // GUARDADO AUTOMÁTICO
        System.out.println("✅ Personaje '" + nuevo.getNombre() + "' añadido exitosamente.");
        return true;
    }

    /**
     * Muestra todos los personajes almacenados.
     */
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
}