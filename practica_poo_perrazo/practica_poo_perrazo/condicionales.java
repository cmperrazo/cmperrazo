/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_poo_perrazo;

/**
 *
 * @author ESPE
 */
public class condicionales {
    public static void main(String[] args){
        //sentencia if(condicional)
        int hora= -5;
        if (hora >= 0 && hora <= 12){
            System.out.println("buenos dias");
}else if(hora > 12 && hora <=18){
    System.out.println("Buenas tardes");
}else{ 
    System.out.println("Buenas noches");
    }
   }
 }