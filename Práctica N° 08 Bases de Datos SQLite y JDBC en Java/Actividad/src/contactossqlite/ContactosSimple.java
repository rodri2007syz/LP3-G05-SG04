package contactossqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ContactosSimple {
    
    public static void main(String[] args) {
        new ContactosSimple().iniciar();
    }
    
    public void iniciar() {
        Connection con = null;
        try {

            con = DriverManager.getConnection("jdbc:sqlite:contactos.db");
            System.out.println("Conectado a SQLite");
            
            //  id, nombre, telefono
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT)");
            System.out.println("Tabla lista con 3 campos");
            stmt.close();
            
            Scanner scanner = new Scanner(System.in);
            int opcion;
            
            do {
                System.out.println("\n1. Insertar contacto");
                System.out.println("2. Ver contactos");
                System.out.println("3. Actualizar contacto");
                System.out.println("4. Eliminar contacto");
                System.out.println("5. Salir");
                System.out.print("Opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion) {
                    case 1:
                        insertarContacto(con, scanner);
                        break;
                    case 2:
                        verContactos(con);
                        break;
                    case 3:
                        actualizarContacto(con, scanner);
                        break;
                    case 4:
                        eliminarContacto(con, scanner);
                        break;
                    case 5:
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
                
            } while(opcion != 5);
            
            scanner.close();
            
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar conexion: " + e.getMessage());
                }
            }
        }
    }
    
    private void insertarContacto(Connection con, Scanner scanner) {
        PreparedStatement pstmt = null;
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Telefono: ");
            String telefono = scanner.nextLine();
            
            pstmt = con.prepareStatement("INSERT INTO contactos (nombre, telefono) VALUES (?, ?)");
            pstmt.setString(1, nombre);
            pstmt.setString(2, telefono);
            pstmt.executeUpdate();
            System.out.println("Contacto guardado");
            
        } catch(Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar statement: " + e.getMessage());
                }
            }
        }
    }
    
    private void verContactos(Connection con) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM contactos");
            
            System.out.println("\n--- CONTACTOS ---");
            boolean hayContactos = false;
            while(rs.next()) {
                hayContactos = true;
                System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre") + " | Tel: " + rs.getString("telefono"));
            }
            
            if(!hayContactos) {
                System.out.println("No hay contactos");
            }
            
        } catch(Exception e) {
            System.out.println("Error al mostrar: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar resultset: " + e.getMessage());
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar statement: " + e.getMessage());
                }
            }
        }
    }
    
    private void actualizarContacto(Connection con, Scanner scanner) {
        PreparedStatement pstmt = null;
        try {
            System.out.print("ID del contacto a actualizar: ");
            int idActualizar = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo telefono: ");
            String nuevoTelefono = scanner.nextLine();
            
            pstmt = con.prepareStatement("UPDATE contactos SET nombre=?, telefono=? WHERE id=?");
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoTelefono);
            pstmt.setInt(3, idActualizar);
            
            int filas = pstmt.executeUpdate();
            if(filas > 0) {
                System.out.println("Contacto actualizado");
            } else {
                System.out.println("No se encontro el contacto");
            }
            
        } catch(Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar statement: " + e.getMessage());
                }
            }
        }
    }
    
    private void eliminarContacto(Connection con, Scanner scanner) {
        PreparedStatement pstmt = null;
        try {
            System.out.print("ID del contacto a eliminar: ");
            int idEliminar = scanner.nextInt();
            
            pstmt = con.prepareStatement("DELETE FROM contactos WHERE id=?");
            pstmt.setInt(1, idEliminar);
            
            int filas = pstmt.executeUpdate();
            if(filas > 0) {
                System.out.println("Contacto eliminado");
            } else {
                System.out.println("No se encontro el contacto");
            }
            
        } catch(Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar statement: " + e.getMessage());
                }
            }
        }
    }
}