
package University;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Student extends Person{
    
    private String career;
    private String level;
    private List<String> subject;

    public Student(String career, String level, List<String> subject, long identification, String name, String lastName, long phone, String userName, int universityId) {
        super(identification, name, lastName, phone, userName, universityId);
        this.career = career;
        this.level = level;
        this.subject = subject;
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
            if(!super.data(level)){
                System.out.println("El Nivel es incorrecto");
            }
        }while(!super.data(level)); //Validar los niveles si hay tiempo
        
        System.out.println("\nEstudiante Registrado en Json");
        line();
        System.out.println("Tu usuario y ID(contrasenia)");
        setUserName(super.generateUser(getName(), getLastName(), getIdentification()));
        System.out.println("\nUsuario:  " + getUserName());
        setUniversityId(super.generateId());
        System.out.println("Id:       " + getUniversityId());
        
        Student student = new Student(career,level,null, getIdentification(), getName(), getLastName(), getPhone(), getUserName(), getUniversityId());
        
        List<Student> studentList = super.readFileJson();
        
        studentList.add(student);
        
        //Ordenaar Json
        sortFileStudent(studentList);
        
        super.createFileJson(studentList);
        
        line();
        System.out.println("Ahora ya puedes inicar Sesion");
        
    }
    
    // Loguearse Docente o Estudiante
    @Override
    public void loginUniversity(){
        Scanner sc = new Scanner(System.in);
        
        // Verificar si existe un usuario
        do{
            System.out.println("Inicio de Sesion para Estudiantes");
            System.out.print("\nIngrese su usuario: ");
            setUserName(sc.nextLine());
            if(!super.searchUserJson(getUserName())){
                System.out.println("Usuario no existe\n");
            }
        }while(!super.searchUserJson(getUserName()));
        
        // verificar si la contraseña es correcta
        do{
            System.out.print("\nIngrese su Id de 5 digitos: ");
            while(!sc.hasNextInt()){
                System.out.println("Id incorrecta");
                System.out.print("\nIngrese su Id de 5 digitos: ");
                sc.next();
            }
            setUniversityId(sc.nextInt());  
            if(getUniversityId() < 10000 || getUniversityId() > 99999){
                System.out.println("Id incorrecta");
            }
        }while(getUniversityId() < 10000 || getUniversityId() > 99999);
    
        
    }
    
    //Metodo para Estudiante
    public void studentActions(String fichero){
        do{
            line();
            System.out.println("Usuarios para prueba Estudiantes");
            studentExampleJson();
            line();
            loginUniversity();
            if(!super.searchDataJson(fichero,getUserName(),getUniversityId())){
                System.out.println("\nUsuario o contrasenia incorrectos"
                        + "\nIntentelo de nuevo");
            }
        }while(!searchDataJson(fichero,getUserName(),getUniversityId()));
        
        System.out.println("\nIngreso correcto");
        
        Scanner sc = new Scanner(System.in);
        int option = 0;
        
        do{
            line();
            System.out.println("\nUniversidad ESPE");
            System.out.println("\n1. Matricularse"
                + "\n2. Datos personales"
                    + "\n3. Menu principal");
            System.out.print("\nElige una opcion: ");
            while(!sc.hasNextInt()){
                System.out.println("\nUniversidad ESPE");
                System.out.println("Opcion incorrecta");
                System.out.println("\n1. Matricularse"
                    + "\n2. Datos personales"
                        + "\n3. Menu principal");
                System.out.print("\nElige una opcion: ");
                sc.next();
            }
            option = sc.nextInt();
            if(option < 1 || option > 3){
                System.out.println("Opcion incorrecta");
            }
            if(option == 1){
                homologateStudent(getUserName(),getUniversityId());
                //readDataCsv();
            }else if(option == 2){
                System.out.println("\nDatos actuales del estudiante"
                        + "\nLeidos desde un archivo Json\n");
                studentDataJson(getUserName(),getUniversityId());
            }
        }while(option != 3);
    }
         
    //Datos del estudiante
    public void studentDataJson(String nameUser, int idUser) {
        try (FileReader reader = new FileReader("Estudiante.json")) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            
            if (jsonElement.isJsonArray()) {
                Student[] users = new Gson().fromJson(jsonElement, Student[].class);

                for (Student user : users) {
                    if (user.getUserName().equals(nameUser) && user.getUniversityId() == idUser) {
                        System.out.println("Nombre:   " + user.getName() +
                                "\nApellido: " + user.getLastName() +
                                "\nTelefono: " + user.getPhone() + 
                                "\nCedula:   " + user.getIdentification() +
                                "\nCarrera:  " + user.getCareer() +
                                "\nNivel:    " + user.getLevel() +
                                "\nUsuario:  " + user.getUserName() +
                                "\nID:       " + user.getUniversityId() +
                                "\nMaterias: " + user.getSubject()
                         );
                        
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void studentExampleJson() {
        try (FileReader reader = new FileReader("Estudiante.json")) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            
            if (jsonElement.isJsonArray()) {
                Student[] users = new Gson().fromJson(jsonElement, Student[].class);

                for (int i = 0; i < users.length ; i++) {
                     if (i < 2) {
                    Student user = users[i];
                    System.out.println("\nNombre de usuario:  " + user.getUserName());
                    System.out.println("Id o contrasenia:   " + user.getUniversityId());
                     }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    //Odenacion interna MegaSort
    private static void sortFileStudent(List<Student> students) {
        Collections.sort(students, Comparator.comparingLong(Student::getIdentification));
    }
    
    public void homologateStudent(String userName, int universityId) {
        Scanner sc = new Scanner(System.in);

        String[] subjects = new String[5];
        subjects[0] = "Programacion Orientada. O.";
        subjects[1] = "Calculo vectorial.";
        subjects[2] = "Fisica.";
        subjects[3] = "Computacion digital";
        subjects[4] = "Ecuaciones Diferenciales";

        List<String> subjectList = new ArrayList<>();

        line();
        System.out.println("\nProceso de matriculacion");
        System.out.println("\nMaterias a las que puedes matricularte\n");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". Materia: " + subjects[i]);
        }

        // Permitir al estudiante matricularse en hasta 3 materias
        Set<Integer> selectedOptions = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("\nIngresa el numero de la Materia que deseas matricularte (0 para finalizar): ");
            while (!sc.hasNextInt()) {
                System.out.println("Numero incorrecto");
                System.out.print("\nNumero de la Materia que deseas matricularte (0 para finalizar): ");
                sc.next();
            }
            int j = sc.nextInt();

            if (j == 0) {
                break;
            }
            if (j >= 1 && j <= subjects.length && !selectedOptions.contains(j)) {
                selectedOptions.add(j);
                subjectList.add(subjects[j - 1]);
                System.out.println("Te matriculaste en: " + subjects[j - 1]);
            } else {
                System.out.println("Ya estas matriculado en " + subjects[j - 1]);
                i--;  // Decrementar el contador para permitir que el estudiante ingrese otra opción válida.
            }
        }

        updateDataJson(userName, universityId, subjectList);

        line();
        System.out.println("Te has matriculado exitosamente");
}
    
    /*public void homologateStudent(String userName, int universityId) {
        Scanner sc = new Scanner(System.in);

        String[] subjects = new String[5];
        subjects[0] = "Programacion Orientada. O.";
        subjects[1] = "Calculo vectorial.";
        subjects[2] = "Fisica.";
        subjects[3] = "Computacion digital";
        subjects[4] = "Ecuaciones Diferenciales";

        List<String> subjectList = new ArrayList<>();

        line();
        System.out.println("\nProceso de matriculacion");
        System.out.println("\nMaterias a las que puedes matricularte\n");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". Materia: " + subjects[i]);
        }

        // Permitir al estudiante matricularse en hasta 3 materias
        for (int i = 0; i < 3; i++) {
            
            System.out.print("\nIngresa el numero de la Materia que deseas matricularte (0 para finalizar): ");
            while(!sc.hasNextInt()){
                System.out.println("Numero  incorrecto");
                System.out.print("\nIngresa el numero de la Materia que deseas matricularte (0 para finalizar): ");
                sc.next();
            }
            int j = sc.nextInt();
            
            if (j == 0) {
                break;
            }
            if (j >= 1 && j <= subjects.length) {
                subjectList.add(subjects[j - 1]);
                System.out.println("Te matriculaste en: " + subjects[j - 1]);
            } else {
                System.out.println("Opcion incorrecta. Ingresa un numero valido.");
                i--;  // Decrementar el contador para permitir que el estudiante ingrese otra opción válida.
            }
        }

        updateDataJson(userName, universityId,subjectList);

        line();
        System.out.println("Te has matriculado exitosamente");
    }*/
    
    public void updateDataJson(String userName, int universityId, List<String> list) {
        
        List<Student> studentList = readFileJson();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            
            if(student.getUserName().equals(userName) && student.getUniversityId() == universityId){
                student.setSubject(list);               
                break;
            }
            
        }

        // Guardar la lista actualizada en el archivo JSON
        createFileJson(studentList);
    }


    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
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
