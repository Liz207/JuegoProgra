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
public class Humano extends Personaje{
     private boolean haComido = false;

    public Humano(String nombre) {
        super(nombre, Razas.Humano, 100);
    }
     @Override
    public int atacar(Personaje objetivo) {
        Random rand = new Random();
        int danioBase = rand.nextInt(5) + 1; // 1-5
        
        if (arma != null) {
            switch (arma.getNombre()) {
                case "Escopeta":
                    danioBase += (int)(danioBase * 0.02);
                    break;
                case "Rifle francotirador":
                    // Sin modificador base
                    break;
            }
        }
         objetivo.recibirDanio(danioBase);
        return danioBase;
    }

    @Override
    public int sanar() {
        if (!haComido) {
            int curacion = (int)((vidaMaxima - vida) * 0.5);
            curar(curacion);
            haComido = true;
            return curacion;
        }
        return 0;
    }
    public void seleccionarArma(Scanner scanner) {
        System.out.println("\nSelecciona un arma:");
        System.out.println("1. Escopeta (+2% de daño)");
        System.out.println("2. Rifle francotirador (daño consistente)");
        
        int opcion = scanner.nextInt();
        while (opcion < 1 || opcion > 2) {
            System.out.println("Opción inválida. Intenta nuevamente:");
            opcion = scanner.nextInt();
        }
        
        if (opcion == 1) {
            this.arma = new Armas("Escopeta", "Arma de fuego", 1, 5, "+2% de daño");
        } else {
            this.arma = new Armas("Rifle francotirador", "Arma de fuego", 1, 5, "Daño preciso");
        }
    }
    @Override
    public String getDescripcionHabilidad() {
        return "Comer: Recupera 50% de la vida perdida (1 vez por combate)";
    }

    public void seleccionarArma(Object scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

