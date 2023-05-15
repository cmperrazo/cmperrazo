/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.metodos_parametros_argumentos;
import javax.swing.JOptionPane;
/**
 *
 * @author ESPE
 */
public class Metodos_parametros_argumentos {

    public static void main(String[] args) {
        Operaciones op1 = new Operaciones();
       int nu1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        int nu2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        
        op1.sumar(nu1, nu2);
        op1.restar(nu1,nu2);
        op1.multiplicar(nu1,nu2);
        op1.dividir(nu1,nu2);
        op1.resultados();
    }
}
