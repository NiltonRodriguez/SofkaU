/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.entity;

/**
 *
 * @author niltonrodriguez
 */
public class Division extends Operation{
    
    @Override
    public String operation(double number1, double number2){
        if (number2 == 0){ return "No es posible dividir por 0"; }
        result = number1 / number2;
        return "El resultado de la división es: " + result;
    }
}
