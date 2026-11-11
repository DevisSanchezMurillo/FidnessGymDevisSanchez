package fidnessgymdevissanchez;

import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private List<Usuario> usuariosRegistrados;
    private List<Ejercicio> catalogoEjercicios;

    public Gestor() {
        this.usuariosRegistrados = new ArrayList<>();
        this.catalogoEjercicios = new ArrayList<>();
        precargarEjercicios();
    }

    public void precargarEjercicios() {
        usuariosRegistrados.add(new Usuario("devis", "1234"));
        usuariosRegistrados.add(new Usuario("cliente", "admin"));

        catalogoEjercicios.add(new Ejercicio("Curl de Bicep Mancuerna", "Biceps", "1- Toma las mancuernas\n2- Codos pegados al torso\n3- Baja en 3 seg y sube en 1"));
        catalogoEjercicios.add(new Ejercicio("Curl Bicep Polea", "Biceps", "1- Ajusta la polea baja\n2- Mantén la postura firme al flexionar"));
        catalogoEjercicios.add(new Ejercicio("Press Banca", "Pecho", "1- Acuéstate en el banco\n2- Baja la barra controlada al pecho\n3- Empuja hacia arriba"));
        catalogoEjercicios.add(new Ejercicio("Press Banca Inclinada", "Pecho", "1- Ajusta el banco a 30 grados\n2- Ejecuta el press controlado"));
        catalogoEjercicios.add(new Ejercicio("Press Franca", "Triceps", "1- Acuéstate con barra EZ\n2- Flexiona los codos bajando hacia la frente"));
        catalogoEjercicios.add(new Ejercicio("Jalon al Pecho", "Espalda", "1- Toma la barra polea alta\n2- Baja la barra hacia el pecho arqueando levemente la espalda"));
        catalogoEjercicios.add(new Ejercicio("Prensa de Pierna", "Pierna", "1- Coloca los pies en la plataforma\n2- Desciende de forma controlada y empuja"));
    }

    public Usuario autenticar(String user, String pass) throws Exception {
        if (user == null || user.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario y la contraseña no pueden estar vacíos.");
        }
        for (Usuario u : usuariosRegistrados) {
            if (u.getNombreUsuario().equalsIgnoreCase(user) && u.getContrasena().equals(pass)) {
                return u;
            }
        }
        throw new Exception("Credenciales incorrectas. Acceso denegado.");
    }

    public List<Ejercicio> filtrarPorGrupoMuscular(String categoria) {
        List<Ejercicio> filtrados = new ArrayList<>();
        for (Ejercicio e : catalogoEjercicios) {
            if (e.getGrupoMuscular().equalsIgnoreCase(categoria)) {
                filtrados.add(e);
            }
        }
        return filtrados;
    }
}