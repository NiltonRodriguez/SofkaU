/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author niltonrodriguez
 */
public class Second {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int number = 1234;
        int sum = sumDigits(number);
        int inverted = invertDigits(number);
        
        System.out.println("La suma de los digitos " + number + " es: " + sum);
        System.out.println(number + " invertido es: " + inverted);
    }
    
    public static int sumDigits(int number){
        // Treat the number as a string.
        String toSum = String.valueOf(number);
        int sum = 0;
        
        // Iterate on each char of the string.
        for(char c: toSum.toCharArray()){
            int digit = Integer.valueOf(String.valueOf(c));
            // Add each digit to sum.
            sum += digit;
        }
        
        return sum;
    }
    
    public static int invertDigits(int number){
        // Treat the number as a string.
        String toInvert = String.valueOf(number), invert = "";
        int inverted;
        
        // Iterate on each character of the string.
        for(char c: toInvert.toCharArray()){
            // Insert each character at the beggining of the string.
            invert = c + invert;
        }
        
        inverted = Integer.valueOf(invert);
        
        return inverted;
    }
}
