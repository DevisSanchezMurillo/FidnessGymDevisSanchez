package fidnessgymdevissanchez;

//Avance #2
//Estudiante: Devis Sánchez Murillo. 
//Tomar en cuenta, Ingrese: 
//Usuario: devis
//Clave: 1234

//Este programa se base en lo que indiqué en avance 1, loguearse con devis clave 1234,
//Escoger una de las 3 opciones iniciales del menú, crear la rutina.
//Puede escoger la última opción del menú para ver la rutina que haya creado. 
//Ingrese al menos 4 ejercicios, la opción de exportar es simulada con joptionpane através de un mensaje. 

import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Usuario usuarioActual = null;

        while (usuarioActual == null) {
            String user = JOptionPane.showInputDialog(null, " FIDNESS GYM \nIngrese su usuario:", "Login", JOptionPane.QUESTION_MESSAGE);
            if (user == null) {
                System.exit(0);
            }
            String pass = JOptionPane.showInputDialog(null, "Ingrese su contraseña de Fidness:", "Login", JOptionPane.QUESTION_MESSAGE);
            if (pass == null) {
                System.exit(0);
            }

            try {
                usuarioActual = gestor.autenticar(user, pass);
                JOptionPane.showMessageDialog(null, "¡Hola, Bienvenido(a) " + usuarioActual.getNombreUsuario() + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            }
        }

        boolean salir = false;
        while (!salir) {
            String[] opciones = {"Crear Rutina", "Ver Mis Rutinas", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Menú Principal - Fidness Gym", "Seleccione una opción",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == 0) {
                String nombreRutina = JOptionPane.showInputDialog(null, "Ingrese el nombre de la rutina (ej. Pecho y Biceps):", "Nueva Rutina", JOptionPane.QUESTION_MESSAGE);
                if (nombreRutina != null && !nombreRutina.trim().isEmpty()) {
                    Rutina nuevaRutina = new Rutina(nombreRutina);
                    boolean anadiendo = true;

                    while (anadiendo) {
                        String categoria = JOptionPane.showInputDialog(null, "Ingrese el grupo muscular a consultar (Biceps, Pecho, Triceps, Espalda, Pierna):", "Catálogo de Ejercicios", JOptionPane.QUESTION_MESSAGE);
                        if (categoria == null) break;

                        List<Ejercicio> ejerciciosFiltrados = gestor.filtrarPorGrupoMuscular(categoria);
                        if (ejerciciosFiltrados.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay ejercicios para ese grupo muscular.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        } else {
                            String[] nombresEjercicios = new String[ejerciciosFiltrados.size()];
                            for (int i = 0; i < ejerciciosFiltrados.size(); i++) {
                                nombresEjercicios[i] = ejerciciosFiltrados.get(i).getNombre();
                            }

                            String ejercicioSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un ejercicio para ver detalles y agregar:",
                                    "Ejercicios de " + categoria, JOptionPane.QUESTION_MESSAGE, null, nombresEjercicios, nombresEjercicios[0]);

                            if (ejercicioSeleccionado != null) {
                                Ejercicio ejercicioObj = null;
                                for (Ejercicio e : ejerciciosFiltrados) {
                                    if (e.getNombre().equals(ejercicioSeleccionado)) {
                                        ejercicioObj = e;
                                        break;
                                    }
                                }

                                if (ejercicioObj != null) {
                                    int opcionEjercicio = JOptionPane.showConfirmDialog(null, ejercicioObj.mostrarDetalles() + "\n\n¿Desea agregar este ejercicio a su rutina?",
                                            "Detalle de Ejercicio", JOptionPane.YES_NO_OPTION);

                                    if (opcionEjercicio == JOptionPane.YES_OPTION) {
                                        nuevaRutina.agregarEjercicio(ejercicioObj);
                                        JOptionPane.showMessageDialog(null, "Ejercicio agregado exitosamente a la rutina.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                            }
                        }

                        int continuar = JOptionPane.showConfirmDialog(null, "¿Desea agregar más ejercicios a esta rutina?", "Continuar", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.NO_OPTION) {
                            anadiendo = false;
                        }
                    }

                    usuarioActual.agregarRutina(nuevaRutina);

                    if (nuevaRutina.getListaEjercicios().size() >= 4) {
                        JOptionPane.showMessageDialog(null, "Rutina creada con éxito con " + nuevaRutina.getListaEjercicios().size() + " ejercicios.\nExportando archivo PDF de la rutina...", "Exportar PDF", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Rutina guardada con éxito.", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else if (seleccion == 1) {
                if (usuarioActual.getMisRutinas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No tiene rutinas registradas.", "Mis Rutinas", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Rutina r : usuarioActual.getMisRutinas()) {
                        sb.append(r.mostrarDetalles()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString(), "Mis Rutinas Guardadas", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                salir = true;
            }
        }
        JOptionPane.showMessageDialog(null, "Gracias por usar Fidness Gym.", "Despedida", JOptionPane.INFORMATION_MESSAGE);
    }
}