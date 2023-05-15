/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodos_parametros_argumentos;

/**
 *
 * @author ESPE
 */
public class Operaciones {
    int suma; int resta; int multiplicacion; int division;
    
 public void sumar(int nu1, int nu2){
     suma = nu1+nu2;
     
 }
 public void restar(int nu1, int nu2){
     resta = nu1-nu2;
 }
 
 public void multiplicar(int nu1, int nu2){
     multiplicacion = nu1*nu2;
 }
 
 public void dividir(int nu1, int nu2){
     division = nu1-nu2;
 }
 public void resultados(){
     System.out.println("El resultado de la suma es:"+suma);
     System.out.println("El resultado de la resta es:"+resta);
     System.out.println("El resultado de la multiplicacion es:"+multiplicacion);
     System.out.println("El resultado de la division es:"+division);
     
}
}