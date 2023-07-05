
package correcion_prueba;

public class Leon extends Animal{
    //atrubutos
    
    public String nombre;
    private double estatura;
    private boolean rey;
    
    //constructor
    public Leon(String especie, double peso, int numPatas, String nombre, double estatura, boolean rey){
        super(especie, peso, numPatas);
        this.nombre = nombre;
        this.estatura = estatura;
        this.rey = rey;
    }
    public void Rey(){
        if(this.rey){
            this.rey = false;
            System.out.println("El leon no es rey de la manada");
        }else{this.rey = true;
            System.out.println("El leon es rey de la manada");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public boolean isRey() {
        return rey;
    }

    public void setRey(boolean rey) {
        this.rey = rey;
    }
            
   
}
