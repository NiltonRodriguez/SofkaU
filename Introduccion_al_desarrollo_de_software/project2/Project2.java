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
public class Project2 {

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
        int sum = 0;
        
        while(number > 0){
            // Add the last digit of the number to sum.
            sum += number % 10;
            // Remove the last digit of the number.
            number /= 10;
        }
        
        return sum;
    }
    
    public static int invertDigits(int number){
        int inverted = 0, last = 0;
        
        while (number > 0){
            // Find the last digit of the number.
            last = number % 10;
            // Append the last digit to the new inverted number.
            inverted = (inverted * 10) + last;
            // Remove the last digit from number.
            number /= 10;
        }
        
        return inverted;
    }
}
