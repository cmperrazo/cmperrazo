/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.metodo_retorno_de_valores;
import javax.swing.JOptionPane;
/**
 *
 * @author ESPE
 */
public class Metodo_retorno_de_valores {

    public static void main(String[] args) {
        Operaciones op1 = new Operaciones();
        //pedimos los numeros, se le pide al usuario que ingrese numeros
        int nu1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        int nu2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        
        //vemos que llama las dos variables y eso enviamos como argumento al metodo sumar
        
        int suma= op1.sumar(nu1,  nu2);
        int resta= op1.restar(nu1,  nu2);
        int multiplicacion= op1.multiplicar(nu1,  nu2);
        int division= op1.dividir(nu1,  nu2);
        
        //prsentamos los resultados 
        op1.resultados(suma);
        op1.resultados(resta);
        op1.resultados(multiplicacion);
        op1.resultados(division);
    }
}
