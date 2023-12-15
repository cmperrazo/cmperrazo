
package University;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends Person{
    
    private String career;
    private String level;
    private double costoMatricula;

    public Student(String career, String level, double costoMatricula, long identification, String name, String lastName, int studentId, long phone, String address, String userName) {
        super(identification, name, lastName, studentId, phone, address, userName);
        this.career = career;
        this.level = level;
        this.costoMatricula = costoMatricula;
    }

    public Student() {
    }
    
    @Override
    public void showInformation(){
        super.showInformation();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        
        do{
            System.out.println("\nCarrera Universitaria");
            System.out.println("\n1. Biotecnologia"
                    + "\n2. Tecnologias de la informacion"
                    + "\n3. Agropecuaria");
            System.out.print("\nCarrera: ");
            while(!sc.hasNextInt()){
                System.out.println("Opcion incorrecta, cuelva a intentarlo");
                System.out.println("\n.1. Biotecnologia"
                        + "\n2. Tecnologias de la informacion"
                        + "\n3. Agropecuaria");
                System.out.print("\nCarrera: ");
                sc.next();
            }
            num = sc.nextInt();
            if(num == 1){
                career = "Biotecnologia";
            }else if(num == 2){
                career = "Tecnologias de la informacion";
            }else if(num == 3){
                career = "Agropecuaria";
            }else{
                System.out.println("Opcion incorrecta, cuelva a intentarlo");
            }
        }while(num < 1 || num >3);
        sc.nextLine(); //Limpiar Buffer
        do{
            System.out.println("\nNivel de Primero a Octavo y Tesis");
            System.out.print("Nivel: ");
            level = sc.nextLine();
            if(!data(level)){
                System.out.println("El Nivel es incorrecto");
            }
        }while(!data(level)); //Validar los niveles si hay tiempo
        
        Student student = new Student(career,level,0.0, getIdentification(), getName(), getLastName(), getStudentId(), getPhone(), getAddress(), getUserName());
        
        List<Student> studentList = readFileJson();
        
        studentList.add(student);
        
        sortFileStudent(studentList);
        
        createFileJson(studentList);
        
        System.out.println("\nEstudiante Registrado");
        System.out.println("\nAhora ya puedes inicar Sesion");
        
    }
    
    //Escritura
    public void createFileJson(List<Student> studentList) {
        
        try (FileWriter writer = new FileWriter("Estudiante.json")) {
        
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonStudent = gson.toJson(studentList);
            writer.write(jsonStudent);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Lectura
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
    
    //Actualizar
    public void updateStudent(String nameUser, int idUser, Student updatedStudent) {
        List<Student> studentList = readFileJson();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);

            if (student.getUserName().equals(nameUser) && student.getStudentId() == idUser) {
                // Se encontró el estudiante, actualizar la información
                studentList.set(i, updatedStudent);
                break;  // No es necesario seguir buscando
            }
        }

        // Guardar la lista actualizada en el archivo JSON
        createFileJson(studentList);
    }
    
    //Busqueda
    private static void sortFileStudent(List<Student> students) {
        Collections.sort(students, Comparator.comparingLong(Student::getIdentification));
    }
    
    @Override
    public boolean data(String data){
        boolean real = super.data(data);
        return real;
    }
    
    public void matricularse(String fichero){
        do{
            super.loginUniversity();
            if(!searchDataJson(fichero,getUserName(),getStudentId())){
                System.out.println("Usuario no encontrado, intentelo de nuevo");
            }
        }while(!searchDataJson(fichero,getUserName(),getStudentId()));
        Scanner sc = new Scanner(System.in);
        int option = 0;
        
        do{
            System.out.println("Universidad ESPE");
            System.out.println("\n1. Matricularse"
                + "\n2. Actalizar Datos"
                    + "\n3. Salir");
            while(!sc.hasNextInt()){
                System.out.println("Universidad ESPE");
                System.out.println("Opcion incorrecta");
                System.out.println("\n1. Matricularse"
                    + "\n2. Actalizar Datos"
                        + "\n3. Salir");
                sc.next();
            }
            option = sc.nextInt();
            if(option < 1 || option > 3){
                System.out.println("Opcion incorrecta");
            }
            if(option == 1){
                System.out.println("\nProceso de matriculacion");
            }else if(option == 2){
                System.out.println("\nDatos actuales del estudiante");
            }
        }while(option < 1 || option > 3);
    }
    
    //Busqueda
    private static boolean searchDataJson(String route, String nameUser, int idUser) {
        try (FileReader reader = new FileReader(route)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            
            if (jsonElement.isJsonArray()) {
                Person[] users = new Gson().fromJson(jsonElement, Person[].class);

                for (Person user : users) {
                    if (user.getUserName().equals(nameUser) && user.getStudentId() == idUser) {
                        return true; // Se encontraron coincidencias
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // No se encontraron coincidencias o hubo un error
    }

    public double getCostoMatricula() {
        return costoMatricula;
    }

    public void setCostoMatricula(double costoMatricula) {
        this.costoMatricula = costoMatricula;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    
}
