import java.io.BufferedReader;
import java.io.IOException;

public class MenuAlumnos {

    private final BufferedReader leer;

    public MenuAlumnos(BufferedReader leer) {
        this.leer = leer;
    }

    public void mostrarMenu() throws IOException {
        int opcionAlumnos;

        do {
            System.out.println("Bienvenido al Menu de Gestion de Alumnos");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Mostrar Alumnos");
            System.out.println("3. Volver al Menu de Administracion");
            opcionAlumnos = Integer.parseInt(leer.readLine());
        } while (opcionAlumnos != 3);
    }
}
