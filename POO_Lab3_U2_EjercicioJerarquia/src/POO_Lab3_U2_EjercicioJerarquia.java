import java.util.Scanner;
public class POO_Lab3_U2_EjercicioJerarquia {

	public static void main(String[] args) {
		//linea de codigo para ingresar informacion por teclado
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============GESTION DE PRODUCTOS=============");
		System.out.println("=============PRODUCTOS ESTANDAR=============");
		System.out.println("Ingrese el nombre del producto estandar");
		String nomEstandar1 = scanner.nextLine();
		System.out.println("Ingrese el precio del producto estandar");
		double precEstandar1 = scanner.nextDouble();
		System.out.println("Ingrese la seccion del producto estandar");
		int seccEstandar1 = scanner.nextInt();
		
		//instanciar la clase
		ProductoEstandar prodEstandar1 = new ProductoEstandar(nomEstandar1, precEstandar1,seccEstandar1);
		
		//informacion de productos ofertados
		System.out.println("=============PRODUCTOS OFERTADOS=============");
		System.out.println("Ingrese el nombre del producto ofertado");
		String nomOfertado1 = scanner.nextLine();
		System.out.println("Ingrese el precio del producto ofertador");
		double precOfertado1 = scanner.nextDouble();
		System.out.println("Ingrese los días que faltan para que la oferta del producto ofertado 1 finalice: ");
	    int díasOfertado1 = scanner.nextInt();
		
		//instanciar la clase
		ProductoOfertado prodOfertado1 = new ProductoOfertado(nomOfertado1, precOfertado1, díasOfertado1);
		
		// Calcular el total del pedido
        int unidPedidas = 5;
        double totalPedido = 0.0;

        totalPedido += prodEstandar1.obtenerPrecio(unidPedidas);
        totalPedido += prodOfertado1.obtenerPrecio(unidPedidas);

        System.out.println("Total del pedido: $" + totalPedido);

        scanner.close();

    }
}