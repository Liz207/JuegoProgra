/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.entidades;

/**
 *
 * @author ingri
 */
public class Bestia extends Personaje{
    private boolean haDormido = false;

    public Bestia(String nombre) {
        super(nombre, Raza.BESTIA, 100);
    }

    @Override
    public int atacar(Personaje objetivo) {
        if (arma != null && arma.getNombre().equals("Puños")) {
            this.recibirDanio(10); // Pierde 10 de vida al atacar con puños
            objetivo.recibirDanio(25);
            return 25;
        } else {
            Random rand = new Random();
            int danioBase = rand.nextInt(10) + 1; // 1-10 de daño
            objetivo.recibirDanio(danioBase);
            return danioBase;
        }
    }
  @Override
    public int sanar() {
        if (!haDormido) {
            int curacion = (int)(vidaMaxima * 0.45); // 45% de curación
            curar(curacion);
            haDormido = true;
            return curacion;
        }
        return 0;
    }
     @Override
    public void seleccionarArma(Scanner scanner) {
        System.out.println("\nSelecciona un arma:");
        System.out.println("1. Puños (25 de daño fijo, pierdes 10 de vida)");
        System.out.println("2. Espada (1-10 de daño)");
        
        int opcion = scanner.nextInt();
        while (opcion < 1 || opcion > 2) {
            System.out.println("Opción inválida. Intenta nuevamente:");
            opcion = scanner.nextInt();
        }
        
        if (opcion == 1) {
            this.arma = new Arma("Puños", "Natural", 25, 25, "Atacante pierde 10 de vida");
        } else {
            this.arma = new Arma("Espada", "Cuerpo a cuerpo", 1, 10, "Daño variable alto");
        }
    }
}
