
package Empleados;

import java.util.Scanner;

public class EmpleadoAgricola extends Empleados {
    String tipoSiembra;
    String nombreSemillas;
    int cantCacaoRecolect;
    int cantNaranjasRecolect;
    double precioNaranjasCultivadas = 0.25;
    double precioCacaoCultivado = 2.00;

    public EmpleadoAgricola(String tipoSiembra, String nombreSemillas, int cantCacaoRecolect, int cantNaranjasRecolect, String nombreEmpleado, long cedula, int nCelular, int edad, double Salario) {
        super(nombreEmpleado, cedula, nCelular, edad, Salario);
        this.tipoSiembra = tipoSiembra;
        this.nombreSemillas = nombreSemillas;
        this.cantCacaoRecolect = cantCacaoRecolect;
        this.cantNaranjasRecolect = cantNaranjasRecolect;
    }
    
    /*public double calcularPago() {
        double salarioTotal = 0;

        if (HorasExtras >= 1 && HorasExtras <= 4) {
            salarioTotal += (salarioTotal * 0.10);// Aumento del 10% al salario de 1 a 4 horas extras
        } else if (HorasExtras > 4 && HorasExtras <= 8) {
            salarioTotal += (salarioTotal * 0.15);// Aumento del 15% al salario de 4 a 8 horas extras
        }
        salarioTotal += HorasExtras * Salario;
        System.out.println("Salario: " + salarioTotal);

        return salarioTotal;
    }*/


    public void MostrarInformacionEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el Tipo de siembra que va a realizar: ");
        setTipoSiembra(sc.nextLine());

        System.out.print("Ingrese el nombre de la semilla: ");
        setNombreSemillas(sc.nextLine());

        System.out.print("Ingrese la cantidad de cacao Recolectado: ");
        setCantCacaoRecolect(sc.nextInt());

        System.out.print("Ingrese la cantidad de Naranjas recolectadas: ");
        setCantNaranjasRecolect(sc.nextInt());

        System.out.println("======== INFORMACION ADICIONAL DEL EMPLEADO AGRICOLA =======");
        System.out.println("Tipo de Siembra: " + getTipoSiembra());
        System.out.println("Nombre de las Semillas: " + getNombreSemillas());
        System.out.println("Cantidad de Cacao Recolectado: " + getCantCacaoRecolect() + " unidades");
        System.out.println("Cantidad de Naranjas Recolectadas: " + getCantNaranjasRecolect() + " unidades");
        System.out.println("Precio de Naranjas Cultivadas: $" + precioNaranjasCultivadas + " por unidad");
        System.out.println("Precio de Cacao Cultivado: $" + precioCacaoCultivado + " por saco");

        sc.close();
    }

    public String getTipoSiembra() {
        return tipoSiembra;
    }

    public void setTipoSiembra(String tipoSiembra) {
        this.tipoSiembra = tipoSiembra;
    }

    public String getNombreSemillas() {
        return nombreSemillas;
    }

    public void setNombreSemillas(String nombreSemillas) {
        this.nombreSemillas = nombreSemillas;
    }

    public int getCantCacaoRecolect() {
        return cantCacaoRecolect;
    }

    public void setCantCacaoRecolect(int cantCacaoRecolect) {
        this.cantCacaoRecolect = cantCacaoRecolect;
    }

    public int getCantNaranjasRecolect() {
        return cantNaranjasRecolect;
    }

    public void setCantNaranjasRecolect(int cantNaranjasRecolect) {
        this.cantNaranjasRecolect = cantNaranjasRecolect;
    }

    public void RealizarSiembra() {
        System.out.println("Sembrando...");
    }

    public void CultivarCacao() {
        System.out.println("Cultivado Cacao...");
    }

    public void CultivarNaranjas() {
        System.out.println("Cultivado Naranjas...");
    }

    public double VenderCacao() {
        Scanner scanner = new Scanner(System.in);
        int SacosCacao;
        do {
            System.out.println("Ingrese cuantos Sacos de cacao desea comprar: ");
            SacosCacao = scanner.nextInt();
            ;

            if (SacosCacao < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (SacosCacao < 0);

        double CostoCacao = SacosCacao * precioCacaoCultivado;
        System.out.println("El valor a pagar por los " + SacosCacao + " sacos de cacao es de $" + CostoCacao);
        return CostoCacao;
    }

    public double VenderNaranjas() {
        Scanner scanner = new Scanner(System.in);
        int Naranjas;
        do {
            System.out.println("Ingrese cuantas naranjas desea Comprar: ");
            Naranjas = scanner.nextInt();
            ;

            if (Naranjas < 0) {
                System.out.println("Error: La cantidad no puede ser negativa. Intente nuevamente.");
            }
        } while (Naranjas < 0);

        double CostoNaranjas = Naranjas * precioNaranjasCultivadas;
        System.out.println("El valor a pagar por las " + Naranjas + " es de leche es de $" + CostoNaranjas);
        return CostoNaranjas;
    }

}
