
package correcion_prueba;

public class Correcion_prueba {

    public static void main(String[] args) {
        System.out.println("=====ANIMAL=====");
        Animal animal1= new Animal("perro",5.5,4);
        animal1.getEspecie();
        animal1.getPeso();
        animal1.getNumPatas();
        System.out.println("La especie del animal es: "+animal1.getEspecie());
        System.out.println("El peso del animal es: "+animal1.getPeso());
        System.out.println("El numero de patas del animal es: "+animal1.getNumPatas());
        
        System.out.println("=====GATO=====");
        Gato gato1 = new Gato("gato", 5.5,4,"negro",2,true);
        gato1.setColor("negro");
        gato1.setEdad(2);
        gato1.setDomestico(true);
        System.out.println("La especie del gato es: "+gato1.getEspecie());
        System.out.println("El peso del gato es: "+gato1.getPeso());
        System.out.println("El numero de patas del gato es: "+gato1.getNumPatas());
        System.out.println("EL color del gato es: "+gato1.getColor());
        System.out.println("La edad del gato es: "+gato1.getEdad());
        
        System.out.println("=====LEON====");
        Leon leon1 = new Leon("leon",190.5,4,"Harley",190,false);
        leon1.Rey();
        leon1.getNombre();
        leon1.getEstatura();
        System.out.println("La especie del leon es: "+leon1.getEspecie());
        System.out.println("El peso del leon es: "+leon1.getPeso());
        System.out.println("El numero de patas del leon es: "+leon1.getNumPatas());
        System.out.println("El nombre del leon es: "+leon1.getNombre());
        System.out.println("La estatura del leon es: "+leon1.getEstatura()+"metros");
        
    }
    
}
