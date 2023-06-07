/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica3_excepciones_perrazo_camila;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author HOME
 */
public class Practica3_excepciones_Perrazo_Camila {
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       try{
       String nombre = br.readLine();
       int div = 8/0;
       System.out.println(div);
       } catch (IOException e){
           e.printStackTrace();
 
       }catch (ArithmeticException es){
           System.out.println("No puede dividir en 0");
       }
    }
    
}
