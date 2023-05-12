/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica_clases;

/**
 *
 * @author HOME
 */
public class Practica_clases {

    public static void main(String[] args) {
        
        Ninas ninas1 = new Ninas();
        ninas1.nombre= "Melisa";
        ninas1.apellido= "Murillo";
        ninas1.edad=9;
        ninas1.color_cabello="negro";
        ninas1.estatura=130;
     
        System.out.println(ninas1.nombre);
        System.out.println(ninas1.apellido);
        System.out.println(ninas1.edad);
        System.out.println(ninas1.color_cabello);
        System.out.println(ninas1.estatura);
        
        Carro carro1 = new Carro();
        carro1.codigo=100;
        carro1.marca="Hyndai";
        carro1.color="rojo";
        carro1.año=2010;
        carro1.precio=5500;
        
        System.out.println(carro1.codigo);
        System.out.println(carro1.marca);
        System.out.println(carro1.color);
        System.out.println(carro1.año);
        System.out.println(carro1.precio);
        
        Libro libro1 = new Libro();
        libro1.id=322;
        libro1.titulo="Corazon de piedra";
        libro1.autor="Jose Maria Garcia";
        libro1.editorial="La nocturna";
        libro1.precio=6;
        
        System.out.println(libro1.id);
        System.out.println(libro1.titulo);
        System.out.println(libro1.autor);
        System.out.println(libro1.editorial);
        System.out.println(libro1.precio);
                
    }
}
