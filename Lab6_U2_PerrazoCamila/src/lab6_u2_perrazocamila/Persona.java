/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6_u2_perrazocamila;

/**
 *
 * @author HOME
 */
public class Persona {
    private String nombre;
    private String telefono;
    private String email;
    
    //constructor 
    public Persona(String nombre, String telefono, String email){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
