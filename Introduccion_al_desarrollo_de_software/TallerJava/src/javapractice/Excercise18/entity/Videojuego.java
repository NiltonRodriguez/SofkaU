/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise18.entity;

import javapractice.Excercise18.interfaces.Entregable;

/**
 *
 * @author niltonrodriguez
 */
public class Videojuego implements Entregable {
    private String titulo = "";
    private int horasEstimadas = 10;
    private boolean entregado = false;
    private String genero = "";
    private String compania = "";

    public Videojuego() {
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.compania = compania;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "Videojuego{" + "titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado + ", genero=" + genero + ", compania=" + compania + '}';
    }
    
    @Override
    public void entregar(){
        this.entregado = true;
    }
    
    @Override
    public void devolver(){
        this.entregado = false;
    }
    
    @Override
    public boolean isEntregado(){
        return this.entregado;
    }

    @Override
    public int compareTo(Object o) {
        Videojuego toCompare = (Videojuego)o;
        if (this.horasEstimadas < toCompare.horasEstimadas){
            return -1;
        } else if (this.horasEstimadas > toCompare.horasEstimadas){
            return 1;
        }
        return 0;
    }
    
}
