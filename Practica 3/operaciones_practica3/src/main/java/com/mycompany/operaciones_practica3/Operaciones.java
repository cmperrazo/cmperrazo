/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.operaciones_practica3;
import javax.swing.JOptionPane;
/**
 *
 * @author ESPE
 */
public class Operaciones {
    int nu1;
    int nu2;
    int suma; int resta; int multiplicacion; int division;
    //generamos metodos
    //pedimos numeros
    //nuestro metodo es publico 
    
    public void capturasnumeros(){
        nu1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Primer Numero"));
        nu2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Primer Numero"));
       
    }
    //creamos metodos para sumar numeros tipo public, sin retornar nada void no tiene retorno
    
    public void sumar(){
        suma=nu1+nu2;
    }
    //creamos metodos para restar numeros tipo public, sin retornar nada void no tiene restorno
    public void restar(){
        resta=nu1-nu2;
    }
    
    //creamos metodos para multiplicar tipo public, sin retornar nada void no tiene retorno
    public void multiplicar(){
        multiplicacion=nu1*nu2;
    }
    
    //creamos metodos para dividir tipo public, sin retornar nada void no tiene retorno
    public void dividir(){
        division=nu1/nu2;
    }
    //creamos un metodo pra mostrar resultados
    
    public void resultados(){
    System.out.println("El resultado de la suma es:"+suma);
    System.out.println("El resultado de la resta es:"+resta);
    System.out.println("El resultado de la multiplicacion es:"+multiplicacion);
    System.out.println("El resultado de la division es:"+division);
    }
}
