/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5_u2_perrazocamila;
import java.io.*;

public class Lab5_U2_PerrazoCamila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\HOME NO ELIMINAR\\Desktop\\Lab5_U2_PerrazoCamila.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\HOME NO ELIMINAR\\Desktop\\Lab5_U2_PerrazoCamila.txt"));){
            
        
                bw.write("Esto es una prueba usando Buffered");
                bw.newLine();
                bw.write("Seguimos usando Buffered");
                bw.newLine();
                bw.write("Hola a todos");
                bw.newLine();
                bw.write("Seguimos practicando");
                bw.newLine();
                //guardamos los cambios del fichero
                bw.flush();
                //Leemos el fichero y lo mostramos por pantalla
                String linea = br.readLine();
                while(linea !=null){
                    System.out.println(linea);
                    linea = br.readLine();
                }
        }catch (IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
    
}