/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template(
 */
package practica_cuadrado;
import java.util.Scanner;

public class Practica_Cuadrado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();

        Cuadrado cuadrado = new Cuadrado(lado);

        double area = cuadrado.calcularArea();
        double perimetro = cuadrado.calcularPerimetro();

        System.out.println("El area del cuadrado es: " + area);
        System.out.println("El permetro del cuadrado es: " + perimetro);
    
    
    }
}