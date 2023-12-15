
package University;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Teacher extends Person{
    
    private String departament;
    private String academicTitle;

    public Teacher(String departament, String academicTitle, long identification, String name, String lastName, long phone, String userName, int universityId) {
        super(identification, name, lastName, phone, userName, universityId);
        this.departament = departament;
        this.academicTitle = academicTitle;
    }
    
    public Teacher() {
    }
    
    //Registro de Docente
    @Override
    public void showInformation(){
        super.showInformation();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("\nDepartamento de ciencias: ");
            departament = sc.nextLine();
            if(!data(departament)){
                System.out.println("\nEl departamento es incorrecto");
            }
        }while(!data(departament));
        do{
            System.out.print("\nTitulo de 3er Nivel: ");
            academicTitle = sc.nextLine();
            if(!data(academicTitle)){
                System.out.println("Titulo incorrecto");
            }
        }while(!data(academicTitle));
        
        System.out.println("\nDocente registrado en Csv");
        line();
        System.out.println("Tu usuario y ID(contrasenia)");
        setUserName(super.generateUser(getName(), getLastName(), getIdentification()));
        System.out.println("\nUsuario:  " + getUserName());
        setUniversityId(super.generateId());
        System.out.println("Id:       " + getUniversityId());
        
        //Guardar el registro del docente en csv
        Teacher teacher = new Teacher(departament,academicTitle, getIdentification(), getName(), getLastName(), getPhone(), getUserName(), getUniversityId());
        createFileCsv(teacher);
        line();
        System.out.println("Ahora ya puedes iniciar sesion");    
        
    }
    
    //Metodo para Docente
    public void teacherActions(String file) throws IOException{
        do{
            line();
            System.out.println("Usuarios para prueba Docentes");
            readExampleCsv();
            line();
            //VerificarPelicula():
            loginUniversity();
            if(!searchDataCsv(file,getUserName(), getUniversityId())){
                System.out.println("Docente no registrado");
            }
        }while(!searchDataCsv(file,getUserName(), getUniversityId()));
        
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            line();
            System.out.println("\tUniversidad ESPE\n");
            readDataCsv(getUserName(),getUniversityId());
            System.out.println("\n1. Actualizar dato estudiantil"
                    + "\n2. Borrar estudiante del sistema"
                    + "\n3. Salir");
            System.out.print("\nElige una opcion: ");
            while(!sc.hasNextInt()){
                System.out.println("Opcion incorrecta");
                line();
                System.out.println("\nUniversidad ESPE\n");
                readDataCsv(getUserName(),getUniversityId());
                System.out.println("\n1. Actualizar dato estudiantil"
                    + "\n2. Borrar estudiante del sistema"
                    + "\n3. Salir");
                System.out.print("\nElige una opcion: ");
                sc.next();
            }
            option = sc.nextInt();
            switch(option){
                case 1->{
                    updateStudent();
                }
                case 2->{
                    deleteStudent();
                }
                default ->{
                    System.out.println("Opcion incorrecta");
                }
            }
        }while(option != 3);
    }
    
    //Crear Csv
    public void createFileCsv(Teacher teacher) {
        try {
            
            boolean isFileEmpty = !new File("Docente.csv").exists();

            CsvWriter writer = new CsvWriter(new FileWriter("Docente.csv", true), ',');
            // Verifica si el archivo existe
            if (isFileEmpty) {
                writer.writeRecord(new String[]{"UserName", "StudentId", "Identification", "Name", "LastName", "Phone", "Address", "Departament", "AcademicTitle"});
            }
            // Escribe los datos del profesor en el archivo
            writer.writeRecord(new String[]{
                    teacher.getUserName(),
                    String.valueOf(teacher.getUniversityId()),
                    String.valueOf(teacher.getIdentification()),
                    teacher.getName(),
                    teacher.getLastName(),
                    String.valueOf(teacher.getPhone()),
                    teacher.getDepartament(),
                    teacher.getAcademicTitle()
            });
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Leer Csv
    private void readDataCsv(String nameUser, int idUser) {
        try {
            CsvReader csvReader = new CsvReader(new FileReader("Docente.csv"));
            while (csvReader.readRecord()) {
                try {
                    String csvUserName = csvReader.get(0);
                    int csvStudentId = Integer.parseInt(csvReader.get(1));

                    if (csvUserName.equals(nameUser) && csvStudentId == idUser) {
                        
                        String name = csvReader.get(3);
                        String lastName = csvReader.get(4);
                        String userName = csvReader.get(7);
                        
                        System.out.println("Bienvenido/a " + name + " " +lastName);
                        System.out.println("\t" + userName);
                        break;
                    }
                } catch (NumberFormatException e) {
                    
                }
            }
            csvReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    private void readExampleCsv() {
        File file = new File("Docente.csv");
        if(!file.exists()){
            System.out.println("\nNo exiten usuarios registrados");
            return;
        }
        try {
            CsvReader csvReader = new CsvReader(new FileReader("Docente.csv"));
            int iterador = 0;
            while (csvReader.readRecord()) {
                
                try {
                    
                    if(iterador < 2){
                    String userName = csvReader.get(0);
                    int studentId = Integer.parseInt(csvReader.get(1));

                    System.out.println("\nNombre de usuario:  " + userName);
                    System.out.println("Id o contrasenia:   " + studentId);     
                    iterador++;
                    }
                } catch (NumberFormatException e) {
                    
                }
            }
            csvReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    //Busqueda
    private boolean searchDataCsv(String file, String nameUser, int idUser) {
         
        File newfile = new File(file);
        if(!newfile.exists()){
            return false;
        }
        try {
            CsvReader csvReader = new CsvReader(new FileReader(file));
            while (csvReader.readRecord()) {
                try {
                    String csvUserName = csvReader.get(0);
                    int csvStudentId = Integer.parseInt(csvReader.get(1));

                    if (csvUserName.equals(nameUser) && csvStudentId == idUser) {
                        csvReader.close();
                        return true; 
                    }
                } catch (NumberFormatException e) {
                    
                }
            }
            csvReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
    //Actualizar datos estudiante
    public void updateStudent(){
        Scanner sc = new Scanner(System.in);
        String data = "";
        int id = 0;
        long cedula = 0; 
        String file = "Estudiante.json";
        do{
            line();
            System.out.println("Usuarios para prueba");
            studentExampleJson();
            do{
                line();
                System.out.print("Digite el numero de Cedula: ");
                while(!sc.hasNextLong()){
                    System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                    System.out.print("\nDigite el numero de Cedula: ");
                    sc.next();
                }
                setIdentification(sc.nextLong());
                data = String.valueOf(getIdentification());

                if(length(getIdentification(),10)){
                    System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                }           
            }while(length(getIdentification(),10));
            
            if(!super.searchUserJson(data)){
                System.out.println("Estudiante no encontrado");
            }
        }while(!super.searchUserJson(data));
        
        Student student = new Student();
        
        List<Student> listStudent = readFileJson();
        
        for(Student s: listStudent){
            if(s.getIdentification() == getIdentification()){
                setName(s.getName());
                setLastName(s.getLastName());
                setIdentification(s.getIdentification());
                setPhone(s.getPhone());
                setUserName(s.getUserName());
                setUniversityId(s.getUniversityId());
                break;
            }
        }
        do{
            line();
            System.out.println("Datos actuales del estudiante");
            System.out.println("\nNombre:    " + getName()
                    + "\nApellido:  " + getLastName()
                    + "\nCedula:    " + getIdentification()
                    + "\nTelefono:  " + getPhone()
                    + "\nUsuario:   "  + getUserName() 
                    + "\nID:        " + getUniversityId());
            line();
            System.out.println("Que dato desea modificar");
            System.out.println("\n1. Nombre"
                    + "\n2. Apellido"
                    + "\n3. Telefono"
                    + "\n4. Usuario");
            System.out.println("\n5. Volver ");
            System.out.print("\nElige una opcion: ");
            while(!sc.hasNextInt()){
                System.out.println("Opcion incorrecta");
                line();
                System.out.println("Que dato desea modificar");
                System.out.println("\n1. Nombre"
                    + "\n2. Apellido"
                    + "\n3. Telefono"
                    + "\n4. Usuario");
            System.out.println("\n5. Volver ");
                sc.next();
            }
            id = sc.nextInt();
            switch(id){
                case 1->{
                    do{
                        System.out.print("\nIngrese el nuevo Nombre: ");
                        setName(sc.nextLine());
                        if(!data(getName())){
                            System.out.println("Nombre icorrecto, intetelo de nuevo");
                        }
                        System.out.println(getName());
                    }while(!data(getName()));
                }
                case 2->{
                    do{
                        System.out.print("\nIngrese el nuevo Apellido: ");
                        setLastName(sc.nextLine());
                        if(!data(getLastName())){
                            System.out.println("Apellido incorrecto, intentelo de nuevo");
                        }
                    }while(!data(getLastName()));
                }
                case 3->{
                    do{
                        System.out.println("\nEscribir tu numero apartir del 0");
                        System.out.print("Digite el nuevo numero celular: ");
                        while(!sc.hasNextInt()){
                            System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                             System.out.println("\nEscribir tu numero apartir del 0");
                            System.out.print("Digite el nuevo numero celular: ");
                            sc.nextLine();
                        }
                        setPhone(sc.nextLong());
                        if(length(getPhone(),9) || !String.valueOf(getPhone()).startsWith("9")){
                            System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                        }
                    }while(length(getPhone(),9) || !String.valueOf(getPhone()).startsWith("9"));      
                }
                case 4->{
                    sc.nextLine();
                    do{
                        System.out.print("\nIngrese su usuario: ");
                        setUserName(sc.nextLine());
                        if(getUserName().length() > 12){
                            System.out.println("Usuario no puede superar los 10 caracteres");
                        }
                    }while(getUserName().length() > 12);
                } 
            }
        
            updateDataJson(getIdentification(), updateText(id), id);
        
        }while(id != 5);
       
    }
     
    // Usuario de prueba
    public void studentExampleJson() {
        try (FileReader reader = new FileReader("Estudiante.json")) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            
            if (jsonElement.isJsonArray()) {
                Student[] users = new Gson().fromJson(jsonElement, Student[].class);

                for (int i = 0; i < users.length ; i++) {
                     if (i < 2) {
                    Student user = users[i];
                    System.out.println("\nNombre: " + user.getName());
                    System.out.println("Cedula: " + user.getIdentification());
                     }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    //Eliminar a un estudiante
    public void deleteStudent(){
        
        Scanner sc = new Scanner(System.in);
        String id = "";
        int option = 0;
        do{
            line();
            System.out.println("Usuarios para prueba");
            studentExampleJson();
            line();
            System.out.print("Digite el numero de Cedula: ");
            while(!sc.hasNextLong()){
                System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                System.out.print("\nDigite el numero de Cedula: ");
                sc.next();
            }
            setIdentification(sc.nextLong());
            id = String.valueOf(getIdentification());
            if(!super.searchUserJson(id)){
                System.out.println("Estudiante no encontrado");
            }else{
                
            }
        }while(!super.searchUserJson(id));
        
        List<Student> listStudent = readFileJson();
        
        for(Student s: listStudent){
            if(s.getIdentification() == getIdentification()){
                setName(s.getName());
                setLastName(s.getLastName());
                setIdentification(s.getIdentification());
                setPhone(s.getPhone());
                setUserName(s.getUserName());
                setUniversityId(s.getUniversityId());
                break;
            }
        }
        
        line();
        System.out.println("Datos del estudiante");
        System.out.println("\nNombre:    " + getName()
                + "\nApellido:  " + getLastName()
                + "\nCedula:    " + getIdentification()
                + "\nTelefono:  " + getPhone()
                + "\nUsuario:   "  + getUserName() 
                + "\nID:        " + getUniversityId());
        line();
        System.out.println("1. Eliminar"
                + "\n2. Volver");
        System.out.print("\nElige una opcion: ");
        while(!sc.hasNextInt()){
            System.out.println("Opcion incorrecta");
            line();
            System.out.println("1. Eliminar"
                    + "\n2. Volver");
            System.out.print("\nElige una opcion: ");
            sc.next();
        }
        option = sc.nextInt();
        if(option == 1){
            System.out.println("\nEstudiante eliminado del archivo Json");
            super.deleteDataJson(getIdentification());
        }
    }
    
    public String updateText(int number){
        switch(number){
            case 1->{
                return getName();
            }
            case 2->{
                return getLastName();
            }
            case 3->{
                return String.valueOf(getPhone());
            }
            case 4->{
                return getUserName();
            }   
        }
        return null;
    }
    
    //Verificar el ingreso de letras A - Z y espacios
    @Override
    public boolean data(String data){
        return Pattern.matches("[a-zA-z. ]+", data);
    }
    
    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
    
    
}
