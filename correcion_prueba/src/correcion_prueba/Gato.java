
package correcion_prueba;

public class Gato extends Animal {
    //atributos
    public String color;
    private int edad;
    public boolean domestico;
    
    //constructor
    public Gato(String especie, double peso, int numPatas, String color, int edad, boolean domestico){
    super(especie, peso, numPatas);
    this.color = color;
    this.edad = edad;
    this.domestico = domestico;
    
    }
    public void Domestico(){
        if(this.domestico){
            this.domestico = true;
            System.out.println("El gato es domestico");

        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isDomestico() {
        return domestico;
    }

    public void setDomestico(boolean domestico) {
        this.domestico = domestico;
    }
}
