/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.entidades;
import java.util.Scanner;

/**
 *
 * @author Yader
 */
public abstract class Personaje {
    protected String nombre; 
    protected Razas raza;
    protected int vida;
    protected int vidaMaxima;
    protected Armas arma;
    protected boolean estaVivo = true;
    
    
    public Personaje (String nombre, Razas raza, int vida ){
        this.nombre = nombre;
        this.raza = raza;
        this.vida = vidaMaxima;
        this.vidaMaxima = vidaMaxima;
              
    }
    
    public abstract int atacar(Personaje objetivo);
    public abstract int sanar ();
    public abstract void seleccionarArma(Scanner scanner);
    public abstract String getDescripcionHabilidad();
     
    public void recibirDanio (int danio){
         vida -= danio;
        if  (vida <= 0){
        vida = 0;
        estaVivo = false;
     }
}
    

    public void curar (int cantidad){
        vida += cantidad;
        if(vida > vidaMaxima){
            vida = vidaMaxima;
        }
    }
    
    
    // Getters 
    public String getNombre() { return nombre; }
    public Razas getRazas() { return raza; }
    public int getVida() { return vida; }
    public int getvidaMaxima() { return vidaMaxima; }
    public Armas getArma() { return arma; }
    public boolean getestaVivo() { return estaVivo; }
    
    
    public enum Razas {
        HUMANO ("Humano"),
        
    }
    
    }
