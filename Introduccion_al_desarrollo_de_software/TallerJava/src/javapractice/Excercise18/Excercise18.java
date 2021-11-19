/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise18;

import java.util.ArrayList;
import java.util.List;
import javapractice.Excercise18.entity.Serie;
import javapractice.Excercise18.entity.Videojuego;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Serie> series = new ArrayList<>();
        series.add(new Serie());
        series.add(new Serie("Friends", 10, "Comedia", "Warner"));
        series.add(new Serie("Perception", "CBS"));
        series.add(new Serie("Fringe", 5, "SciFi", "Bad Robot"));
        series.add(new Serie("Castle", 8, "Misterio", "ABC"));
        
        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(new Videojuego());
        videojuegos.add(new Videojuego("Valkirye Profile", 30 , "JRPG", "Enix"));
        videojuegos.add(new Videojuego("Super Mario Bros", 2, "Plataformas", "Nintendo"));
        videojuegos.add(new Videojuego("Crash Bandicoot", 25));
        videojuegos.add(new Videojuego("Final Fantasy 7", 38, "JRPG", "SquareSoft"));
        
        series.get(1).entregar();
        series.get(3).entregar();
        
        videojuegos.get(0).entregar();
        videojuegos.get(2).entregar();
        videojuegos.get(4).entregar();
        
        int seriesEntregadas = 0;
        
        for (Serie serie: series){
            if (serie.isEntregado()){
                seriesEntregadas += 1;
                serie.devolver();
            }
        }
        
        int juegosEntregados = 0;
        
        for (Videojuego juego: videojuegos){
            if (juego.isEntregado()){
                juegosEntregados += 1;
                juego.devolver();
            }
        }

        System.out.println("*****************************");
        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("*****************************");
        System.out.println("Videojuegos entregados: " + juegosEntregados);
        System.out.println("*****************************");
        System.out.println("Serie con más temporadas: " + masTemporadas(series));
        System.out.println("*****************************");
        System.out.println("El juego con más horas estimadas: " + 
                masHoras(videojuegos));

    }
    
    public static String masTemporadas(List<Serie> series){
        
        int temporadas = 0;
        Serie serieMayor = new Serie();
        int tamaño = series.size();
        for (int i = 0; i < tamaño - 1; i++){
            Serie serieActual = series.get(i);
            for (int j = i+1; j < tamaño; j++){
                if (serieActual.compareTo(series.get(j)) > 0 &&
                        serieActual.getTemporadas() > temporadas){
                    temporadas = serieActual.getTemporadas();
                    serieMayor = serieActual;
                } else if(serieActual.compareTo(series.get(j)) < 0){ 
                    if (j == tamaño - 1){
                        temporadas = series.get(j).getTemporadas();
                        serieMayor = series.get(j);
                    }
                    break; 
                }
            }
        }
        
        return serieMayor.toString();
    }
    
    public static String masHoras(List<Videojuego> videojuegos){
        
        int horas = 0;
        Videojuego juegoMayor = new Videojuego();
        int tamaño = videojuegos.size();
        for (int i = 0; i < tamaño - 1; i++){
            Videojuego juegoActual = videojuegos.get(i);
            for (int j = i+1; j < tamaño; j++){
                if (juegoActual.compareTo(videojuegos.get(j)) > 0 &&
                        juegoActual.getHorasEstimadas()> horas){
                    horas = juegoActual.getHorasEstimadas();
                    juegoMayor = juegoActual;
                } else if(juegoActual.compareTo(videojuegos.get(j)) < 0){ 
                    if (j == tamaño - 1){
                        horas = videojuegos.get(j).getHorasEstimadas();
                        juegoMayor = videojuegos.get(j);
                    }
                    break; 
                }
            }
        }
        
        return juegoMayor.toString();
    }
}
