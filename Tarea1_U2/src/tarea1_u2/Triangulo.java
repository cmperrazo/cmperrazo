/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_u2;


public class Triangulo extends Figuras {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

     @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

      @Override
    public double calcularPerimetro() {
        // Para este ejemplo, asumiremos que el triángulo es equilátero
        return 3 * base;
    }
}
