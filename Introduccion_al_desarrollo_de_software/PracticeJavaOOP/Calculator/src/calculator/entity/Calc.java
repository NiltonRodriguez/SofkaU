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
public class Calc {

    private int option;
    Scanner newScan = new Scanner(System.in);
    
    public Calc() {
    }
    
    public void run(){
        System.out.println("""
                           Bienvenido a la Calculadora.
                           1. Sumar
                           2. Restar.
                           3. Multiplicar.
                           4. Dividir.
                           """);
        System.out.print("Por favor elija una operación: ");
        option = newScan.nextInt();
        switch(option){
            case 1:
                Addition suma = new Addition();
                suma.execution();
                break;
            case 2:
                Substraction resta = new Substraction();
                resta.execution();
                break;
            case 3:
                Multiplication mult = new Multiplication();
                mult.execution();
                break;
            case 4:
                Division div = new Division();
                div.execution();
                break;
            default:
                System.out.println("La opción no es valida.");
        }
    }
}
