package fidnessgymdevissanchez;

public abstract class Persona {
    protected String nombreUsuario;
    protected String contrasena;

    public Persona(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public abstract String mostrarDetalles();
}