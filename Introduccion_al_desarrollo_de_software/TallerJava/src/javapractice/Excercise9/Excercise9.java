/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise9;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String phrase = "La sonrisa sera la mejor arma contra la tristeza";
        String newPhrase = replaceLetter(phrase, "a", "e");
        
        addPhrase(newPhrase);
    }
    
    public static String replaceLetter(String phrase, String toReplase, String
            replaceWith){
        return phrase.replaceAll(toReplase, replaceWith);
    }
    
    public static void addPhrase (String phrase){
        
        Scanner newScan = new Scanner(System.in);
        System.out.println("¿Qué frase desea agregar?");
        String userPhrase = newScan.nextLine();
        
        System.out.println(phrase + " " + userPhrase);
    }
}
