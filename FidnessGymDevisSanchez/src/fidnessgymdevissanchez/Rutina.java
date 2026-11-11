package fidnessgymdevissanchez;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private String nombreRutina;
    private List<Ejercicio> listaEjercicios;
    private LocalDate fechaCreado;

    public Rutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
        this.listaEjercicios = new ArrayList<>();
        this.fechaCreado = LocalDate.now();
    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public List<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        this.listaEjercicios.add(ejercicio);
    }

    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rutina: ").append(nombreRutina).append("\nFecha: ").append(fechaCreado).append("\nEjercicios:\n");
        for (int i = 0; i < listaEjercicios.size(); i++) {
            sb.append((i + 1)).append(". ").append(listaEjercicios.get(i).getNombre()).append(" (").append(listaEjercicios.get(i).getGrupoMuscular()).append(")\n");
        }
        return sb.toString();
    }
}