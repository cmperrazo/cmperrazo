/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7_u2_perrazocamila;


public class Motocicleta extends Vehiculo{
    boolean patada;
    
    //traemos los metods desde vehiculo para redefinir
    //en esta clase con @Override
    //antes de poner el comando se observa error, nos pide añadir @override
 @Override 
public void encendido(){
     encendido = true;
     estado = "Motocicleta encendido";
    
}
 //en todas las clases se redefine @override
 public void apagado(){
     encendido = false;
     estado = "Motocicleta apagado";
 }
}
