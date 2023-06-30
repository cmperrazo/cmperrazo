/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_u2_p10_sobrecarga;

public class Persona {
    //atributos
    String nombre;
    int edad;
    int cedula;
    
    //constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        
    }
    //sobrecarga de constructor
    public Persona(int cedula){
        this.cedula = cedula;
    }
    
    //metodos
    public void jugar(){
        System.out.println("Mi nombre es: "+nombre + " y voy a jugar");
    }
    //sobrecarga de metodos 
    public void jugar(String juego){
        System.out.println("Voy a jugar "+juego+ ",me gusta mucho");
    }
            
 
}
