/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8_u2_herencia;

/**
 *
 * @author HOME
 */
public class Deportista extends Persona {
    String deporte;

    public Deportista(String nombre) {
        super(nombre);
    }
    
    public void cambiarNombre(String nombre){
        super.setNombre(nombre);
        
    }
}
