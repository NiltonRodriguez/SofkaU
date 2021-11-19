/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        System.out.print("Ingrese la primera palabra: ");
        String word1 = newScan.next();
        
        System.out.print("Ingrese la segunda palabra: ");
        String word2 = newScan.next();
        
        compareWords(word1, word2);
    }
    
    public static void compareWords(String word1, String word2){
        
        List<String> charsWord1 = new ArrayList<>();
        int word1Length = word1.length();
        int word2Length = word2.length();
        
        if (word1.equals(word2)){
            System.out.println("Las palabras son iguales.");
        } else if(word1Length < word2Length){
            System.out.println("La primera palabra es más corta.");
        } else if(word1Length > word2Length){
            System.out.println("La primera palabra es más larga.");
        } else{
            for (int i = 0; i < word1Length; i++){
                String letra1 = Character.toString(word1.charAt(i));
                if (!word2.contains(letra1)){
                    charsWord1.add(letra1);
                }
            }
            System.out.println("La primera palabra contiene la(s) letra(s): " + 
                    charsWord1 + " y la segunda no.");
        }
        
        
    }
}
