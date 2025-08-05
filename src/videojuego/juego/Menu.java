/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.juego;

import java.util.Scanner;
import videojuego.database.DatabaseManager;
import videojuego.entidades.Elfo;
import videojuego.entidades.Humano;
import videojuego.entidades.Personaje;
/**
 *
 * @author ingri
 */
public class Menu {
     private Scanner scanner;
    private DatabaseManager dbManager;

    public Menu(Scanner scanner, DatabaseManager dbManager) {
        this.scanner = scanner;
        this.dbManager = dbManager;
    }
     public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n=== VIDEOJUEGO DE BATALLA POR TURNOS ===");
            System.out.println("1. Nueva partida");
            System.out.println("2. Ver estadísticas");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    iniciarNuevaPartida();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
     }
      private void iniciarNuevaPartida() {
        System.out.println("\n=== CREACIÓN DE PERSONAJES ===");
        
        System.out.println("\nJugador 1:");
        Personaje jugador1 = crearPersonaje();
        
        System.out.println("\nJugador 2:");
        Personaje jugador2 = crearPersonaje();
        
        Combate combate = new Combate(jugador1, jugador2, dbManager);
        combate.iniciarCombate();
    }
      
    private Personaje crearPersonaje() {
        System.out.print("Ingresa el nombre del personaje: ");
        String nombre = scanner.nextLine();
        
        System.out.println("\nSelecciona una raza:");
        System.out.println("1. Humano (Armas de fuego)");
        System.out.println("2. Elfo (Magia)");
        System.out.println("3. Orco (Armas cuerpo a cuerpo)");
        System.out.println("4. Bestia (Híbrido)");
        System.out.print("Opción: ");
         int opcionRaza = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Personaje personaje = null;
        
        switch (opcionRaza) {
            case 1:
                personaje = new Humano(nombre);
                break;
            case 2:
                System.out.println("\nSelecciona tipo de magia:");
                System.out.println("1. Fuego (+10% daño)");
                System.out.println("2. Tierra (+2% daño, más aciertos)");
                System.out.println("3. Aire (daño básico)");
                System.out.println("4. Agua (sanación mejorada, +15 vida inicial)");
                System.out.print("Opción: ");
                int opcionMagia = scanner.nextInt();
                String tipoMagia = switch (opcionMagia) {
                    case 1 -> "Fuego";
                    case 2 -> "Tierra";
                    case 3 -> "Aire";
                    case 4 -> "Agua";
                    default -> "Aire";
                };
                 personaje = new Elfo(nombre, tipoMagia);
                break;
            case 3:
                personaje = new Orco(nombre);
                break;
            case 4:
                personaje = new Bestia(nombre);
                break;
            default:
                System.out.println("Opción inválida. Se asignará Humano por defecto.");
                personaje = new Humano(nombre);
        }
        
        personaje.seleccionarArma(scanner);
        Systemda.out.println("\nPersonaje creado: " + personaje.getNombre() + 
                         " (" + personaje.getRaza() + ")");
        System.out.println("Habilidad especial: " + personaje.getDescripcionHabilidad());
        
        return personaje;
    }
 private void mostrarEstadisticas() {
        // Implementar consulta a la base de datos
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("(Esta funcionalidad se implementará en la versión final)");
    }
}

