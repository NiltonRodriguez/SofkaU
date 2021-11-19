/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise4;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final double IVA = 1.21;
        Scanner newScan = new Scanner(System.in);
        
        System.out.print("Ingrese el precio: ");
        double precio = newScan.nextInt();
        
        System.out.println("El precio con 21% de IVA es: " + calcIva(IVA, precio));
    }
    
    public static double calcIva(double iva, double price){
        return iva * price;
    }
}
