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
public class Elfo extends Personaje{
     private String tipoMagia;
    private boolean haSanado = false;

    public Elfo(String nombre, String tipoMagia) {
        super(nombre, Razas.ELFO, tipoMagia.equals("Agua") ? 115 : 100);
        this.tipoMagia = tipoMagia;
    }
      @Override
    public int atacar(Personaje objetivo) {
        Random rand = new Random();
        int danioBase = rand.nextInt(5) + 1;
        
        switch (tipoMagia) {
            case "Fuego":
                danioBase += (int)(danioBase * 0.10);
                break;
            case "Tierra":
                danioBase += (int)(danioBase * 0.02);
                if (rand.nextDouble() < 0.3) danioBase += rand.nextInt(3) + 1;
                break;
            case "Aire":
                // Sin modificador base
                break;
            case "Agua":
                // Sin modificador base
                break;
        }
        
        objetivo.recibirDanio(danioBase);
        return danioBase;
    }
 @Override
    public int sanar() {
        if (!haSanado) {
            int curacion = (int)((vidaMaxima - vida) * (tipoMagia.equals("Agua") ? 0.9 : 0.75));
            curar(curacion);
            haSanado = true;
            return curacion;
        }
        return 0;
    }

    public void seleccionarArmas(Scanner scanner) {
        this.arma = new Armas("Báculo de " + tipoMagia, "Magia", 1, 5, 
                            tipoMagia.equals("Fuego") ? "+10% de daño" : 
                            tipoMagia.equals("Tierra") ? "+2% de daño, más aciertos" : 
                            tipoMagia.equals("Agua") ? "Sanación mejorada" : "Daño básico");
    }
 @Override
    public String getDescripcionHabilidad() {
        return "Sanación: Recupera " + (tipoMagia.equals("Agua") ? "90%" : "75%") + " de la vida perdida (1 vez por combate)";
    }

    public void seleccionarArma(Object scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void seleccionarArma(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

