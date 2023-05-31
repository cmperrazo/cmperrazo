package Evaluacion1PerrazoCamila;

import java.util.Scanner;

public class Proveedor {
	private String []proovedor = new String[2];
	private int cant_proov = 0;
	
	public void ingresarProovedor() {
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<proovedor.length;i++) {
			System.out.println("Ingrese el proovedor que se almacenara en la posicion "+(i+1)+":");
			proovedor[i]= Integer.parseString(scanner.nextLine());
	    } 
		cant_proov = proovedor.length;
		System.out.println("Los proovedores han sido ingresados correctamente");
	}
}

