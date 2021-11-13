/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceoop.entity;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Menu {
    
    private int option;
    private Dictionary translate;
    Scanner newScan = new Scanner(System.in);

    public Menu(Dictionary translate) {
        this.translate = translate;
    }
    
    public void run(){
        System.out.println("Bienvenido al traductor.");
        System.out.println("""
                           1. Agregar palabras al diccionario.
                           2. Buscar una palabra en el diccionario.
                           3. Leer el diccionario completo.
                           4. Salir.""");
        
        String espWord = "";
        String engWord = "";
        do{
            System.out.print("\nPor favor introduzca el número de la opción " + 
                "que desea ejecutar: ");
            this.option = newScan.nextInt();
            switch(this.option){
                case 1:
                    System.out.print("Introduzca la palabra en español: ");
                    espWord = newScan.next();
                    System.out.print("Intruduzca la traducción al inglés: ");
                    engWord = newScan.next();
                    translate.newWord(espWord.toLowerCase(), engWord.toLowerCase());
                    break;
                case 2:
                    System.out.println("Introduzca la palabra que desea consultar: ");
                    espWord = newScan.next();
                    translate.searchWord(espWord.toLowerCase());
                    break;
                case 3:
                    System.out.println("En total hay " + translate.wordCount() +
                            " palabra(s) en el diccionario.");
                    translate.displayDictionary();
                    break;
            }
        }while(this.option != 4);
        
        System.out.println("\nGracias por usar el traductor.");
    }
}
