
package Ganado;

import java.util.Scanner;


public class Bovino extends Ganado {
String TamañoCuernos;
String ColorCuernos;

    public Bovino(String TamañoCuernos, String ColorCuernos, String NumMarcacion, String id, String tipoGanado, double peso, String raza, int numGanado, String estadoSalud) {
        super(id, tipoGanado, peso, raza, numGanado, estadoSalud);
        this.TamañoCuernos = TamañoCuernos;
        this.ColorCuernos = ColorCuernos;
    }

public void MostrarEtiquetasBovinos(){
    Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de Bovinos que fueron etiquetados: ");
        int CantEtiquetas = sc.nextInt();
        String[] Etiquetas = new String[CantEtiquetas];

        for (int i = 0; i < Etiquetas.length; i++) {
            System.out.println("Ingrese el número de etiqueta para la vaca " + (i + 1) + ":");
            String numeroDeEtiqueta = sc.next();

            // Almacenar el número de etiqueta en el arreglo
            Etiquetas[i] = numeroDeEtiqueta;
        }

        System.out.println("Números de etiquetas registrados:");

        // Imprimir los números de etiquetas registrados
        for (int i = 0; i < Etiquetas.length; i++) {
            System.out.println((i + 1) + ". " + Etiquetas[i]);
        }
    }
@Override
public void MostrarInformacionGanado(){
    super.MostrarInformacionGanado();
    Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de Cuernos: ");
        TamañoCuernos = sc.nextLine();
        System.out.print("Ingrese el color de los Cuernos: ");
        ColorCuernos = sc.nextLine();
        System.out.println("======== Informacion Adicional de los Bovinos ==========");
        System.out.println("Tamaño Cuernos: " + TamañoCuernos);
        System.out.println("ColorCuernos: " + ColorCuernos);
    
}
    
}
