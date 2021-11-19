/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise2;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        
        System.out.print("Ingrese un número: ");
        int number1 = newScan.nextInt();
        System.out.print("Ingrese otro número: ");
        int number2 = newScan.nextInt();
        
        compareNumbers(number1, number2);
        
    }
    
    public static void compareNumbers(int number1, int number2){
            
        if (number1 > number2){
            System.out.println(number1 + " es mayor que " + number2);
        } else if (number1 < number2){
            System.out.println(number1 + " es menor que " + number2);
        }else{
            System.out.println("Los números son iguales.");
        }
    }
}
