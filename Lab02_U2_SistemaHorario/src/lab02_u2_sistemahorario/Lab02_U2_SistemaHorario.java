
package lab02_u2_sistemahorario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab02_U2_SistemaHorario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================INSTITUCION EDUCATIVA===============");
        System.out.println("====JUNTOS POR LA EDUCACION TECNOLOGICA SUPERIOR====");
        System.out.println("===SISTEMA DE GESTION DE HORARIOS DE LABORATORIOS===");
        System.out.print("Ingrese la cantidad de laboratorios a ingresar: ");
        int cantidadLaboratorios = scanner.nextInt();
        scanner.nextLine();

        List<Laboratorio> laboratorios = new ArrayList<>();
        for (int i = 1; i <= cantidadLaboratorios; i++) {
            System.out.println("Laboratorio " + i);
            System.out.print("Ingrese el nombre del laboratorio: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la capacidad máxima de estudiantes: ");
            int capacidad = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese la cantidad de equipos disponibles: ");
            int cantidadEquipos = scanner.nextInt();
            scanner.nextLine();

            Laboratorio laboratorio = new Laboratorio(nombre, capacidad);
            for (int j = 1; j <= cantidadEquipos; j++) {
                System.out.print("Ingrese el nombre del equipo " + j + ": ");
                String equipo = scanner.nextLine();
                laboratorio.agregarEquipo(equipo);
            }
            laboratorios.add(laboratorio);
        }

        System.out.print("Ingrese la cantidad de asignaturas a ingresar: ");
        int cantidadAsignaturas = scanner.nextInt();
        scanner.nextLine();

        List<Asignatura> asignaturas = new ArrayList<>();
        for (int i = 1; i <= cantidadAsignaturas; i++) {
            System.out.println("Asignatura " + i);
            System.out.print("Ingrese el nombre de la asignatura: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el horario de la asignatura: ");
            String horario = scanner.nextLine();
        System.out.println("Laboratorios disponibles:");
            for (int j = 0; j < laboratorios.size(); j++) {
                System.out.println((j + 1) + ". " + laboratorios.get(j).getNombre());
            }

            System.out.print("Ingrese el número del laboratorio asignado: ");
            int laboratorioIndex = scanner.nextInt();
            scanner.nextLine();

            Laboratorio laboratorioAsignado = laboratorios.get(laboratorioIndex - 1);

            if (laboratorioAsignado.verificarDisponibilidad(horario)) {
                Asignatura asignatura = new Asignatura(nombre, horario, laboratorioAsignado);
                asignaturas.add(asignatura);
                laboratorioAsignado.asignarHorario(horario);
                System.out.println("Asignatura asignada correctamente.");
            } else {
                System.out.println("El horario está ocupado en el laboratorio seleccionado. Por favor, elija otro horario o laboratorio.");
            }
        }

        System.out.println("Información de los laboratorios:");
        for (Laboratorio laboratorio : laboratorios) {
            System.out.println("Nombre: " + laboratorio.getNombre());
            System.out.println("Capacidad máxima: " + laboratorio.getCapacidad());
            System.out.println("Equipos disponibles: " + laboratorio.getEquipos());
            System.out.println();
        }

        scanner.close();
    }
}
    

