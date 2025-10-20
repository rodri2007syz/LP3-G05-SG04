package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTransaccionesCRUD {

    // URL de conexión a la base de datos: crea el archivo 'productos.db'
    private static final String URL = "jdbc:sqlite:productos.db";

    /**
     * Establece la conexion con la base de datos.
     * @return Objeto Connection.
     */
    private Connection connect() {
        Connection conn = null;
        try {

            Class.forName("org.sqlite.JDBC"); 
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexión a SQLite establecida.");
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
             System.err.println("Error: Driver JDBC no encontrado. Asegúrese de incluir la librería sqlite-jdbc.");
        }
        return conn;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS PRODUCTOS ("
                   + "ID INTEGER PRIMARY KEY,"
                   + "NOMBRE TEXT NOT NULL,"
                   + "PRECIO REAL NOT NULL"
                   + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla PRODUCTOS creada o ya existe.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void insert(String nombre, double precio) {
        String sql = "INSERT INTO PRODUCTOS(NOMBRE, PRECIO) VALUES(?, ?)";
        Connection conn = null;

        try {
            conn = connect();
            
           
            conn.setAutoCommit(false); 
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
                pstmt.setString(1, nombre);
                pstmt.setDouble(2, precio);
                pstmt.executeUpdate();                 

                conn.commit(); 
                System.out.println("Producto '" + nombre + "' insertado con éxito (Commit).");
            } catch (SQLException e) {

                if (conn != null) {
                    conn.rollback(); 
                    System.err.println("Transacción de inserción fallida para '" + nombre + "'. Ejecutando Rollback.");
                }
                throw e; 
            }

        } catch (SQLException e) {
            System.err.println("Error en la transacción de inserción: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); 
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public void update(int id, double nuevoPrecio) {
        String sql = "UPDATE PRODUCTOS SET PRECIO = ? WHERE ID = ?";
        Connection conn = null;

        try {
            conn = connect();
            
  
            conn.setAutoCommit(false); 

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                pstmt.setDouble(1, nuevoPrecio);
                pstmt.setInt(2, id);
                int filasAfectadas = pstmt.executeUpdate();
                
                if (filasAfectadas > 0) {

                    conn.commit(); 
                    System.out.println("Producto con ID " + id + " actualizado con éxito (Commit). Filas afectadas: " + filasAfectadas);
                } else {
                    conn.rollback();
                    System.out.println("No se encontró el producto con ID " + id + ". Ejecutando Rollback.");
                }
                
            } catch (SQLException e) {

                if (conn != null) {
                    conn.rollback(); 
                    System.err.println("Transacción de actualización fallida para ID " + id + ". Ejecutando Rollback.");
                }
                throw e;
            }
        } catch (SQLException e) {
            System.err.println("Error en la transacción de actualización: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
    
     public void delete(int id) {
        String sql = "DELETE FROM PRODUCTOS WHERE ID = ?";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
 
            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                 System.out.println("Producto con ID " + id + " borrado con éxito.");
            } else {
                 System.out.println("No se encontró el producto con ID " + id + " para borrar.");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al borrar el producto: " + e.getMessage());
        }
    }

    public void selectAll() {
        String sql = "SELECT ID, NOMBRE, PRECIO FROM PRODUCTOS";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){ // executeQuery() se usa para SELECT
            
            System.out.println("\n--- Lista de Productos ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + "\t" + 
                                   "Nombre: " + rs.getString("NOMBRE") + "\t" +
                                   "Precio: S/ " + rs.getDouble("PRECIO"));
            }
            System.out.println("--------------------------");
            
        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SQLiteTransaccionesCRUD app = new SQLiteTransaccionesCRUD();
        

        app.createTable();

       
        System.out.println("\n--- Ejecutando Inserciones (Transacciones) ---");
        app.insert("Laptop", 3500.00); 
        app.insert("Mouse", 50.00); 
        
    
        app.selectAll();

      
        System.out.println("\n--- Ejecutando Actualización (Transacciones) ---");
        app.update(1, 4000.00); 
        app.update(99, 10.00); 
        
        app.selectAll();
        
        System.out.println("\n--- Ejecutando Eliminación ---");
        app.delete(2); 

        app.selectAll();
    }
}