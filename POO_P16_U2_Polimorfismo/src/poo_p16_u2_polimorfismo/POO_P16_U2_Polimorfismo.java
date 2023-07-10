
package poo_p16_u2_polimorfismo;

public class POO_P16_U2_Polimorfismo {

    
    public static void main(String[] args) {
       //llamamos al metodo mostrar
       mostrarDatosFiguras(new Triangulo(4, 5, "amarillo "));
       mostrarDatosFiguras(new Circulo(5, "verde "));
       mostrarDatosFiguras(new Cuadrado(6,"azul "));
    
    }
    
    //polimorfismo
    //la gran ventaja del polimorfismo es la reutilizacion
    //de codigo, al forzar a todas las clases a tener el mismo metodo
    //esta expresion vale para cualquier subclase de figura
    private static void mostrarDatosFiguras(Figura f){
        System.out.println("Color "+f.getColor());
        System.out.println("Superficie "+f.superficie());
        
    }
}
