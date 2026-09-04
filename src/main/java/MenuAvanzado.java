
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
                if (gestionAlumnos.eliminarAlumno(rut)) {
                    System.out.println("Alumno eliminado correctamente");
                } else {
                    System.out.println("No existe un alumno con ese RUT");
                }
            } else if (opcionAvanzada == 2) {
                System.out.println("Ingrese el codigo del curso que desea eliminar: ");
                String codigo = leer.readLine();
                if (gestionCursos.eliminarCurso(codigo)) {
                    System.out.println("Curso eliminado correctamente");
                } else {
                    System.out.println("No existe un curso con ese codigo");
                }
            }
        } while (opcionAvanzada != 3);
    }
}
