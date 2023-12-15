
package University;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Teacher extends Person{
    private String departament;
    private String academicTitle;

    public Teacher(String departament, String academicTitle, long identification, String name, String lastName, int studentId, long phone, String address, String userName) {
        super(identification, name, lastName, studentId, phone, address, userName);
        this.departament = departament;
        this.academicTitle = academicTitle;
    }

    public Teacher() {
    }
    
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
        
        Teacher teacher = new Teacher(departament,academicTitle, getIdentification(), getName(), getLastName(), getStudentId(), getPhone(), getAddress(), getUserName());
    
        createFileCsv(teacher);
        
        System.out.println("\nDocente registrado");
        
    }
    
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
                    String.valueOf(teacher.getStudentId()),
                    String.valueOf(teacher.getIdentification()),
                    teacher.getName(),
                    teacher.getLastName(),
                    String.valueOf(teacher.getPhone()),
                    teacher.getAddress(),
                    teacher.getDepartament(),
                    teacher.getAcademicTitle()
            });
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void getInformationTeacher(String file) throws IOException{
        do{
            super.loginUniversity();
            if(!searchDataCsv(file,getUserName(), getStudentId())){
                System.out.println("Docente no registrado");
            }   
        }while(!searchDataCsv(file,getUserName(), getStudentId()));
        
        super.getInformation();
    }
    
    private boolean searchDataCsv(String file, String nameUser, int idUser) {
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
                    System.out.println("No se pudo realizar la busqueda, verifique el fichero");
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
    
    public void deleteStudent(){
        
    }

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
