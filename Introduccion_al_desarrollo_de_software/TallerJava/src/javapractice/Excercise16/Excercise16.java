/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise16;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner newScan = new Scanner(System.in);
        
        System.out.print("Igrese el Nombre: ");
        String name = newScan.next();
        System.out.print("Ingrese la Edad: ");
        int age = newScan.nextInt();
        System.out.print("Ingrese el sexo (H/M): ");
        char genre = newScan.next().charAt(0);
        System.out.print("Ingrese el peso en kilogramos: ");
        double weight = newScan.nextDouble();
        System.out.print("Ingrese la altura en metros: ");
        double height = newScan.nextDouble();
        
        Persona persona1 = new Persona(name, age, genre, weight, height);
        Persona persona2 = new Persona(name, age, genre);
        Persona persona3 = new Persona();
        
        persona3.setName(name);
        persona3.setAge(age);
        persona3.setGenre(genre);
        persona3.setWeight(weight);
        persona3.setHeight(height);
        
        imcMessage(persona1);
        ageMessage(persona1);
        System.out.println(persona1.toString());
        
        imcMessage(persona2);
        ageMessage(persona2);
        System.out.println(persona2.toString());
        
        
        imcMessage(persona3);
        ageMessage(persona3);
        System.out.println(persona3.toString());
        
    }
    
    public static void imcMessage(Persona persona){
        if(persona.calculateImc() > 0){
            System.out.println("Lo sentimos, tienes sobrepeso.");
        } else if(persona.calculateImc() < 0){
            System.out.println("Tu peso està por debajo del recomendado.");
        } else{
            System.out.println("Estás en tu peso ideal.");
        }
    }
    
    public static void ageMessage(Persona persona){
        if(persona.isOverLegalAge()){
            System.out.println("Eres mayor de edad!");
        }else{
            System.out.println("Aun no eres mayor de edad!");
        }
    }
}
