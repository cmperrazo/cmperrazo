package Empleados;

import java.util.Scanner;

public class Empleados {
    
    //Atributos comunes
    public String nombreEmpleado;
    private Long cedula;
    private int nCelular;
    private int edad;
    protected double Salario = 400;
    
    //Constructor vacio
    public Empleados() {
    }
    
    //Contructor 
    public Empleados(String nombreEmpleado, Long cedula, int nCelular, int edad, double Salario) {
        this.nombreEmpleado = nombreEmpleado;
        this.cedula = cedula;
        this.nCelular = nCelular;
        this.edad = edad;
        this.Salario = Salario;
    }
    
    // Método para calcular el pago del empleado
    public double calcularPago(){
        return Salario;
    }
    
    
    // Método para registrar información del empleado
    public void RegistrarInformacionEmpleado() {
        Scanner sc = new Scanner (System.in);
        System.out.println("================== REGISTRO EMPLEADOS =====================");
        System.out.print("\nNombre: ");
        setNombreEmpleado(sc.nextLine());
        //Numero de Cedula 
        do{
                System.out.print("Cedula: ");
                while(!sc.hasNextLong()){
                    System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                    System.out.println("Numero de cedula: ");
                    sc.next();
                }
                cedula = sc.nextLong();
                if(String.valueOf(cedula).length() != 10){
                    System.out.println("Numero de cedula incorrecto, intentelo de nuevo");
                }

            }while(String.valueOf(cedula).length() != 10);
        
        //Numero de telefono
            do{
                System.out.println("Escribir tu numero apartir del 0");
                System.out.print("Numero de celular: ");
                while(!sc.hasNextInt()){
                    System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                     System.out.println("Escribir tu numero apartir del 0");
                    System.out.print("Numero de celular: ");
                    sc.next();
                }
                nCelular = sc.nextInt();
                if(String.valueOf(nCelular).length() != 9 || !String.valueOf(nCelular).startsWith("9")){
                    System.out.println("Numero de celular incorrecto, intentelo de nuevo");
                }

            }while(String.valueOf(nCelular).length() != 9 || !String.valueOf(nCelular).startsWith("9"));
        //Edad
            do{
                System.out.print("Edad: ");
                while(!sc.hasNextInt()){
                    System.out.println("Edad incorrecta, vuelva a intentarlo");
                    System.out.println("Edad: ");
                    sc.next();
                }
                edad = sc.nextInt();
                if(edad < 18 || edad > 65){
                    System.out.println("Las personas menore de 18 anios y los mayores de" +
                            "\n65 anos no se pueden registrar");
                    break;
                }

            }while(edad < 18 || edad > 65);
        //Salario
        do{
                System.out.print("Salario del empleado: ");
                while(!sc.hasNextInt()){
                    System.out.println("Digite solo numeros, vuleva a intentarlo");
                    System.out.println("Salario del empleado: ");
                    sc.next();
                }
                Salario = sc.nextInt();
                if(Salario < 400){
                    System.out.println("El salrio minimo es 400, vuelva a intentarlo");
                }

            }while(Salario < 400);
        
            System.out.println("\nRegistro de empleado completo");
        
    }
    

    public void mostrarInformacion(){
        System.out.println("\n======== INFORMACION DEL EMPLEADO =======");
        System.out.println("Nombre: " + getNombreEmpleado());
        System.out.println("Cedula: "+ getCedula());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Salario: $" + getSalario());
    }
    
    //Metodos getter and setter
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public int getnCelular() {
        return nCelular;
    }

    public void setnCelular(int nCelular) {
        this.nCelular = nCelular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
}