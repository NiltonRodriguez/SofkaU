/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create a new Scanner Instance for input.
        Scanner newScan = new Scanner(System.in);
        // Prompt the name of the user.
        System.out.print("Nombre de usuario: ");
        String user = newScan.nextLine();
        // Prompt the mobile number of the user.
        System.out.print("Celular: ");
        String phone = newScan.nextLine();
        // Promt the age of the user.
        System.out.print("Edad: ");
        String age = newScan.nextLine();
        
        // Display the welcome message.
        System.out.println("Bienvenido señor " + user + ", es un placer para " +
                "nosotros contar con una persona de " + age + " años.");
        System.out.println("Próximamente nos estaremos comunicando con usted " +
                "al número " + phone + ".");
        System.out.println("Feliz día");    
    }
    
}
