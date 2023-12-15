
package Empleados;

import java.util.Scanner;

public class EmpleadoGanadero extends Empleados{
    
    //ATRIBUTOS PROPIOS
    String tipoGanado;
    int animalesAcargo;
    
    //CONSTRUCTOR

    public EmpleadoGanadero(String tipoGanado, int animalesAcargo, String nombreEmpleado, Long cedula, int nCelular, int edad, double Salario) {
        super(nombreEmpleado, cedula, nCelular, edad, Salario);
        this.tipoGanado = tipoGanado;
        this.animalesAcargo = animalesAcargo;
    }
    
    //Sobreescritura del metodo CalcularPago para calcular el pago del Empleado Ganadero
    
    @Override
    public double calcularPago(){
        Scanner sc = new Scanner (System.in);
        double NuevoSalario=0;
        double Aumento=0;
        int HorasExtras = 0;
        do{
                System.out.print("Salario del empleado: ");
                while(!sc.hasNextInt()){
                    System.out.println("Digite solo numeros, vuelva a intentarlo");
                    System.out.println("Salario del empleado: ");
                    sc.next();
                }
                Salario = sc.nextInt();
                if(Salario < 400){
                    System.out.println("El salrio minimo es 400, vuelva a intentarlo");
                }

            }while(Salario < 400);
        
        System.out.print("Ingrese las Horas Extras de trabajo: ");
        HorasExtras = sc.nextInt();
         if (HorasExtras >= 1 && HorasExtras <= 4) {
             Aumento = Salario *0.10;//Aumento del 10% al salario de 1 a 4 horas extras
        } else if (HorasExtras > 4 && HorasExtras <= 8) {
             Aumento = Salario *0.15;//Aumento del 15% al salario de 4 a 8 horas extras
        }
        NuevoSalario =Salario+Aumento;
        System.out.println("Salario del empleado Agricola: "+NuevoSalario);

        return NuevoSalario;
    }
    
    public double gananciasGanadero() {
        double gananciasLeche = venderLeche();
        double gananciasHuevos = venderHuevos();
        double gananciasTotales = gananciasLeche + gananciasHuevos;

        System.out.println("Ganancias totales de la venta del empleado ganadero: $" + gananciasTotales);

        return gananciasTotales;
    }
    
    @Override
     public void mostrarInformacion(){
       super.mostrarInformacion();
       AlimentarGanado();
       encubetarHuevos();
     }
    
    public void AlimentarGanado(){
        System.out.println("El Ganadero"+nombreEmpleado+" esta alimentando al ganado "+ tipoGanado);
    }
    
    public void encubetarHuevos() {
        System.out.println("El ganader" + nombreEmpleado + " esta encubetando huevos");
       
    }
    public double venderLeche() {
        Scanner scanner = new Scanner(System.in);
        int LitrosLeche;
        do {
            System.out.println("Ingrese cuantos Litros de Leche desea vender: ");
            LitrosLeche = scanner.nextInt();;

            if (LitrosLeche < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (LitrosLeche < 0);
        
        double CostoLeche = LitrosLeche * 0.50;
        System.out.println("El valor a pagar por los "+LitrosLeche+"L de leche es de $"+CostoLeche);
       
        return CostoLeche;
    }
    
    // Método para vender huevos
    public double venderHuevos() {
        Scanner scanner = new Scanner(System.in);
        int cantidadCubetas;
        double precioCubetas;
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
            precioCubetas = scanner.nextDouble();

            if (precioCubetas < 0) {
                System.out.println("Error: El precio no puede ser negativo. Intente nuevamente.");
            }
        } while (precioCubetas < 0);
        
        double costoTotalCubetas = cantidadCubetas * precioCubetas;
        System.out.println("El valor a pagar por las "+cantidadCubetas+" es de $"+costoTotalCubetas);
        return costoTotalCubetas;
    }
   
    public String getTipoGanado() {
        return tipoGanado;
    }

    public void setTipoGanado(String tipoGanado) {
        this.tipoGanado = tipoGanado;
    }

    public int getAnimalesAcargo() {
        return animalesAcargo;
    }

    public void setAnimalesAcargo(int animalesAcargo) {
        this.animalesAcargo = animalesAcargo;
    }
    
    
   
}
