/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_u2;


public class Pentagono extends Figuras {
     private double lado;

    public Pentagono(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (lado * lado * Math.sqrt(25 + 10 * Math.sqrt(5))) / 4;
    }

    @Override
    public double calcularPerimetro() {
        return 5 * lado;
    }
}
