/**
 * 
 */
/**
 * @author ESPE
 *
 */
import java.util.Scanner;
module Evaluacion1PerrazoCamila {
	public static void main (String []args) {
		Producto producto = new Producto();
		Proveedor proveedor = new Proveedor();
		int opc; 
		Scanner ar = new Scanner(System.in)
				do{
					System.out.println("1. Productos");
					System.out.println("2. Proovedores");
					System.out.println("3. Nuevo Pedido");
					System.out.println("4. Pedido mayor");
					System.out.println("5. Total facturado");
					System.out.println("6. Salir");
					opc = Integer.parseInt(ar.nextLine());
					switch(opc) {
					case 1:
						producto.ingresarProductos();
					case 2:
						proveedor.ingresarProveedor();
					case 3:
						
					case 4:
						
						
					case 5:
						
					case 6:
						System.out.println("En un momento saldra del programa");
						break;
						default:
							System.out.println("Ha seleccionado una opcion incorrecta, por favor intente de nuevo")
					}	
				}while(opc!=6);
	}
}