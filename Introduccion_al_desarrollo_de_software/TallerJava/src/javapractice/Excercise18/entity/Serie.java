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
public class Serie implements Entregable {
    private String titulo = "";
    private int temporadas = 3;
    private boolean entregado = false;
    private String genero = "";
    private String creador = "";

    public Serie() {
    }

    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
    }

    public Serie(String titulo, int temporadas, String genero, String creador) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.genero = genero;
        this.creador = creador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    

    @Override
    public String toString() {
        return "Serie{" + "titulo=" + titulo + ", temporadas=" + temporadas + ", entregado=" + entregado + ", genero=" + genero + ", creador=" + creador + '}';
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
        Serie toCompare = (Serie)o;
        if (this.temporadas < toCompare.temporadas){
            return -1;
        } else if (this.temporadas > toCompare.temporadas){
            return 1;
        }
        return 0;
    }
}
