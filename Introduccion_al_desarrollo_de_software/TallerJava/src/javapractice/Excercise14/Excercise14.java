/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise14;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        
        System.out.println("Por favor ingrese un número para empzar a contar: ");
        int number = newScan.nextInt();
        
        while (number <= 1000){
            System.out.println(number);
            number += 2;
        }
    }
    
}
