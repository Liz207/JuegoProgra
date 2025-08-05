/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.juego;

import java.util.Scanner;
import videojuego.database.DatabaseManager;
import videojuego.entidades.Personaje;
/**
 *
 * @author ingri
 */
public class Combate {
      private Personaje jugador1;
    private Personaje jugador2;
    private int turno = 1;
    private Scanner scanner;
    private DatabaseManager dbManager;

    public Combate(Personaje jugador1, Personaje jugador2, DatabaseManager dbManager) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.scanner = new Scanner(System.in);
        this.dbManager = dbManager;
    }
     public void iniciarCombate() {
        System.out.println("\n=== COMIENZA EL COMBATE ===");
        System.out.println(jugador1.getNombre() + " (" + jugador1.getRaza() + ") vs " + 
                         jugador2.getNombre() + " (" + jugador2.getRaza() + ")");
        
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            ejecutarTurno(jugador1, jugador2);
            if (!jugador2.estaVivo()) break;
            
            ejecutarTurno(jugador2, jugador1);
            turno++;
        }
        
        finalizarCombate();
    }
      private void ejecutarTurno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre() + " (" + atacante.getRaza() + ")");
        System.out.println("Vida: " + atacante.getVida() + "/" + atacante.getVidaMaxima());
        System.out.println("1. Atacar");
        System.out.println("2. Sanar");
        System.out.println("3. Ver información");
        System.out.print("Selecciona una acción: ");
        
        int accion = scanner.nextInt();
        
        switch (accion) {
            case 1:
                int danio = atacante.atacar(defensor);
                System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + 
                                 " causando " + danio + " de daño");
                break;
            case 2:
                int curacion = atacante.sanar();
                if (curacion > 0) {
                    System.out.println(atacante.getNombre() + " se cura " + curacion + " puntos de vida");
                     } else {
                    System.out.println(atacante.getNombre() + " ya ha usado su habilidad de sanación");
                }
                break;
            case 3:
                mostrarInformacion(atacante, defensor);
                ejecutarTurno(atacante, defensor); // Repetir turno
                return;
            default:
                System.out.println("Opción inválida. Pierdes tu turno.");
        }
        
        System.out.println("\nEstado después del turno:");
        System.out.println("- " + atacante.getNombre() + ": " + atacante.getVida() + "/" + atacante.getVidaMaxima());
        System.out.println("- " + defensor.getNombre() + ": " + defensor.getVida() + "/" + defensor.getVidaMaxima());
    }
 private void mostrarInformacion(Personaje atacante, Personaje defensor) {
        System.out.println("\n=== INFORMACIÓN ===");
        System.out.println("Tus datos:");
        System.out.println("- Nombre: " + atacante.getNombre());
        System.out.println("- Raza: " + atacante.getRaza());
        System.out.println("- Arma: " + atacante.getArma().getNombre());
        System.out.println("- Habilidad especial: " + atacante.getDescripcionHabilidad());
        
        System.out.println("\nDatos del oponente:");
        System.out.println("- Nombre: " + defensor.getNombre());
        System.out.println("- Raza: " + defensor.getRaza());
        System.out.println("- Arma: " + defensor.getArma().getNombre());
        System.out.println("- Vida: " + defensor.getVida() + "/" + defensor.getVidaMaxima());
    }
 private void finalizarCombate() {
        Personaje ganador = jugador1.estaVivo() ? jugador1 : jugador2;
        Personaje perdedor = jugador1.estaVivo() ? jugador2 : jugador1;
        
        System.out.println("\n=== FIN DEL COMBATE ===");
        System.out.println(ganador.getNombre() + " ha ganado el combate en " + turno + " turnos!");
        
        // Guardar en base de datos
        dbManager.guardarPartida(ganador, perdedor);
        
        System.out.println("\nPresiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }
}

