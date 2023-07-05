
package lab02_u2_sistemahorario;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String nombre;
    private int capacidad;
    private List<String> equipos;
    private List<String> horariosOcupados;

    public Laboratorio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.equipos = new ArrayList<>();
        this.horariosOcupados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<String> getEquipos() {
        return equipos;
    }

    public void agregarEquipo(String equipo) {
        equipos.add(equipo);
    }

    public boolean verificarDisponibilidad(String horario) {
        return !horariosOcupados.contains(horario);
    }

    public void asignarHorario(String horario) {
        horariosOcupados.add(horario);
    }
}
