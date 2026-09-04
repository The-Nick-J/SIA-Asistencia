
import java.io.BufferedReader;
import java.io.IOException;

public class MenuAvanzado {

    private final BufferedReader leer;
    private final GestionAlumnos gestionAlumnos;
    private final GestionCursos gestionCursos;

    public MenuAvanzado(BufferedReader leer, GestionAlumnos gestionAlumnos, GestionCursos gestionCursos) {
        this.leer = leer;
        this.gestionAlumnos = gestionAlumnos;
        this.gestionCursos = gestionCursos;
    }

    public void mostrarMenu() throws IOException {
        int opcionAvanzada;

        do {
            System.out.println("Bienvenido al Menu Avanzado");
            System.out.println("1. Eliminar Alumno");
            System.out.println("2. Eliminar Curso");
            System.out.println("3. Volver al menu de Administracion");
            opcionAvanzada = Integer.parseInt(leer.readLine());

            if (opcionAvanzada == 1) {
                System.out.println("Ingrese el RUT del alumno que desea eliminar: ");
                String rut = leer.readLine();
                System.out.println("¿Esta seguro de eliminar al alumno? (S/N): ");
                String confirmar = leer.readLine().trim().toUpperCase();
                if (confirmar.equals("S") && gestionAlumnos.eliminarAlumno(rut)) {
                    System.out.println("Alumno eliminado correctamente");
                } else if (confirmar.equals("S")) {
                    System.out.println("No existe un alumno con ese RUT");
                } else {
                    System.out.println("Operacion cancelada");
                }
            } else if (opcionAvanzada == 2) {
                System.out.println("Ingrese el codigo del curso que desea eliminar: ");
                String codigo = leer.readLine();
                System.out.println("¿Esta seguro de eliminar el curso? (S/N): ");
                String confirmar = leer.readLine().trim().toUpperCase();
                if (confirmar.equals("S") && gestionCursos.eliminarCurso(codigo)) {
                    System.out.println("Curso eliminado correctamente");
                } else if (confirmar.equals("S")) {
                    System.out.println("No existe un curso con ese codigo");
                } else {
                    System.out.println("Operacion cancelada");
                }
            }
        } while (opcionAvanzada != 3);
    }
}
