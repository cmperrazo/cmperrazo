
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
        
        System.out.println("Universidad ESPE\n");
        System.out.println("1. Iniciar Sesion"
                + "\n2. Registrarse"
                + "\n3. Salir");
        System.out.print("\nElegir Opcion: ");
    }
    
    public void menuRegistration(){
        Scanner edu = new Scanner(System.in);
        Student student = new Student();
        Teacher teacher = new Teacher();
        int option = 0;
        do{
            try{
                line();
                System.out.println("Universidad ESPE\n");
                System.out.print("1. Estudiante"
                        + "\n2. Docente"
                        + "\n3. Volver");
                System.out.print("\nElige una opcion: ");      
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
    
    // Metodo para loguearse como estudiante o como docente
    public void login(Scanner sc){
        
        Student student = new Student();
        Teacher teacher = new Teacher();
        
        System.out.println("Universidad ESPE");
        String verification;
        String date;
        sc.nextLine();
        do{    
            System.out.print("\nEstudiante o Docente: ");
            verification = sc.nextLine();
            date = convert(verification);
            if(!comparison(date)){
                System.out.println("Escritura incorrecta");
            }
        }while(!comparison(date));
        
        if(convert(verification).equals("estudiante")){
            verification = "Estudiante.json";
            student.studentActions(verification);
        }else if(convert(verification).equals("docente")){
            verification = "Docente.csv";
            try {
                teacher.teacherActions(verification);
            } catch (IOException ex) {
                Logger.getLogger(University.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Comparar si dos cadenas son iguales
    public boolean comparison(String cadena){
        if(cadena.equals("estudiante") || cadena.equals("docente")){
            return true;
        }
        return false;
    }
    
    //Convertir una cadena a minusculas
    public String convert(String data){
        return data.toLowerCase();
    }
    
    public static void line(){
        System.out.println("\n---------------------------------------------------\n");
    }
    
}
