/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7_u2_perrazocamila;


public class Lab7_U2_PerrazoCamila {

    
    public static void main(String[] args) {
        //Instanciamos las clases
        Vehiculo veh = new Vehiculo();
        Automovil auto = new Automovil();
        Motocicleta moto = new Motocicleta();
        
        Vehiculo veh1 = new Vehiculo();
        Automovil auto1 = new Automovil();
        Motocicleta moto1 = new Motocicleta();
        //llamamos a los metodos
        veh.encendido();
        auto.encendido();
        moto.encendido();
        
        veh1.apagado();
        auto1.apagado();
        moto1.apagado();
        
        //imprimir estado del vehiculo segun los metodos 
        System.out.println("Vehiculo 1");
        System.out.println(veh.estado);
        System.out.println(auto.estado);
        System.out.println(moto.estado);
        
        System.out.println("Vehiculo 2");
        System.out.println(veh1.estado);
        System.out.println(moto1.estado);
        System.out.println(auto1.estado);
        
        
    }
    
}
