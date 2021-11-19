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
public class Televisor extends Electrodomestico{
    private int resolucion = 20;
    private boolean tdt = false;

    public Televisor() {
    }

    public Televisor(double precio_base, double peso) {
        super(precio_base, peso);
    }

    public Televisor(double precio_base, String color, char consumo_energetico, double peso,
            int resolucion, boolean tdt) {
        super(precio_base, color, consumo_energetico, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    @Override
    public double precioFinal() {
        
        double precioTV = super.precioFinal();
        
        if(this.resolucion > 40){
            precioTV *= 1.30;
        }
        
        if(this.tdt){
            precioTV += 50;
        }
        
        return precioTV;
    }
    
    public int getResolucion() {
        return resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }
}
