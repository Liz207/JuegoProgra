/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego;
import videojuego.database.DatabaseManager;
import videojuego.entidades.*;
import videojuego.juego.Menu;
import java.util.Scanner;
/**
 *
 * @author ingri
 */
public class Main {
     public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        Menu menu = new Menu(new Scanner(System.in), dbManager);
        menu.mostrarMenuPrincipal();
    }
}

