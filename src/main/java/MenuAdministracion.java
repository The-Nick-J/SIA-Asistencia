import java.io.BufferedReader;
import java.io.IOException;

public class MenuAdministracion {

    private final BufferedReader leer;

    public MenuAdministracion(BufferedReader leer) {
        this.leer = leer;
    }

    public void mostrarMenu() throws IOException {
        int opcionAdmin;

        do {
            System.out.println("Bienvenido al Menu de Administracion");
            System.out.println("1. Gestion de Alumnos");
            System.out.println("2. Gestion de Cursos");
            System.out.println("3. Gestion del Calendario Escolar");
            System.out.println("4. Opciones Avanzadas");
            System.out.println("5. Volver al Menu Principal");
            opcionAdmin = Integer.parseInt(leer.readLine());

            if (opcionAdmin == 1) {
                new MenuAlumnos(leer).mostrarMenu();
            } else if (opcionAdmin == 2) {
                new MenuCursos(leer).mostrarMenu();
            } else if (opcionAdmin == 3) {
                new MenuCalendario(leer).mostrarMenu();
            } else if (opcionAdmin == 4) {
                new MenuAvanzado(leer).mostrarMenu();
            }
        } while (opcionAdmin != 5);
    }
}
