package Ganado;

import Empleados.EmpleadoAgricola;
import Empleados.EmpleadoGanadero;
import java.util.Scanner;

public class Ganado {
String id;
String tipoGanado;
double peso;
String raza;
int numGanado;
String estadoSalud;

    public Ganado(String id, String tipoGanado, double peso, String raza, int numGanado, String estadoSalud) {
        this.id = id;
        this.tipoGanado = tipoGanado;
        this.peso = peso;
        this.raza = raza;
        this.numGanado = numGanado;
        this.estadoSalud = estadoSalud;
    }

public double ObtenerGananciaGanado(){
   
    EmpleadoGanadero ganadero = new EmpleadoGanadero("","","",0,0.0,0.0,"","",0,0,0.0 );
    EmpleadoAgricola agri = new EmpleadoAgricola("","",0,0,"","",0,0,0.0);
    
    double gananciaHuevos = ganadero.venderHuevos();
    double gananciaLeche = ganadero.venderLeche(); 
    double gananciaNaranjas =agri.VenderCacao();
    double gananciaCacao = agri.VenderNaranjas();
    
   double gananciaTotal = gananciaLeche + gananciaHuevos + gananciaNaranjas + gananciaCacao;
   System.out.print("La ganancia es de: "+gananciaTotal);

        return gananciaTotal;
        
}
public void MostrarInformacionGanado(){
    
    Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del Ganado: ");
        id = scanner.nextLine();

        System.out.print("Ingrese el Tipo de Ganado: ");
        tipoGanado = scanner.nextLine();

        System.out.print("Ingrese el Peso (kg): ");
        peso = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del salto de línea

        System.out.print("Ingrese las Razas de Ganado que tiene: ");
        raza = scanner.nextLine();

        System.out.println("Ingrese el Número de Ganado: ");
        numGanado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del salto de línea

        System.out.print("Ingrese el stado de Salud del Ganado: ");
        estadoSalud = scanner.nextLine();

        System.out.println("Información del Ganado:");
        System.out.println("ID: " + id);
        System.out.println("Tipo de Ganado: " + tipoGanado);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Raza: " + raza);
        System.out.println("Número de Ganado: " + numGanado);
        System.out.println("Estado de Salud: " + estadoSalud);
        
}    
}

