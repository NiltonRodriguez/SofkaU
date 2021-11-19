/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise7;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int number = getPositiveNumber();
        
        if (number > 0){
            System.out.println("El numero positivo ingresado es: " + number);
        } else{
            System.out.println("Ingresó el número 0.");
        }
    }
    
    public static int getPositiveNumber(){
        Scanner newScan = new Scanner(System.in);
        int number = 0;
        
        System.out.print("Ingrese un número: ");
        do{
            try{
                number = newScan.nextInt();
                if (number < 0){ System.out.print("Ingrese otro número: "); }
            }catch (Exception e){
                System.out.println("Por favor ingrese un número.");
            }
        }while(number < 0);
        
        return number;
    }
}
