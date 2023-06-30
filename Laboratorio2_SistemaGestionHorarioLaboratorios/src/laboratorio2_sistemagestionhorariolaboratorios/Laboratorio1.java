/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2_sistemagestionhorariolaboratorios;

/**
 *
 * @author HOME
 */
public class Laboratorio1 extends Laboratorios{
    String espacio;
    String lugar;
    
    
     public Laboratorio1(String nombre, int capacidad, String[] equipos, String espacio, String lugar) {
        super(nombre, capacidad, equipos);
        this.espacio = espacio;
        this.lugar = lugar;
    }
}
