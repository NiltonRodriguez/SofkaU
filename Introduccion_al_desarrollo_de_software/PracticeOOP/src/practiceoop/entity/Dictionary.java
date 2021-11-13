/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceoop.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author niltonrodriguez
 */
public class Dictionary {
    
    private final Map<String, String> words;
    
    /* Constructor Method */
    public Dictionary() {
        this.words = loadWords();
    }
    
    public void newWord(String espWord, String engWord){
        if (this.words.containsKey(espWord)){
            System.out.println("La palabra ya existe en el diccionario");
            searchWord(espWord);
        } else{
            this.words.put(espWord, engWord);
            System.out.println("¡Se agregó la palabra al diccionario exitosamente!");
        }
        
        try{
            BufferedWriter writer = new BufferedWriter(
                                        new FileWriter("dictionary.txt", true));
            writer.append(espWord + ":" + engWord + "\n");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void searchWord(String espWord){
        
        if(this.words.containsKey(espWord)){
            System.out.println("La traducción de '" + espWord + "' es: " +
                    this.words.get(espWord));    
        }
        else{
            System.out.println("No se encontró '" + espWord + "' en el diccionario.");
        }
    }
    
    public void displayDictionary(){
        if (this.words.isEmpty()){
            System.out.println("¡El diccionario está vacío!");
        };
        
        this.words.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
    
    public int wordCount(){
        if (this.words.isEmpty()){
            return 0;
        }
        return this.words.size();
    }
    
    private Map<String, String> loadWords(){
        
        Map<String, String> allWords = new HashMap<>();
        String line = "";
        
        try{
            BufferedReader reader = new BufferedReader(
                                        new FileReader("dictionary.txt"));
            
            while(line != null){
                line = reader.readLine();
                if (line == null || line.equals("") ){
                    break;
                }
                String[] wordPair = line.split(":");
                String espWord = wordPair[0];
                String engWord = wordPair[1];
                allWords.put(espWord, engWord);
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return allWords;
    }
}
