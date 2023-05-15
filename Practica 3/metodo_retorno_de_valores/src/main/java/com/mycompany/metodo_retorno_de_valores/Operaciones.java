/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodo_retorno_de_valores;

/**
 *
 * @author ESPE
 */
public class Operaciones {
    //cuando se declara fuera de los metodos las variables globales
    //cuando se las declara dentro del metodo de las varibles son locales
    //int
    
    
 public int sumar(int nu1, int nu2){
 int suma=nu1+nu2;
 
 //retorno suma
 return suma;
 
 
}
 
public int restar(int nu1, int nu2){
 int resta=nu1-nu2;
 
 //retorno suma
 return resta;
 
 
}

public int multiplicar(int nu1, int nu2){
 int multiplicacion=nu1*nu2;
 
 //retorno suma
 return multiplicacion;

}

public int dividir(int nu1, int nu2){
 int division=nu1/nu2;
 
 //retorno suma
 return division;

}
 //cremoas un metodo para mostrar resultados, como son variables locales que le pasamos como
public void resultados(int suma, resta, multiplicacion, division){
    System.out.println("El resultado de la suma es:"+suma);
    System.out.println("El resultado de la suma es:"+resta);
    System.out.println("El resultado de la suma es:"+multiplicacion);
    System.out.println("El resultado de la suma es:"+division);
}
}
