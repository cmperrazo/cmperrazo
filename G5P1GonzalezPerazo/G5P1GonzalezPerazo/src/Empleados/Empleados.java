
package Empleados;

public class Empleados {
 
    // Atributos
    String nombreEmpleado;
    private long cedula;
    public int nCelular;
    int edad;
    double Salario = 400;

    // Constructor
    public Empleados(String nombreEmpleado, long cedula, int nCelular, int edad, double Salario) {
        this.nombreEmpleado = nombreEmpleado;
        this.cedula = cedula;
        this.nCelular = nCelular;
        this.edad = edad;
        this.Salario = Salario;
    }

    public void informacionEmpleado() {
        System.out.println("======== INFORMACION DEL EMPLEADO GANADERO =======\n");
        System.out.println("Nombre:     " + getNombreEmpleado());
        System.out.println("Cedula:     " + getCedula());
        System.out.println("N. Celular: " + "0"+ getnCelular());
        System.out.println("Edad:       " + getEdad() + " anios");
        //System.out.println("Horas Extra: " + getHorasExtras() + " años");
        System.out.println("Salario:    $" + getSalario());

        
    }
   

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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
