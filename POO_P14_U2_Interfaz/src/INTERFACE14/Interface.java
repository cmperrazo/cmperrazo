package INTERFACE14;
import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opc = 0;
		do {
		System.out.println("========AREAS FIGURAS========");
		System.out.println("1. Cuadrado");
		System.out.println("2. Circulo");
		System.out.println("3. Triangulo");
		System.out.println("4. Salir");
		System.out.println("Ingrese la opcion deseada");
		opc = scanner.nextInt();
		
		switch(opc) {
		
		case 1:
			System.out.println("Ingrese el lado del cuadrado");
			double lado = scanner.nextDouble();
			Cuadrado cuadrado = new Cuadrado(lado);
			System.out.println("El area del cuadrado es: "+cuadrado.calcularArea());
			
		case 2:
			System.out.println("Ingrese el radio del circulo");
			double r = scanner.nextDouble();
			Circulo circulo = new Circulo(r);
			System.out.println("El area del circulo es: "+circulo.calcularArea());
			
		case 3:
			System.out.println("Ingrese la base del triangulo: ");
			double b = scanner.nextDouble();
			System.out.println("Ingrese la altura del triangulo");
			double h = scanner.nextDouble();
			Triangulo triangulo = new Triangulo(b, h);
			System.out.println("El area del triangulo es: "+triangulo.calcularArea());
		case 4:
			 System.out.println("Saliendo del programa...");
             break;
        default:
             System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
             break;
		}
		
		System.out.println();
        } while (opc != 4);
		
		

	}

}
