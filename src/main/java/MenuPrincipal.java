import java.io.BufferedReader;
import java.io.IOException;

public class MenuPrincipal {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;
    private final GestionAlumnos gestionAlumnos;

    public MenuPrincipal(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos){
        this.leer = leer;
        this.gestionCursos = gestionCursos;
        this.gestionAlumnos = gestionAlumnos;
    }

    public void mostrarMenu() throws IOException {
        int opcion;

        do {
            System.out.println("Bienvenido al Menu Principal!");
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Gestion de Asistencia");
            System.out.println("2. Gestion de Administracion");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(leer.readLine());

            if (opcion == 1) {
                new MenuAsistencia(leer).mostrarMenu();
            } else if (opcion == 2) {
                new MenuAdministracion(leer, gestionCursos, gestionAlumnos).mostrarMenu();
            }
        } while (opcion != 3);
    }
}
