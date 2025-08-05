/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.entidades;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ingri
 */
public class Orco extends Personaje{
    private int turnosSangrado = 0;
    private boolean haUsadoPocima = false;

    public Orco(String nombre) {
        super(nombre, Razas.ORCO, 100);
    }
    @Override
    public int atacar(Personaje objetivo) {
        Random rand = new Random();
        int danioBase = rand.nextInt(5) + 1; // 1-5 de daño
        
        if (arma != null && arma.getNombre().equals("Hacha")) {
            turnosSangrado = 2; // Aplicar sangrado por 2 turnos
        }
        
        objetivo.recibirDanio(danioBase);
        return danioBase;
    }
 @Override
    public int sanar() {
        if (!haUsadoPocima) {
            int curacion = (int)(vidaMaxima * 0.25); // 25% de curación
            curar(curacion);
            haUsadoPocima = true;
            return curacion;
        }
        return 0;
    }
 @Override
    public void seleccionarArma(Scanner scanner) {
        System.out.println("\nSelecciona un arma:");
        System.out.println("1. Hacha (provoca sangrado)");
        System.out.println("2. Martillo (daño consistente)");
        
        int opcion = scanner.nextInt();
        while (opcion < 1 || opcion > 2) {
            System.out.println("Opción inválida. Intenta nuevamente:");
            opcion = scanner.nextInt();
        }
        
        if (opcion == 1) {
            this.arma = new Armas("Hacha", "Cuerpo a cuerpo", 1, 5, "Provoca sangrado");
        } else {
            this.arma = new Armas("Martillo", "Cuerpo a cuerpo", 1, 5, "Daño consistente");
        }
    }
     @Override
    public String getDescripcionHabilidad() {
        return "Pócima: Cura 25% de vida máxima + 15% al siguiente turno (1 vez por combate)";
    }

    public int efectoContinua() {
        if (turnosSangrado > 0) {
            turnosSangrado--;
            return 3; // Sangrado causa 3 de daño por turno
        }
        return 0;
    }
}

