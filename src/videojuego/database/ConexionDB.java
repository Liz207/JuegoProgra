/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 *
 * @author ingri
 */
public class ConexionDB {
     private static Connection conexion = null;
    
    public static Connection getConnection() {
        if (conexion == null) {
            try {
                Properties props = new Properties();
                props.load(ConexionDB.class.getResourceAsStream("/config.properties"));
                
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");
                
                conexion = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }
}

