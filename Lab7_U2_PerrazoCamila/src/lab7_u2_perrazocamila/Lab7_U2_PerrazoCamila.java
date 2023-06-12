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
        
        //llamamos a los metodos
        veh.apagado();
        auto.encendido();
        moto.encendido();
        
        //imprimir estado del vehiculo segun los metodos 
        System.out.println(veh.estado);
        System.out.println(auto.estado);
        System.out.println(moto.estado);
        
    }
    
}
