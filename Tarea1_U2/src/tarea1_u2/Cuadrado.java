/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_u2;

public class Cuadrado extends Figuras{
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }
    @Override
    public double calcularArea() {
        return lado * lado;
    }
   @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}
