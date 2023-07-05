
package correcion_prueba;

public class Animal {
   //atributos
    private String especie;
    private double peso;
    public int numPatas;
    
    //constructor
    public Animal(String especie, double peso, int numPatas){
        this.especie = especie;
        this.peso = peso;
        this.numPatas = numPatas;
        
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }
}
