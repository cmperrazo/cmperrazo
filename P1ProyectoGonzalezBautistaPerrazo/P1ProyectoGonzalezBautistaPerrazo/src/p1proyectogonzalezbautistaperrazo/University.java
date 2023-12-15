
package p1proyectogonzalezbautistaperrazo;

import University.Person;
import University.Student;
import University.Teacher;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class University {
     
    public University(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        Person person = new Person();
        
        do{
            try{ 
                line();
                menuLogin();
                option = sc.nextInt();
                switch(option){
                    case 1->{
                        line();
                        login(sc);
                    }
                    case 2->{
                        line();
                        menuRegistration();
                    }
                    case 3->{
                        System.out.println("\nVuelve pronto.");
                    }
                    default->{
                        System.out.println("Opcion incorrecta.");
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("Opcion incorrecta.");
                sc.nextLine();
            }
        }while(option != 3);
    }
    
    public void menuLogin(){
        
        System.out.println("\nUniversidad ESPE\n");
        System.out.println("1. Iniciar Sesion"
                + "\n2. Registrarse"
                + "\n3. Salir");
        System.out.print("Elegir Opcion: ");
    }
    
    public void menuRegistration(){
        Scanner edu = new Scanner(System.in);
        Student student = new Student();
        Teacher teacher = new Teacher();
        int option = 0;
        do{
            try{
                System.out.println("Universidad ESPE\n");
                System.out.print("1. Estudiante"
                        + "\n2. Docente"
                        + "\n3. Volver"
                        + "\nElige una opcion: ");      
                option = edu.nextInt();
                switch(option){
                    case 1->{
                        line();
                        student.showInformation();
                        option = 3;
                    }
                    case 2->{
                        line();
                        teacher.showInformation();
                    }
                    default->{
                        System.out.println("Opcion incorrecta.");
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("\nOpcion incorrecta.");
                edu.nextLine();
            }
        }while(option != 3);    

    }
    
    public void login(Scanner sc){
        
        Student student = new Student();
        Teacher teacher = new Teacher();
        
        System.out.println("Universidad ESPE");
        String verification;
        do{    
            System.out.print("\nEstudiante o Docente: ");
            verification = sc.nextLine();
            if(!comparison(verification)){
                System.out.println("Escritura incorrecta");
            }
        }while(!comparison(verification));
        
        if(verification.equals("Estudiante")){
            verification = "Estudiante.json";
            student.matricularse(verification);
        }else if(verification.equals("Docente")){
            verification = "Docente.csv";
            try {
                teacher.getInformationTeacher(verification);
            } catch (IOException ex) {
                Logger.getLogger(University.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean comparison(String cadena){
        if(cadena.equals("Estudiante")){
            return true;
        }else if(cadena.equals("Docente")){
            return true;
        }else{
            return false;
        }
    }
    
    public static void line(){
        System.out.println("\n---------------------------------------------------\n");
    }
}
