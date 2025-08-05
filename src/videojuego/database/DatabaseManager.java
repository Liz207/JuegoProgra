/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.database;

import java.sql.*;
import videojuego.entidades.Personaje;
/**
 *
 * @author ingri
 */
public class DatabaseManager {
     private Connection conexion;

    public DatabaseManager() {
        conexion = ConexionDB.getConnection();
    }
public void guardarPartida(Personaje ganador, Personaje perdedor) {
        try {
            // Registrar jugadores si no existen
            registrarJugador(ganador.getNombre());
            registrarJugador(perdedor.getNombre());
            
            // Actualizar estadísticas
            actualizarEstadisticas(ganador.getNombre(), true);
            actualizarEstadisticas(perdedor.getNombre(), false);
            
            // Registrar personajes
            registrarPersonaje(ganador);
            registrarPersonaje(perdedor);
            
        } catch (SQLException e) {
            System.err.println("Error al guardar partida: " + e.getMessage());
        }
    }
 private void registrarJugador(String nombre) throws SQLException {
        String query = "INSERT INTO jugador (nombre) VALUES (?) ON CONFLICT (nombre) DO NOTHING";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        }
    }
 private void actualizarEstadisticas(String nombre, boolean ganador) throws SQLException {
        String campo = ganador ? "partidas_ganadas" : "partidas_perdidas";
        String query = "UPDATE jugador SET " + campo + " = " + campo + " + 1 WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        }
    }
  private void registrarPersonaje(Personaje personaje) throws SQLException {
        String query = "INSERT INTO personaje (nombre, raza_id, vida_actual, id_arma) " +
                      "VALUES (?, (SELECT id FROM raza WHERE nombre = ?), ?, " +
                      "(SELECT id FROM arma WHERE nombre = ?))";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, personaje.getNombre());
            stmt.setString(2, personaje.getRaza().name());
            stmt.setInt(3, personaje.getVida());
            stmt.setString(4, personaje.getArma().getNombre());
            stmt.executeUpdate();
        }
    }
}

