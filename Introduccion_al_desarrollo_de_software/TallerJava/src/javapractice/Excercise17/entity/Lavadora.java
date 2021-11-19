/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise17.entity;

/**
 *
 * @author niltonrodriguez
 */
public class Lavadora extends Electrodomestico{
    
    private int carga = 5;

    public Lavadora() {
    }

    public Lavadora(double precio_base, double peso) {
        super(precio_base, peso);
    }

    public Lavadora(double precio_base, String color, char consumo_energetico, double peso, int carga) {
        super(precio_base, color, consumo_energetico, peso);
        this.carga = carga;
    }

    @Override
    public double precioFinal() {
        
        double precioLavadora = super.precioFinal();
        
        if (this.carga > 30){
            precioLavadora += 50;
        }
        
        return precioLavadora;
    }

    public int getCarga() {
        return carga;
    }
    
}
