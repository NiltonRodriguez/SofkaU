/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.Excercise15;

import java.util.Scanner;

/**
 *
 * @author niltonrodriguez
 */
public class Excercise15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        Scanner newScan = new Scanner(System.in);
        
        int option = 0;
        
        System.out.println("""
                           ****** GESTION CINEMATOGRAFICA ******
                           1-NUEVO ACTOR
                           2-BUSCAR ACTOR
                           3-ELIMINAR ACTOR
                           4-MODIFICAR ACTOR
                           5-VER TODOS LOS ACTORES
                           6-VER PELICULAS DE LOS ACTORES
                           7-VER CATEGORIA DE LAS PELICULAS DE LOS ACTORES
                           8-SALIR""");
        
        try{
            do{
                System.out.print("Eliga una opción: ");
                option = newScan.nextInt();
                switch(option){
                    case 1:
                        System.out.println("Agrege el actor.");
                        break;
                    case 2:
                        System.out.println("Busque al actor.");
                        break;
                    case 3:
                        System.out.println("Elimine al actor.");
                        break;
                    case 4:
                        System.out.println("Modifique al actor.");
                        break;
                    case 5:
                        System.out.println("Ver la lista de actores.");
                        break;
                    case 6:
                        System.out.println("Lista de peliculas de los actores.");
                        break;
                    case 7:
                        System.out.println("Lista de categoría de las peliculas.");
                        break;
                    case 8:
                        System.out.println("Gracias por usar el sistema de gestión");
                        break;
                    default:
                        System.out.println("OPCION INCORRECTA");
                        break;
                }
            }while(option != 8);
        } catch (Exception e){
                System.out.println("Por favor ingrese un número.");
        }
    }
}
