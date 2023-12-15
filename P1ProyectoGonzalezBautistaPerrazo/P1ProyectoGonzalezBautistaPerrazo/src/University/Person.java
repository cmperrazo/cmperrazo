
package University;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Person {
    private long identification;
    private String name;
    private String lastName;
    private int studentId;
    private long phone;
    private String address;
    private String userName;

    public Person(long identification, String name, String lastName, int studentId, long phone, String address, String userName) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.studentId = studentId;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
    }

    public Person() {
    }
    
    public void showInformation(){
        
        Scanner sc = new Scanner(System.in);//Leer entradas del Usuario
        
        //Validar cedula o identificacion
        System.out.println("Registro Universitario");
        
        do{
            System.out.print("\nDigite su numero de Cedula: ");
            while(!sc.hasNextLong()){
                System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                System.out.print("\nDigite su numero de Cedula: ");
                sc.next();
            }
            identification = sc.nextLong();
            if(length(identification,10)){
                System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
            }           
        }while(length(identification,10));    
        sc.nextLine();
        
        //Validar nombre y apellido
        do{
            System.out.print("\nIngrese sus Nombres: ");
            setName(sc.nextLine());
            if(!data(getName())){
                System.out.println("Nombre icorrecto, intetelo de nuevo");
            }
        }while(!data(getName()));
        
        do{
            System.out.print("\nIngrese sus Apellidos: ");
            lastName = sc.nextLine();
            if(!data(getLastName())){
                System.out.println("Apellido incorrecto, intentelo de nuevo");
            }
        }while(!data(getLastName()));
     
        //Validacion del numero de telefono
            do{
                System.out.println("\nEscribir tu numero apartir del 0");
                System.out.print("Numero de celular: ");
                while(!sc.hasNextInt()){
                    System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                     System.out.println("\nEscribir tu numero apartir del 0");
                    System.out.print("Numero de celular: ");
                    sc.nextLine();
                }
                phone = sc.nextLong();
                if(length(phone,9) || !String.valueOf(phone).startsWith("9")){
                    System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                }
            }while(length(phone,9) || !String.valueOf(phone).startsWith("9"));
        sc.nextLine();
        do{
            System.out.print("\nIngrese la ciudad de residencia: ");
            address = sc.nextLine();
            if(!data(getAddress())){
                System.out.println("Nombre de ciuddad incorrecta");
            }
        }while(!data(getAddress()));
        userName = generateUser(name,lastName,identification);
        
        //Generar un nombre de usuario
        System.out.println("\nTu Usuario asignado es " + userName);
        
        //Generar un Id para nuestro estudiante o docente
        studentId = id();
        System.out.println("\nTu ID asignado es: L" + studentId);
    }   
    
    //Loguearse Docente o Estudiante
    public void loginUniversity(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese su usuario: ");
        userName = sc.nextLine();
        do{
            System.out.print("\nIngrese su Id: ");
            while(!sc.hasNextInt()){
                System.out.println("Id incorrecta");
                System.out.print("\nIngrese su Id: ");
                sc.next();
            }
            studentId = sc.nextInt();       
        }while(studentId < 10000 || studentId > 99999);
    }

    public String getInformation(){
        return  "\nUniversidad ESPE" + 
                "\nNombre: " + getName() + 
                "\nApellido: " + getLastName() + 
                "\nUsuario: " + getUserName() + 
                "\nId: " + getStudentId();
    }
    public boolean data(String dato){
        return Pattern.matches("[a-zA-Z]+", dato);
    }
    
    public static boolean length(long data, int digit){
        return String.valueOf(data).length() != digit; 
    }
    
    public static int id(){
        Random ale = new Random();
        int id = 10000 + ale.nextInt(90000);
        return id;
    }
    
    public String generateUser(String name, String lastName, long identification){
        String user = name.substring(0, 2);
        String ident = String.valueOf(identification).substring(0, 2);
        String userName = (user+lastName+ident).toLowerCase();
        return userName;
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
