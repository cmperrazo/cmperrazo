package Evaluacion1PerrazoCamila;
import java.util.Scanner;

public class Producto {
private String []productos = new String[4];
private int cant_prod = 0;

public void ingresarProductos() {
	Scanner scanner = new Scanner(System.in);
	for (int i=0; i<productos.length;i++) {
		System.out.println("Ingrese el producto que se almacenara en la posicion "+(i+1)+":");
		productos[i]= Integer.parseString(scanner.nextLine());
	}
	cant_prod = productos.length;
	System.out.println("Los productos se han sido ingresados correctamente");
}
}
