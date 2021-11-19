/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise10;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        
        System.out.println("Ingrese una frase:");
        String phrase = newScan.nextLine();
        
        delSpaces(phrase);
    }
    
    public static void delSpaces(String phrase){
        
        System.out.println("La fase sin espacios es:");
        System.out.println(phrase.replaceAll("\\s+", ""));
    }
}
