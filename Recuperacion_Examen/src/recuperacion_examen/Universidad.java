/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recuperacion_examen;
import java.util.ArrayList;
import java.util.Scanner;

public class Universidad {
    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    private ArrayList<Materia> materias;
    private ArrayList<Matricula> matriculas;
    
    public Universidad(){
        alumnos = new ArrayList<>();
       profesores = new ArrayList<>();
      materias = new ArrayList<>();
      matriculas= new ArrayList<>();
    }
    
    public void ingresarProfesor(Scanner scanner){
        System.out.println("----- INGRESAR PROFESOR -----");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();


        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

       

        Profesor profesor = new Profesor(id, nombre, apellido, telefono);
        profesores.add(profesor);

        System.out.println("Profesor ingresado exitosamente.\n");
    }
    
    public void ingresarAlumno(Scanner scanner) {
        System.out.println("----- INGRESAR ALUMNO -----");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

      
        Alumno alumno = new Alumno(id, nombre, apellido,  telefono);
        alumnos.add(alumno);

        System.out.println("Alumno ingresado exitosamente.\n");
    }
    
     public void ingresarMateria(Scanner scanner) {
        System.out.println("----- INGRESAR MATERIA -----");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Profesores disponibles:");
        mostrarProfesores();

        System.out.print("ID del profesor: ");
        int profesorID = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean profesorExiste = false;
        for (Profesor profesor : profesores) {
            if (profesor.getId() == profesorID) {
                profesorExiste = true;
                break;
            }
        }

        if (profesorExiste) {
            Materia materia = new Materia(id, nombre, profesorID);
            materias.add(materia);

            System.out.println("Materia ingresada exitosamente.\n");
        } else {
            String idprofesor = null;
            System.out.println("Error: El profesor con ID " + idprofesor + " no existe.\n");
        }
    }
     
    public void ingresarMatricula(Scanner scanner) {
        System.out.println("----- INGRESAR MATRÍCULA -----");

        System.out.println("Alumnos disponibles:");
        mostrarAlumnos();

        System.out.print("ID del alumno: ");
        int estudianteID = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Materias disponibles:");
        mostrarMaterias();

        System.out.print("ID de la materia: ");
        int materiaID = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean alumnoExiste = false;
        boolean materiaExiste = false;
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == estudianteID) {
                alumnoExiste = true;
                break;
            }
        }

        for (Materia materia : materias) {
            if (materia.getId() == materiaID) {
                materiaExiste = true;
                break;
            }
        }

        if (alumnoExiste && materiaExiste) {
            var matricula = new Matricula(Idalumno, Idmateria);
            matriculas.add(matricula);

            System.out.println("Matricula ingresada exitosamente.\n");
        } else {
            System.out.println("Error: El alumno o la materia no existen.\n");
        }
    }

     
     private void mostrarProfesores() {
        for (Profesor profesor : profesores) {
            System.out.println("ID: " + profesor.getId());
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("--------------------");
        }
    }
     
     private void mostrarAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println("ID: " + alumno.getId());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("--------------------");
        }
    }
     
      private void mostrarMaterias() {
        for (Materia materia : materias) {
            System.out.println("ID: " + materia.getId());
            System.out.println("Nombre: " + materia.getNombre());
            System.out.println("--------------------");
        }
    }
     
}
