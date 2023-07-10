
package poo_p16_u2_polimorfismo;


public class Circulo extends Figura {
    private int radio;

    public Circulo(int radio, String color) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double superficie() {
        return Math.PI*radio*radio;
    }
    
}
