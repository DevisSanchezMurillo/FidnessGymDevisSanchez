package fidnessgymdevissanchez;

public class Ejercicio {
    private String nombre;
    private String grupoMuscular;
    private String instruccionesEjecucion;

    public Ejercicio(String nombre, String grupoMuscular, String instruccionesEjecucion) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.instruccionesEjecucion = instruccionesEjecucion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public String getInstruccionesEjecucion() {
        return instruccionesEjecucion;
    }

    public String mostrarDetalles() {
        return "Ejercicio: " + nombre + "\nGrupo Muscular: " + grupoMuscular + "\n\nInstrucciones:\n" + instruccionesEjecucion;
    }
}