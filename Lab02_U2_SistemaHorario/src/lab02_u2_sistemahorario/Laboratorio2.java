
package lab02_u2_sistemahorario;

public class Laboratorio2 extends Laboratorio {
    private String lugar;

    public Laboratorio2(String nombre, int capacidad, String lugar) {
        super(nombre, capacidad);
        this.lugar = lugar;
    }
     public String getLugar() {
        return lugar;
    }
}
