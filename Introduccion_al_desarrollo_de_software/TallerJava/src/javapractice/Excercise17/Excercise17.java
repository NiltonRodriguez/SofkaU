/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise17;

import javapractice.Excercise17.entity.Electrodomestico;
import javapractice.Excercise17.entity.Lavadora;
import javapractice.Excercise17.entity.Televisor;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Electrodomestico[] electrodomesticos = {
            new Electrodomestico(),
            new Lavadora(),
            new Televisor(),
            new Electrodomestico(300, 30),
            new Lavadora(200, 50),
            new Televisor(150, 10),
            new Electrodomestico(50, "Gris", 'A', 2),
            new Lavadora(550, "Rojo", 'C', 45, 33),
            new Televisor(200, "Negro", 'B', 20, 50, true),
            new Electrodomestico(600, "Azul", 'E', 80)
        };
        
        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisores = 0;
        
        for (Electrodomestico electrodomestico: electrodomesticos){
            
            double precio = electrodomestico.precioFinal();
            totalElectrodomesticos += precio;
            
            if (electrodomestico instanceof Televisor){
                totalTelevisores += precio;
            } else if (electrodomestico instanceof Lavadora){
                totalLavadoras += precio;
            }
        }
        
        System.out.println("El precio total de los electrodomésticos es: " + 
                totalElectrodomesticos);
        System.out.println("El precio total de las lavadoras es: " +
                totalLavadoras);
        System.out.println("El precio total de los televisores es: " +
                totalTelevisores);
    }
    
}
