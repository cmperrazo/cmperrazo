
package Empleados;

import java.util.Scanner;

public class EmpleadoGanadero extends Empleados{
    
    //ATRIBUTOS PROPIOS
    String tipoGanado;
    /*String tipoAlimentos;
    String cantLecheRecogida;
    int cantEggsRecogidos;
    double PrecioCubetas;
    double PrecioLecheRecogida= 2.50;*/
    
    //CONSTRUCTOR

    /*public EmpleadoGanadero(String tipoAlimentos, String tipoGanado, String cantLecheRecogida, int cantEggsRecogidos, double PrecioCubetas, double PrecioLecheRecogida, String nombreEmpleado, long cedula, int nCelular, int edad, int HorasExtras, double Salario) {
        super(nombreEmpleado, cedula, nCelular, edad, Salario);
        this.tipoAlimentos = tipoAlimentos;
        this.tipoGanado = tipoGanado;
        this.cantLecheRecogida = cantLecheRecogida;
        this.cantEggsRecogidos = cantEggsRecogidos;
        this.PrecioCubetas = PrecioCubetas;
        this.PrecioLecheRecogida = PrecioLecheRecogida;
    }*/

    public EmpleadoGanadero(String tipoGanado, String nombreEmpleado, long cedula, int nCelular, int edad, double Salario) {
        super(nombreEmpleado, cedula, nCelular, edad, Salario);
        this.tipoGanado = tipoGanado;
    }
    
    
    //Sobreescritura del metodo CalcularPago para calcular el pago del Empleado Ganadero
    
    public double calcularPago(){
         double salarioTotal = getSalario();

         /*if (HorasExtras >= 1 && HorasExtras <= 4) {
            salarioTotal += (salarioTotal * 0.10);//Aumento del 10% al salario de 1 a 4 horas extras
        } else if (HorasExtras > 4 && HorasExtras <= 8) {
            salarioTotal += (salarioTotal * 0.15);//Aumento del 15% al salario de 4 a 8 horas extras
        }
        salarioTotal += HorasExtras * Salario;
        System.out.println("Salario: "+salarioTotal);

        */return salarioTotal;
    }
    
        public void informacionEmpleadoGanadero() {
            super.informacionEmpleado();
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tipo de Alimentos que usa para el Ganado: ");
        setTipoAlimentos(sc.nextLine());
        
        System.out.print("Ingrese el Tipo de Ganado que cuida: ");
        setTipoGanado(sc.nextLine());        
        
        System.out.print("Ingrese los Litros de leche que recolecta en la mañana: ");
        setCantLecheRecogida(sc.nextLine());
        
        System.out.print("Ingrese la cantidad de Huevos Recogidos: ");
        setCantEggsRecogidos(sc.nextInt());  
        
        System.out.print("Ingrese el precio de la cubeta de Huevos: ");
        setPrecioCubetas(sc.nextDouble());  */
        
        System.out.println("======== INFORMACION ADICIONAL DEL EMPLEADO GANADERO =======");
        //System.out.println("Tipo de Alimentos: " + getTipoAlimentos());
        System.out.println("Tipo de Ganado: "+ getTipoGanado());
        /*System.out.println("Cantidad de Leche Recogida: " + getCantLecheRecogida() + " años");
        System.out.println("Cantidad de Huevos Recogidos: " + getCantEggsRecogidos() + " años");
        System.out.println("Precio de Cubetas de Huevo: $" + PrecioCubetas);
        System.out.println("Precio de Leche: $" + PrecioLecheRecogida);*/

   }

    public String getTipoGanado() {
        return tipoGanado;
    }

    public void setTipoGanado(String tipoGanado) {
        this.tipoGanado = tipoGanado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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

    /*public void AlimentarGanado(){
        System.out.println("El Ganadero"+nombreEmpleado+" esta alimentando al Ganado con "+tipoAlimentos);
    }
    public void ordeñarVacas() {
        System.out.println("Ordeñando vacas...");
    }
    public void encubetarHuevos() {
        System.out.println("Encubetando huevos...");
       
    }
    public double venderLeche() {
        Scanner scanner = new Scanner(System.in);
        int LitrosLeche;
        do {
            System.out.println("Ingrese cuantos Litros de Leche desea Comprar: ");
            LitrosLeche = scanner.nextInt();;

            if (LitrosLeche < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (LitrosLeche < 0);
        
        double CostoLeche = LitrosLeche * PrecioLecheRecogida;
        System.out.println("El valor a pagar por los "+LitrosLeche+"L de leche es de $"+CostoLeche);
       
        return CostoLeche;
    }
    // Método para vender huevos
    public double venderHuevos() {
        Scanner scanner = new Scanner(System.in);
        int cantidadCubetas;
        //Validacion Cantidad de Cubetas de Huevo
        do {
            System.out.println("Ingrese la cantidad de cubetas que desea comprar:");
            cantidadCubetas = scanner.nextInt();;

            if (cantidadCubetas < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (cantidadCubetas < 0);

        // Validación del precio por cubeta
        do {
            System.out.println("Ingrese el precio por cubeta de huevos:");
            PrecioCubetas = scanner.nextDouble();

            if (PrecioCubetas < 0) {
                System.out.println("Error: El precio no puede ser negativo. Intente nuevamente.");
            }
        } while (PrecioCubetas < 0);
        
        double costoTotalCubetas = cantidadCubetas * PrecioCubetas;
        System.out.println("El valor a pagar por las "+cantidadCubetas+" es de $"+costoTotalCubetas);
        return costoTotalCubetas;
    }*/
   
}
