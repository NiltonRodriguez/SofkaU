/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.entity;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Operation {
    private double number1, number2;
    static double result;
    Scanner newScan = new Scanner(System.in);

    public Operation() {
    }
    
    public String operation(double number1, double number2){
        return "El resultado es:" + result;
    }
    
    public void execution(){
        try{
            System.out.print("Ingrese el primer número: ");
            number1 = newScan.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            number2 = newScan.nextDouble();
            System.out.println(operation(number1, number2));
        }catch (Exception e){
            System.out.println("El valor ingresado no es válido. Por favor " +
                    "ingrese un número.");
        }
    }
}
