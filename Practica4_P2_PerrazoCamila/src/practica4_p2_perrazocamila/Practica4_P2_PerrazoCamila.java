/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica4_p2_perrazocamila;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;


public class Practica4_P2_PerrazoCamila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        BufferedReader br = new BufferedReader(new FileReader ("C:\\Users\\HOME\\Documents"));
        String linea;
        try{
           while((linea = br.readLine())!=null){
           System.out.println(linea);    
           }
       }catch(IOException ex){
    }
    }
    
}
