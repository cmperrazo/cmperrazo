
package Empleados;

import java.util.Scanner;

public class EmpleadoAgricola extends Empleados {
    
    //Atributos
    String tipoInsecticida;
    int nCosecha;

    public EmpleadoAgricola(String tipoInsecticida, int nCosecha, String nombreEmpleado, Long cedula, int nCelular, int edad, double Salario) {
        super(nombreEmpleado, cedula, nCelular, edad, Salario);
        this.tipoInsecticida = tipoInsecticida;
        this.nCosecha = nCosecha;
    }

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

    public String fumigar(){
        return "El " + getNombreEmpleado() + "Fumiga los dias martes con " + getTipoInsecticida();
    }
    
    public double venderCacao(){
       Scanner scanner = new Scanner(System.in);
       
        int SacosCacao;
        do {
            System.out.println("Ingrese cuantos Sacos de cacao desea vender: ");
            SacosCacao = scanner.nextInt();;

            if (SacosCacao < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (SacosCacao < 0);
        
        double CostoCacao = SacosCacao * 2.50;
        System.out.println("El valor a pagar por los "+SacosCacao+" sacos de cacao es de $"+CostoCacao);
        
        return CostoCacao;
   }
    
   public double venderNaranjas(){
       Scanner scanner = new Scanner(System.in);
        int Naranjas;
        do {
            System.out.println("Ingrese cuantas naranjas desea Comprar: ");
            Naranjas = scanner.nextInt();;

            if (Naranjas < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (Naranjas < 0);
        
        double CostoNaranjas = Naranjas * 0.25;
        System.out.println("El valor a pagar por las "+Naranjas+" es de leche es de $"+CostoNaranjas);
        return CostoNaranjas;
   }
   
   
   public double gananciasAgricola() {
        double gananciasNaranjas = venderNaranjas();
        double gananciasCacao = venderCacao();
        double gananciasTotales = gananciasNaranjas + gananciasCacao;

        System.out.println("Ganancias totales de la venta del empleado agricola: $" + gananciasTotales);

        return gananciasTotales;
    }
   
    @Override
   public void mostrarInformacion(){
       super.mostrarInformacion();
       fumigar();
       
   }
    
    public String getTipoInsecticida() {
        return tipoInsecticida;
    }

    public void setTipoInsectisida(String tipoInsectisida) {
        this.tipoInsecticida = tipoInsectisida;
    }

    public int getnCosecha() {
        return nCosecha;
    }

    public void setnCosecha(int nCosecha) {
        this.nCosecha = nCosecha;
    }

    

}
