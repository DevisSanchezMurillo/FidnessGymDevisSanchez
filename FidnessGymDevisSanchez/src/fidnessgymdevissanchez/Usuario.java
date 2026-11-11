package fidnessgymdevissanchez;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private List<Rutina> misRutinas;

    public Usuario(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.misRutinas = new ArrayList<>();
    }

    public List<Rutina> getMisRutinas() {
        return misRutinas;
    }

    public void agregarRutina(Rutina rutina) {
        this.misRutinas.add(rutina);
    }

    @Override
    public String mostrarDetalles() {
        return "Cliente: " + nombreUsuario + " | Rutinas registradas: " + misRutinas.size();
    }
}