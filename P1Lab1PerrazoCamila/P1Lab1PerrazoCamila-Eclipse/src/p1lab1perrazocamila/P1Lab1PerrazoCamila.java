package p1lab1perrazocamila;
import java.util.Scanner;

public class P1Lab1PerrazoCamila {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=========================================");
		System.out.println("UNIVERSIDAD DE LAS FUERZAS ARMADADAS ESPE");
		System.out.println("    PROGRAMACION ORIENTADA A OBJETOS     ");
		System.out.println("Estudiante: Perrazo Camila");
		System.out.println("=========================================");
		System.out.println("Ingrese el primer numero: ");
		double num1 = scanner.nextDouble();
		System.out.println("Ingrese el segundo numero: ");
		double num2 = scanner.nextDouble();
		double suma = num1 + num2;
		double resta = num1 - num2;
		double multiplicacion = num1 * num2;
		double division = num1 / num2;
		System.out.println("La suma de: "+num1+ " y "+num2+ " es: "+suma);
		System.out.println("La resta de: "+num1+ " y "+num2+ " es: "+resta);
		System.out.println("La multiplicación de: "+num1+ " y "+num2+ " es: "+multiplicacion);
		System.out.println("La division de: "+num1+ " y "+num2+ " es: "+division);
		

	}

}
