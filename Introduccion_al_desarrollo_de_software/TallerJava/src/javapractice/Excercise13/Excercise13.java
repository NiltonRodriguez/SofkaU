/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("La fecha y hora actual es: " + formater.format(
                            LocalDateTime.now()));
        
    }
    
}
