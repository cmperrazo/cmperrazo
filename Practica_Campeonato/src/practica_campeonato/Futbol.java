/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_campeonato;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author HOME
 */
public class Futbol {
    public int num_equipo;
    public String carrera;
    public String equipo;
    public static List<Futbol> listaFutbol = new ArrayList<>();
    
    public static void menuFutbol(){
        Scanner scanner = new Scanner (System.in);
        int opcFut;
        do{
            mostrarMenu();
            opcFut = Integer.parseInt(scanner.nextLine());
            switch(opcFut){
                case 1:
                        
                    break;
                    
                case 2:
                   
                    break;
                    
                case 3:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, por favor ingrese una opcion correcta");
            }
        } while (opcFut !=5);
        
    }
    
    public static void mostrarMenu(){
        System.out.println("=====MENU EQUIPO FUTBOL=====");
        System.out.println("1. Equipo masculino");
        System.out.println("2. Equipo femenino");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opcion");
    }
    public void equipomasculino(){
        System.out.println("=====MENU EQUIPO FUTBOL=====");
        System.out.println("1. Equipo masculino");
        System.out.println("2. Equipo femenino");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opcion");
    }
    
}

