
package g1p1bautistagonzalezperrazo;

import java.util.Scanner;

public class Veterinario {
    String nombre;
    String cedula;
    String edad;
    String medicamento;
    String tipoAnimalAtendido;
    String DiagnosticoAnimal;

    public Veterinario(){
        
    }
    public Veterinario(String nombre, String cedula, String edad, String medicamento, String tipoAnimalAtendido, String DiagnosticoAnimal) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.medicamento = medicamento;
        this.tipoAnimalAtendido = tipoAnimalAtendido;
        this.DiagnosticoAnimal = DiagnosticoAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getTipoAnimalAtendido() {
        return tipoAnimalAtendido;
    }

    public void setTipoAnimalAtendido(String tipoAnimalAtendido) {
        this.tipoAnimalAtendido = tipoAnimalAtendido;
    }

    public String getDiagnosticoAnimal() {
        return DiagnosticoAnimal;
    }

    public void setDiagnosticoAnimal(String DiagnosticoAnimal) {
        this.DiagnosticoAnimal = DiagnosticoAnimal;
    }

    public void atenderAnimal(){
      Scanner sc = new Scanner (System.in);  
       System.out.print("Nombre Veterinario: ");
       setNombre(sc.nextLine());
        
        System.out.print("Cedula: ");
        setCedula(sc.nextLine());        

        System.out.print("Edad Veterinario: ");
        setEdad(sc.nextLine());
        
        System.out.print("Ingrese los medicamento que utilizo para atender al animal: ");
        setMedicamento(sc.nextLine());
        
        System.out.print("Tipo de Animal a atender: ");
        setTipoAnimalAtendido(sc.nextLine());
        
        System.out.print("Diagnostico del Animal: ");
        setDiagnosticoAnimal(sc.nextLine());
        
        System.out.println("=========================== DIAGNOSTICO ANIMAL =========================");
        System.out.println("Veterinario: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Cedula: " + getCedula());
        System.out.println("Medicamento: " + getMedicamento());
        System.out.println("Tipo de animal atendido: $" + getTipoAnimalAtendido());
        System.out.println("Diagnostico: " +getDiagnosticoAnimal() );
        
        
    }
    }
    
    

    

