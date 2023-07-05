
package lab02_u2_sistemahorario;

public class Laboratorio1 extends Laboratorio{
     private String espacio;

    public Laboratorio1(String nombre, int capacidad, String espacio) {
        super(nombre, capacidad);
        this.espacio = espacio;
    }
    public String getEspacio() {
        return espacio;
    }
}
