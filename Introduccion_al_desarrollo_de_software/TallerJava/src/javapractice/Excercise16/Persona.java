/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise16;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author niltonrodriguez
 */
public class Persona {
    
    /* Atritubtes */
    private String name;
    private int age;
    private String dni;
    private char genre;
    private double weight;
    private double height;
    
    /* Default Constructor */
    public Persona() {
        this.name = "";
        this.genre = 'H';
        this.dni = dniGenerator();
    }

    public Persona(String name, int age, char genra) {
        this.name = name;
        this.age = age;
        this.genre = genraComprobation(genra);
        this.dni = dniGenerator();
    }

    public Persona(String name, int age, char genra, double weigth, double height) {
        this.name = name;
        this.age = age;
        this.genre = genraComprobation(genra);
        this.weight = weigth;
        this.height = height;
        this.dni = dniGenerator();
    }
    
    public int calculateImc(){
        
        double imc = weight / (Math.pow(height, 2));
        
        final int LOW = -1;
        final int NORMAL = 0;
        final int HIGH = 1;
        
        if (imc < 20){
            return LOW;
        } else if(imc >= 20 && imc <= 25){
            return NORMAL;
        }
        return HIGH;
    }
    
    public boolean isOverLegalAge(){
        
        final int LEGALAGE = 18;
        
        return age >= LEGALAGE;
        
    }
    
    private char genraComprobation(char genra){
        
        if (genra == 'M'){
            return 'M';
        }
        
        return 'H';
        
    }
    
    private String dniGenerator(){
        
        String dni = "";
        
        for (int i = 0; i < 8; i++){
            dni += String.valueOf(Math.round((Math.random() * 10)));
        }
        
        int verificator = Integer.valueOf(dni) % 23;
        
        dni += dniLetter(verificator);
        
        return dni;
        
    }
    
    private String dniLetter(int verificator){
        
        Map <Integer, String> letterTable = new HashMap<>();
        
        letterTable.put(0, "T");
        letterTable.put(1, "R");
        letterTable.put(2, "W");
        letterTable.put(3, "A");
        letterTable.put(4, "G");
        letterTable.put(5, "M");
        letterTable.put(6, "Y");
        letterTable.put(7, "F");
        letterTable.put(8, "P");
        letterTable.put(9, "D");
        letterTable.put(10, "X");
        letterTable.put(11, "B");
        letterTable.put(12, "N");
        letterTable.put(13, "J");
        letterTable.put(14, "Z");
        letterTable.put(15, "S");
        letterTable.put(16, "Q");
        letterTable.put(17, "V");
        letterTable.put(18, "H");
        letterTable.put(19, "L");
        letterTable.put(20, "C");
        letterTable.put(21, "H");
        letterTable.put(22, "E");
        
        return letterTable.get(verificator);
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", age=" + age + ", dni=" + dni + ", genre=" + genre + ", weigth=" + weight + ", height=" + height + '}';
    }
    
}
