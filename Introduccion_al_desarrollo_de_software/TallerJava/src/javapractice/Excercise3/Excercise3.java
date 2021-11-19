/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise3;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final double PI = 3.1416;
        Scanner newScan = new Scanner(System.in);
        
        System.out.print("Ingrese un radio del circulo: ");
        double radio = newScan.nextInt();
        
        System.out.println("El área del círculo es " + circleArea(PI, radio));
    }
    
    public static double circleArea(double Pi, double radio){
        return Pi * (Math.pow(radio, 2));
    }
}
