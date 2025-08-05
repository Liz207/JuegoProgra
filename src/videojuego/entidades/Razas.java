/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego.entidades;

/**
 *
 * @author ingri
 */
public enum Razas {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ORCO("Orco"),
    BESTIA("Bestia");
    
    private final String nombre;
    
    // Constructor del enum (privado por defecto)
    Razas(String nombre) {
        this.nombre = nombre;
    }
    
    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }
}