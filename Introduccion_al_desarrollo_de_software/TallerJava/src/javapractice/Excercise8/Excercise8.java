/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise8;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        System.out.print("Ingrese un día para consultar si es laborable: ");
        String day = newScan.next();
        
        if(isWorkingDay(day)){ System.out.println(day + " es un día laborable"); }
        else{ System.out.println(day + " no es un día laborable"); }
    }
    
    public static boolean isWorkingDay(String day){
        
        boolean work = false;
        
        switch(day.toLowerCase()){
            case "lunes":
            case "martes":
            case "miercoles":
            case "jueves":
            case "viernes":
                work = true;
                break;
            case "sabado":
            case "domingo":
                break;
            default:
                System.out.println("No es un día válido.");
                break;
        }
        
        return work;
    }
}
