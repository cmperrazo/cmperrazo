
package University;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Person {
    private long identification;
    private String name;
    private String lastName;
    private long phone; 
    private String userName;
    private int universityId;

    public Person(long identification, String name, String lastName, long phone, String userName, int universityId) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.userName = userName;
        this.universityId = universityId;
    }

    public Person() {
    }
    
    public void showInformation(){
        
        Scanner sc = new Scanner(System.in);//Leer entradas del Usuario
        
        // Validar cedula o identificacion
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
            if(searchUserJson(String.valueOf(identification))){
                System.out.println("Este numero de cedula ya esta registrado"
                        + "\nIntentelo nuevamente");
            }
        }while(length(identification,10) || searchUserJson(String.valueOf(identification)));    
        sc.nextLine();
        
        // Validar nombre y apellido
        do{
            System.out.print("\nIngrese sus Nombres: ");
            name = sc.nextLine();
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
     
        // Validacion del numero de telefono
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
                if(searchUserJson(String.valueOf(identification))){
                    System.out.println("Este numero ya esta registrado, intentelo de nuevo");
                }
            }while(length(phone,9) || !String.valueOf(phone).startsWith("9") || searchUserJson(String.valueOf(identification)));      
        }   
    
    // Loguearse Docente o Estudiante
   public void loginUniversity(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        userName = sc.nextLine();
        do{
            System.out.print("\nIngrese su Id: ");
            while(!sc.hasNextInt()){
                System.out.println("Id incorrecta");
                System.out.print("\nIngrese su Id: ");
                sc.next();
            }
            universityId = sc.nextInt();       
        }while(universityId < 10000 || universityId > 99999);
    }
    
    // Crear
    public void createFileJson(List<Student> studentList) {
        
        try (FileWriter writer = new FileWriter("Estudiante.json")) {
        
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonStudent = gson.toJson(studentList);
            writer.write(jsonStudent);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Leer
    public List<Student> readFileJson() {
        
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Estudiante.json"))) {
            Gson gson = new Gson();
            Student[] studentArray = gson.fromJson(reader, Student[].class);

            if (studentArray != null) {
                for (Student student : studentArray) {
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("\nEl archivo no existe");
        }

        return studentList;
    }
    
    // Actualizar
    public void updateDataJson(long identification, String updateData, int num) {
        
        List<Student> studentList = readFileJson();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            
            if(student.getIdentification() == identification){
                if(num == 1){
                    student.setName(updateData);
                }else if(num == 2){
                    student.setLastName(updateData);
                }else if(num == 3){
                    student.setPhone(Long.parseLong(updateData));
                }else if(num == 4){
                    student.setUserName(updateData);
                    
                }else if(num == 5){
                    
                }
                
                System.out.println("\nDatos actualizados");
                break;
            }
            
            /*if (student.getUserName().equals(updateData) && student.getIdentification == ) {
                // Se encontró el estudiante, actualizar la información
                student.setPhone(updatedStudent);              
                break;  // No es necesario seguir buscando
           }*/
        }

        // Guardar la lista actualizada en el archivo JSON
        createFileJson(studentList);
    }
    
    // Eliminar
    public void deleteDataJson(long identification) {
        
        List<Student> studentList = readFileJson();

        for (Iterator<Student> i = studentList.iterator(); i.hasNext();) {
            Student student = i.next();
            
            if (student.getIdentification() == identification) {
                // Se encontró el estudiante, para eliminarlo
                i.remove();
                break;  
            }
        }
        
        // Guarda la nueva lista 
        createFileJson(studentList);
    }
    
    // Busqueda
    public boolean searchDataJson(String route, String nameUser, int idUser) {
        try (FileReader reader = new FileReader(route)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            
            if (jsonElement.isJsonArray()) {
                Person[] users = new Gson().fromJson(jsonElement, Person[].class);

                for (Person user : users) {
                    if (user.getUserName().equals(nameUser) && user.getUniversityId() == idUser) {
                        return true; // Se encontraron coincidencias
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // No se encontraron coincidencias o hubo un error
    }
    
    // Buscar usuario
    public boolean searchUserJson(String data) {
        try (FileReader reader = new FileReader("Estudiante.json")) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            
            if (jsonElement.isJsonArray()) {
                Person[] users = new Gson().fromJson(jsonElement, Person[].class);

                for (Person user : users) {
                    if (user.getUserName().equals(data)) {
                        return true; // Se encontraron coincidencias
                    }else if(String.valueOf(user.getIdentification()).equals(data)){
                         return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // No se encontraron coincidencias o hubo un error
    }
    
    //Verificar ingreso solo caracteres de A - Z
    public boolean data(String dato){
        return Pattern.matches("[a-zA-Z]+", dato);
    }
    
    //Verificar el tamaño de datos
    public static boolean length(long data, int digit){
        return String.valueOf(data).length() != digit; 
    }
    
    //Generar una id
    public static int generateId(){
        Random ale = new Random();
        int id = 10000 + ale.nextInt(90000);
        return id;
    }
    
    //Establecer un usuario con datos propios
    public String generateUser(String name, String lastName, long identification){
        String user = name.substring(0, 2);
        String ident = String.valueOf(identification).substring(0, 2);
        String userName = (user+lastName+ident).toLowerCase();
        return userName;
    }
    
    //Linea para estetica
    public static void line(){
        System.out.println("\n---------------------------------------------------\n");
    }
    
    //Getters and Setters
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


    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}
