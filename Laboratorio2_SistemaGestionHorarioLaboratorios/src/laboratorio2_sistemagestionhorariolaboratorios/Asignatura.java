/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2_sistemagestionhorariolaboratorios;

/**
 *
 * @author HOME
 */
public class Asignatura {
    private String nombre;
    private String horario;
    private Laboratorios lab;
    
    public Asignatura(String nombre, String horario, Laboratorios laboratorio) {
        this.nombre = nombre;
        this.horario = horario;
        this.lab = laboratorio;
    }
    
}
