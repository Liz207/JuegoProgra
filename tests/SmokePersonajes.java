import videojuego.entidades.*;
import java.util.Scanner;

public class SmokePersonajes {
    public static void main(String[] args) {
        Bestia bestia = new Bestia("Bestia");
        Humano humano = new Humano("Humano");
        bestia.seleccionarArma(new Scanner("1\n"));
        int dano = bestia.atacar(humano);
        if (dano != 25 || humano.getVida() != 75 || bestia.getVida() != 90) throw new AssertionError("ataque de puños");
        bestia.sanar();
        if (bestia.getVida() != 100 || bestia.sanar() != 0) throw new AssertionError("sanar una vez");
        if (bestia.getRaza() != Razas.BESTIA || humano.getRaza() != Razas.HUMANO) throw new AssertionError("razas");
        if (bestia.getDescripcionHabilidad().isEmpty()) throw new AssertionError("descripción");
        System.out.println("PASS: ataque, auto-daño, sanación y razas");
    }
}
