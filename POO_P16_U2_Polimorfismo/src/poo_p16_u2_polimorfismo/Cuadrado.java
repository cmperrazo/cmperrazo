
package poo_p16_u2_polimorfismo;

public class Cuadrado extends Figura {
    private int lado;

    public Cuadrado(int lado, String color) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double superficie() {
        return lado * lado;
    }
    
    
}
