/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<String, List> numbers = separateEvenOdd();
        
        System.out.println("Los numero impares del 1 al 100 son: " + 
                numbers.get("Odd"));
        
        System.out.println("Los números pares del 1 al 100 son: " + 
                numbers.get("Even"));
    }
    
    public static Map<String, List> separateEvenOdd(){
        
        Map<String, List> numbers = new HashMap<>();
        numbers.put("Even", new ArrayList<Integer>());
        numbers.put("Odd", new ArrayList<Integer>());
        
        int number = 1;
        
        while(number <= 100){
            if (number % 2 == 0){ numbers.get("Even").add(number); }
            else{ numbers.get("Odd").add(number); }
            number ++;
        }
        
        return numbers;
    }
}
