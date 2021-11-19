/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise17.entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author niltonrodriguez
 */
public class Electrodomestico {
    
    protected double precio_base = 100;
    protected String color = "blanco";
    protected char consumo_energetico = 'F';
    protected double peso = 5;
    
    public Electrodomestico() {
    }

    public Electrodomestico(double precio_base, double peso) {
        this.precio_base = precio_base;
        this.peso = peso;
    }
    
    public Electrodomestico(double precio_base, String color, char consumo_energetico, double peso) {
        this.precio_base = precio_base;
        this.color = comprobarColor(color);
        this.consumo_energetico = comprobarConsumoEnergetico(consumo_energetico);
        this.peso = peso;
    }
    
    private char comprobarConsumoEnergetico (char consumo){
        char[] consumos = {'A', 'B', 'C', 'D', 'E', 'F'};
        
        for (char c: consumos){
            if (c == consumo){
                return c;
            }
        }
        
        return consumos[5];
    }
    
    private String comprobarColor(String color){
        String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
        
        for (String c: colores){
            if (c.equalsIgnoreCase(color)){
                return c;
            }
        }
        
        return colores[0];
        
    }
    
    public double precioFinal(){
        double precio_final = this.precio_base;
        double peso = this.peso;
        
        Map<Character, Double> precioConsumo = new HashMap<>();
        precioConsumo.put('A', 100.0);
        precioConsumo.put('B', 80.0);
        precioConsumo.put('C', 60.0);
        precioConsumo.put('D', 50.0);
        precioConsumo.put('E', 30.0);
        precioConsumo.put('F', 10.0);
        
        precio_final += precioConsumo.get(this.consumo_energetico);
        
        if (peso < 20){
            precio_final += 10;
        }
        else if (peso >= 20 && peso < 50){
            precio_final += 50;
        }
        else if (peso >= 50 && peso < 80){
            precio_final += 80;
        }
        else{
            precio_final += 100;
        }
        
        return precio_final;
        
    }
    
    public double getPrecio_base() {
        return precio_base;
    }

    public String getColor() {
        return color;
    }

    public char getConsumo_energetico() {
        return consumo_energetico;
    }

    public double getPeso() {
        return peso;
    }
    
}
