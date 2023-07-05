
package lab02_u2_sistemahorario;

public class Asignatura {
    private String nombre;
    private String horario;
    private Laboratorio laboratorio;

    public Asignatura(String nombre, String horario, Laboratorio laboratorio) {
        this.nombre = nombre;
        this.horario = horario;
        this.laboratorio = laboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }
}
