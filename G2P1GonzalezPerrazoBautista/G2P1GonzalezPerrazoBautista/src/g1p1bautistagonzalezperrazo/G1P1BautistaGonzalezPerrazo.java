
package g1p1bautistagonzalezperrazo;

import Empleados.EmpleadoAgricola;
import Empleados.EmpleadoGanadero;
import Empleados.Empleados;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;



public class G1P1BautistaGonzalezPerrazo {

    public static int nOpc = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        boolean salir = false;
        linea();
        leerArchivoTxt();
        //caratula();
        do {
            linea();
            menuArrays();
            while (!scanner.hasNextInt()) {
                System.out.println("Opcion incorrecta, vuelva a intentarlo");
                scanner.next();
                linea();
                menuArrays();

            }
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    Empleados empleado = new Empleados("",0L,0,0,0.0);
                    empleado.RegistrarInformacionEmpleado();
                    guardarEnArchivo(empleado);
                    escribirArchivoJson(empleado);
                    //registroEmpleado(scanner);
                    break; 
                case 2:
                    diagnostico();
                    break;
                case 4:
                    leerArchivoTxt();
                    break;
                case 5:
                    leerJson();
                    break;
                case 6:
                    do{ 
                        System.out.println("\nMenu");
                        System.out.println("\n1. Metodos Empleado Ganadero" + 
                                "\n2. Metodos Empleado Agricola");
                        while(!scanner.hasNextInt()){
                            System.out.println("Opcion incorrecta");
                            System.out.println("\nMenu");
                        System.out.println("\n1. Metodos Empleado Ganadero" + 
                                "\n2. Metodos Empleado Agricola");
                            scanner.next();
                        }
                        nOpc = scanner.nextInt();

                    }while(nOpc < 1 || nOpc > 2);
                    
                    if(nOpc == 1){
                        EmpleadoGanadero gan = new EmpleadoGanadero("",0,"",0L,0,0,0.0);
                        linea();
                        gan.AlimentarGanado();
                        linea();
                        gan.calcularPago();
                        linea();
                        gan.gananciasGanadero();
                        linea();
                        gan.venderHuevos();
                        linea();
                        gan.venderLeche();
                     
                        
                    }else if(nOpc == 2){
                        EmpleadoAgricola agri = new EmpleadoAgricola("",0,"",0L,0,0,0.0);
                        linea();
                        agri.calcularPago();
                        linea();
                        agri.venderNaranjas();
                        linea();
                        agri.venderCacao();
                        linea();
                        agri.mostrarInformacion();
                        linea();
                        agri.gananciasAgricola();
                    }
                    break;
                case 7:
                    linea();
                    System.out.println("Vuelve pronto\n");
                    salir = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentar");
                    break;
            }
            
            menuSalir(scanner);
            
            if(nOpc == 2){
                System.out.println("\nVuelva pronto");
                System.exit(0);
            }
            
        } while (!salir);

        scanner.close();

    }

    public static void linea() {
        System.out.println("\n----------------------------------------------------------\n");
    }

    //Arrays tipo primitivo
    public static void menuArrays(){
        
        List<String> munu = new ArrayList<String>();
        
        munu.add("---------Hacienda Santa Maria-------\n");
        munu.add("\n1.Registro de nuevos empleados");
        munu.add("\n2.Diagnostico animal");
        munu.add("\n3.Pago de empleados");
        munu.add("\n4.Empleados registrados");
        munu.add("\n5.Leer archivo Json");
        munu.add("\n6.Ver metodos");
        munu.add("\n7.Salir");
        munu.add("\nElige una opcion: ");
      
        for(int i=0; i<9; i++){
            System.out.print(munu.get(i));
        }
        
    }
    
    public static void menuSalir(Scanner scanner){         
        do{ 
            System.out.println("\nMenu");
            System.out.println("\n1. Regresar al menu" + 
                    "\n2. Salir");
            while(!scanner.hasNextInt()){
                System.out.println("Opcion incorrecta");
                System.out.println("Menu");
            System.out.println("\n1. Regresar al menu" + 
                    "\n2. Salir");
                scanner.next();
            }
            nOpc = scanner.nextInt();

        }while(nOpc < 1 || nOpc > 2);
          
    }
    
    //Escribir en fichero tipo .txt
    private static void guardarEnArchivo(Empleados empleado) {
         
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Empleados.txt", true))) {
            writer.write("Nombre: " + empleado.getNombreEmpleado() + "\n");
            writer.write("Cedula: " + empleado.getCedula() + "\n");
            writer.write("Numero de Celular: " + empleado.getnCelular() + "\n");
            writer.write("Edad: " + empleado.getEdad() + "\n");
            writer.write("Salario: " + empleado.getSalario() + "\n");
            writer.write("-------------------------------------\n");
            System.out.println("Datos guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
 
    //Lectura de fichero de tipo .txt
    public static String leerArchivoTxt(){
        
        String texto = "";
       
        try {
            BufferedReader bf = new BufferedReader (new FileReader ("Caratula.txt"));
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }  
        }catch (IOException e){
            System.err.println("No se encontro el archivo");
        }
        return texto;
       
    }

    //Escritura en un fichero tipo .json
    public static void escribirArchivoJson(Empleados empleado) throws IOException {
        
        try (JsonWriter writer = new JsonWriter(new FileWriter("Trabajadores.json", true))) {
            writer.setIndent("   ");
            Gson jsonString = new GsonBuilder().setPrettyPrinting().create();
            jsonString.toJson(empleado, Empleados.class, writer);          
        }
    }
    
    //Leer un fichero tipo .json
    public static void leerJson() throws FileNotFoundException, IOException{
        File archivo = new File("Trabajadores.json");
        if(archivo.exists()){
            StringBuilder stringBuilder;
            try (BufferedReader reader = new BufferedReader(new FileReader("Trabajadores.json"))) {
                stringBuilder = new StringBuilder();
                String line;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                    System.out.println(line);
                }
            }
        }
    }
    
    //Arrays con Objetos
    public static void diagnostico(){
        
        linea();
        System.out.println("Datos de los Profecionales adignados a cada tipo de animal");
        linea();
        List<Veterinario> veterinario = new ArrayList<Veterinario>();
        
        veterinario.add(new Veterinario("Carlos Veloz","2350093067", "36","Antibioticos","Caprinos","estrenimineto"));
        veterinario.add(new Veterinario("Camila Perez","2350056067", "21","Oxitocina","Ovino","Fiebre"));
        veterinario.add(new Veterinario("Jose Peralte","1323003067", "45","Edo Atripan","Aves de corral","Hemoparasitos"));
        veterinario.add(new Veterinario("Lizeth Rossel","4545009306745", "26","Nuban","Bovino","Antiparsitario"));
       
        
        ExportarCSV(veterinario);
        ImportarCSV();
    }
    
    //Fichero de tipo .csv Escritura
    public static void ExportarCSV(List<Veterinario> veterinario) {
        String salidaArchivo = "Diagnostico.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
        
        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoDiagnostico = new File(salidaArchivo);
            archivoDiagnostico.delete();
        }
        
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Cedula");
            salidaCSV.write("Edad");
            salidaCSV.write("Medicamento");
            salidaCSV.write("TipoAnimal");
            salidaCSV.write("Diagnostico");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
            for(Veterinario user : veterinario) {
                salidaCSV.write(user.getNombre());
                salidaCSV.write(user.getCedula());
                salidaCSV.write(user.getEdad());
                salidaCSV.write(user.getMedicamento());
                salidaCSV.write(user.getTipoAnimalAtendido());
                salidaCSV.write(user.getDiagnosticoAnimal());
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }
    
    //Fichero de tipo .csv lectura
    public static void ImportarCSV() {
        try{
            List<Veterinario> veterinario = new ArrayList<Veterinario>(); // Lista donde guardaremos los datos del archivo
            
            CsvReader leerDiagnostico = new CsvReader("Diagnostico.csv");
            leerDiagnostico.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerDiagnostico.readRecord()) {
                String nombre = leerDiagnostico.get(0);
                String cedula = leerDiagnostico.get(1);
                String edad = String.valueOf(leerDiagnostico.get(2));
                String medicamento = leerDiagnostico.get(3);
                String tipoAnimalAtendido = leerDiagnostico.get(4);
                String DiagnosticoAnimal = String.valueOf(leerDiagnostico.get(5));
                
                
                veterinario.add(new Veterinario(nombre,cedula, edad, medicamento, tipoAnimalAtendido, DiagnosticoAnimal )); // Añade la informacion a la lista
            }
            
            leerDiagnostico.close(); // Cierra el archivo
            
            // Recorremos la lista y la mostramos en la pantalla
            for(Veterinario user : veterinario) {
                System.out.println(user.getNombre() + " , "
                    + user.getCedula() + " , "
                    +user.getEdad() +" , "
                + user.getMedicamento()+" , "
                + user.getTipoAnimalAtendido()+" , "
                +user.getDiagnosticoAnimal()+ " , ");
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}

