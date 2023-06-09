/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recuperacion_examen;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Recuperacion_Examen {
    private static List<Matricula> matricula= new ArrayList<>();
    private static Object scanner;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Universidad universidad = new Universidad();
        int opc;
        do{
            mostrarMenu();
            opc = scanner.nextInt();
            switch(opc){
                case 1:
                    universidad.ingresarProfesor(scanner);
                    break;
                    
                case 2:
                    universidad.ingresarAlumno(scanner);
                    break;
                    
                case 3:
                     universidad.ingresarMateria(scanner);
                    break;
                    
                case 4:
                    universidad.ingresarMatricula(scanner);
                    break;
                    
                case 5:
                    
                    break;
                    
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida, ingrese una opcion correcta");
                    
                            
            }
            
        }while(opc!=6);
    }
    
    private static void mostrarMenu(){
        System.out.println("MENU DE OPCIONES GESTION MATRICULAS");
        System.out.println("1. Profesores");
        System.out.println("2. Alumno");
        System.out.println("3. Materias");
        System.out.println("4. Gestion Matriculas");
        System.out.println("5. Total matriculados");
        System.out.println("6. Salir");
        System.out.println("Por favor escoja una opcion");
        
    }
    
    
  
}
