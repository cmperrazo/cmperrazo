/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_campeonato;
import java.util.Scanner;
/**
 *
 * @author HOME
 */
public class Practica_Campeonato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int opc;
        do {
           mostrarMenu();
           opc = Integer.parseInt(scanner.nextLine());
           switch(opc){
               case 1:
                   
                   Futbol.menuFutbol();
                   break;
                   
               case 2:
                   
                   break;
                   
               case 3:
                   
                   break;
                   
               case 4:
                   System.out.println("Saliendo del programa...");
                   break;
               default:
                   System.out.println("Opcion invalida, ingrese una opcion correcta");
           }
        }while (opc !=4);
    }
 
    public static void mostrarMenu(){
        System.out.println("======CAMPEONATO 2023 ESPE SEDE STO.DOMINGO======");
        System.out.println("==================MENU PRINCIPAL=================");
        System.out.println("1. Equipo de Futbol");
        System.out.println("2. Equipo de Basquet");
        System.out.println("3. Equipo de Ecuavoly");
        System.out.println("4. Salir");
        System.out.println("Por favor, ingrese una opcion");
    }
    
}
