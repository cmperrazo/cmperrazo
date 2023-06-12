/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7_u2_perrazocamila;

public class Vehiculo {
    String placa;
    int numRuedas;
    boolean encendido;
    String estado;
    
   public void setNumeroRuedas(int ruedas){
       numRuedas = ruedas;   
   }
   public void encendido(){
       encendido = true;
       estado = "Vehiculo encendido";
   }
   public void apagado(){
       encendido = false;
       estado = "Vehiculo apagado";
   }
}
