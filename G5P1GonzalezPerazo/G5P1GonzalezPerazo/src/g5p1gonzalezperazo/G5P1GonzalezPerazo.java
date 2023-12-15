
package g5p1gonzalezperazo;

import Empleados.EmpleadoAgricola;
import Empleados.EmpleadoGanadero;
import Empleados.Empleados;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class G5P1GonzalezPerazo {

    public static int nOpc = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        boolean salir = false;
        caratula();
        linea();
        do {
            linea();
            menu();
            while (!scanner.hasNextInt()) {
                System.out.println("Opcion incorrecta, vuelva a intentarlo");
                scanner.next();
                linea();
                menu();

            }
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    registroEmpleado(scanner);
                    break; 
                case 2:
                    pagoEmpleados(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    linea();
                    System.out.println("Vuelve pronto\n");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentar");
                    break;
            }
        } while (!salir);

        scanner.close();

    }

    public static void linea() {
        System.out.println("\n----------------------------------------------------------\n");
    }

    public static void caratula() {

        System.out.println("\nUniversidas de la Fuerzas Armadas Espe" +
                "\nIntegrantes: Dayanara" +
                "\n             Jilmar Gonzalez" +
                "\n             Camila" +
                "\nFecha:       28/11/2023");
    }

    public static void menu() {
        System.out.println("---------Hacienda-------\n" +
                "\n1.Registro de nuevos empleados" +
                "\n2.Datos de empleados" +
                "\n3.Pago de empleados" + 
                "\n4.Clientes registrados" +
                "\n5.Salir" +
                "\nElige una opcion: ");

    }
    
    public static void menuSalir(Scanner scanner){         
        do{ 
            System.out.println("Menu");
            System.out.println("\n1. Realizar nuevo registro" + 
                    "\n2. Regresar al menu" + 
                    "\n3. Salir");
            while(!scanner.hasNextInt()){
                System.out.println("Opcion incorrecta");
                System.out.println("Menu");
                System.out.println("\n1. Realizar nuevo pago" + 
                        "\n2. Regresar al menu" + 
                        "\n3. Salir");
                scanner.next();
            }
            nOpc = scanner.nextInt();

        }while(nOpc < 1 || nOpc > 3);
          
    }
    
    public static void registroEmpleado(Scanner scanner){       
        String nombre = "";
        long cedula = 0;
        int nCelular = 0;
        int  edad = 20;
        double salario = 400;
        
        do {
            System.out.println("Registro Empleado");
            System.out.print("Nombres: ");
            nombre = scanner.next();

            //Validar numero de cedula
            do{
                System.out.print("Numero de cedula: ");
                while(!scanner.hasNextLong()){
                    System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                    System.out.print("Numero de cedula: ");
                    scanner.next();
                }
                cedula = scanner.nextLong();
                if(String.valueOf(cedula).length() != 10){
                    System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                }

            }while(String.valueOf(cedula).length() != 10);
            
            //Numero de telefono
            do{
                System.out.println("Escribir tu numero apartir del 0");
                System.out.print("Numero de celular: ");
                while(!scanner.hasNextInt()){
                    System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                     System.out.println("Escribir tu numero apartir del 0");
                    System.out.print("Numero de celular: ");
                    scanner.next();
                }
                nCelular = scanner.nextInt();
                if(String.valueOf(nCelular).length() != 9 || !String.valueOf(nCelular).startsWith("9")){
                    System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                }

            }while(String.valueOf(nCelular).length() != 9 || !String.valueOf(nCelular).startsWith("9"));

            //Validar edad aducuada de los empleados
            do{
                System.out.print("Edad: ");
                while(!scanner.hasNextInt()){
                    System.out.println("Edad incorrecta, vuelva a intentarlo");
                    System.out.print("Edad: ");
                    scanner.next();
                }
                edad = scanner.nextInt();
                if(edad < 18 || edad > 65){
                    System.out.println("Las personas menore de 18 anios y los mayores de" +
                            "\n65 anos no se pueden registrar");
                    break;
                }

            }while(edad < 18 || edad > 65);

            //Validar salario
            do{
                System.out.print("Salario del empleado: ");
                while(!scanner.hasNextInt()){
                    System.out.println("Digite solo numeros, vuleva a intentarlo");
                    System.out.print("Salario del empleado: ");
                    scanner.next();
                }
                salario = scanner.nextInt();
                if(salario < 400){
                    System.out.println("El salrio minimo es 400, vuelva a intentarlo");
                }

            }while(salario < 400);
            
            Empleados empleados = new Empleados(nombre,cedula,nCelular,edad,salario);
            empleados.informacionEmpleado();
            guardarEnArchivo(empleados);

            //Menu para salirc
            menuSalir(scanner);
            if(nOpc == 2){
                break;
            }
            if(nOpc == 3){
                System.out.println("Vuelve pronto\n");
                System.exit(0);
            }

        } while (nOpc == 1);
    }

    public static void pagoEmpleados(Scanner scanner){
        int oEmp = 0;
        do{ 
            System.out.println("Tipo de empleado\n" + 
                    "\n1.Pago Empleado Ganadero" +
                    "\n2.Pago Empleado Agricola");
            System.out.print("\nElige una opcion: ");
            while(!scanner.hasNextInt()){
                System.out.println("Opcion incorrecta, intentelo de nuevo");
                System.out.println("\n1.Pago Empleado agricola" +
                    "\n2.Pago Empleado Ganadero");
                System.out.print("\nElige una opcion: ");
                scanner.next();
            }
            oEmp = scanner.nextInt();
            if(oEmp < 1 || oEmp > 2){
                System.out.println("Opcion incorrecta, intentelo de nuevo");
            }
        }while(oEmp < 1 || oEmp > 2);
        
        if(oEmp == 1){
            //EmpleadoGanadero eAgricola = new EmpleadoGanadero("Vacuno",nombre,cedula,nCelular,edad,salario);
        }else if(oEmp == 1){
            
        }
    }
    
    //Escribir en fichero
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
    
}
