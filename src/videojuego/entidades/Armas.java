/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.entidades;

/**
 *
 * @author ingri
 */
public class Armas {
     private String nombre;
    private String tipo;
    private int danioMinimo;
    private int danioMaximo;
    private String modificadores;
public Armas(String nombre, String tipo, int danioMinimo, int danioMaximo, String modificadores) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.danioMinimo = danioMinimo;
        this.danioMaximo = danioMaximo;
        this.modificadores = modificadores;
    }
// Getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getDanioMinimo() { return danioMinimo; }
    public int getDanioMaximo() { return danioMaximo; }
    public String getModificadores() { return modificadores; }
}

