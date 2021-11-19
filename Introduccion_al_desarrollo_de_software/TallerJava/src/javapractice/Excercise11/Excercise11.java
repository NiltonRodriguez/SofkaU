/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise11;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        System.out.println("Ingrese una frase:");
        String phrase = newScan.nextLine();
        
        Map<String, Integer> lenght = phraseLenght(phrase);
        lenght.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        
        Map<String, Integer> count = vowelCount(phrase);
        count.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
    
    public static Map<String, Integer> phraseLenght(String phrase){
        Map<String, Integer> count = new TreeMap<>();
        count.put("letras", 0);
        count.put("espacios", 0);
        count.put("longitud", 0);
        
        int noSpaceLenght = phrase.replaceAll("\\s+", "").length();
        int totalLenght = phrase.length();
        
        count.replace("letras", noSpaceLenght);
        count.replace("espacios", totalLenght - noSpaceLenght);
        count.replace("longitud", totalLenght);
        
        return count;
    }
    
    public static Map<String, Integer> vowelCount(String phrase){
        Map<String, Integer> count = new TreeMap<>();
        count.put("a", 0);
        count.put("e", 0);
        count.put("i", 0);
        count.put("o", 0);
        count.put("u", 0);
        
        int totalLenght = phrase.length();
        
        for(int i = 0; i < totalLenght; i++){
            switch(phrase.toLowerCase().charAt(i)){
                case 'a':
                    count.replace("a", count.get("a") + 1);
                    break;
                case 'e':
                    count.replace("e", count.get("e") + 1);
                    break;
                case 'i':
                    count.replace("i", count.get("i") + 1);
                    break;
                case 'o':
                    count.replace("o", count.get("o") + 1);
                    break;
                case 'u':
                    count.replace("u", count.get("u") + 1);
                    break;
            }
        }
        
        return count;
    }
}
