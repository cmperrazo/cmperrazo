/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio2_sistemagestionhorariolaboratorios;
import java.util.Scanner;

public class Laboratorio2_SistemaGestionHorarioLaboratorios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
       
        System.out.println("================INSTITUCION EDUCATIVA===============");
        System.out.println("====JUNTOS POR LA EDUCACION TECNOLOGICA SUPERIOR====");
        System.out.println("===SISTEMA DE GESTION DE HORARIOS DE LABORATORIOS===");
        System.out.println("Ingrese la cantidad de laboratorios");
        int cant_lab = scanner.nextInt();
        scanner.nextLine();
        
         scanner.nextLine(); // Consumir el salto de línea después de leer el entero

        Laboratorios[] laboratorios = new Laboratorios[cant_lab];

        // Pedir los datos de cada laboratorio
        for (int i = 0; i < cant_lab; i++) {
            System.out.println(" ======================================================== ");
            System.out.println(" Ingrese los datos del laboratorio #" + (i + 1));
            System.out.print("Nombre del laboratorio: ");
            String nombre = scanner.nextLine();
            System.out.print("Capacidad del laboratorio: ");
            int capacidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el entero
            System.out.print("Equipos del laboratorio (separados por comas): ");
            String[] equipos = scanner.nextLine().split(",");
            
            // Crear una instancia del laboratorio correspondiente según su tipo
            laboratorios[i] = new Laboratorio1(nombre, capacidad, equipos, "espacio", "lugar");
        }

        // Pedir la cantidad de asignaturas a ingresar
         System.out.print("\n Ingrese la cantidad de asignaturas : ");
        int cantidadAsignaturas = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el entero

        Asignatura[] asignaturas = new Asignatura[cantidadAsignaturas];

        // Pedir los datos de cada asignatura
        for (int i = 0; i < cantidadAsignaturas; i++) {
             System.out.println("\n Ingrese los datos de la asignatura #" + (i + 1));
            System.out.print("Nombre de la asignatura: ");
            String nombre = scanner.nextLine();
            System.out.print("Horario de la asignatura: ");
            String horario = scanner.nextLine();
  // Asignar un laboratorio a la asignatura
            System.out.println("\n Seleccione un laboratorio para la asignatura:");
            for (int j = 0; j < cant_lab; j++) {
                System.out.println((j + 1) + ". " + laboratorios[j].getNombre());
            }
            int seleccionLaboratorio = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el entero

            // Crear una instancia de la asignatura y asignar el laboratorio correspondiente
            asignaturas[i] = new Asignatura(nombre, horario, laboratorios[seleccionLaboratorio - 1]);
        }

        // Mostrar información de los laboratorios
 System.out.println("\n Información de los laboratorios:");
        for (Laboratorios laboratorio : laboratorios) {
            System.out.println("Nombre: " + laboratorio.getNombre());
            System.out.println("Capacidad: " + laboratorio.getCapacidad());
            System.out.println("Equipos: " + String.join(", ", laboratorio.getEquipos()));
            System.out.println();
        }

        scanner.close();



       


       
    }
    
}
