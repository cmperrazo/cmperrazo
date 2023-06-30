/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_u2_p10_sobrecarga;

/**
 *
 * @author ESPE
 */
public class POO_U2_P10_SOBRECARGA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instanciamos
        Persona persona = new Persona("Javier", 46);
        persona.jugar();
        
        Persona persona2 = new Persona(1233455433);
        persona2.jugar("Futbol");
    }
    
}
