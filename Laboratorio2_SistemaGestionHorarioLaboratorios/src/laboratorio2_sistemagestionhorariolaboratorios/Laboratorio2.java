/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2_sistemagestionhorariolaboratorios;


public class Laboratorio2 extends Laboratorios{
    String espacio;
    String lugar;
    
    public Laboratorio2(String nombre, int capacidad, String[] equipos, String espacio, String lugar) {
        super(nombre, capacidad, equipos);
        this.espacio = espacio;
        this.lugar = lugar;
    }
}
