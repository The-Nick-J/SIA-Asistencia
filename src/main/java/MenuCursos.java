import java.io.BufferedReader;
import java.io.IOException;

public class MenuCursos {

    private final BufferedReader leer;

    public MenuCursos(BufferedReader leer) {
        this.leer = leer;
    }

    public void mostrarMenu() throws IOException {
        int opcionCursos;

        do {
            System.out.println("Bienvenido al Menu de Gestion de Cursos");
            System.out.println("1. Agregar Curso");
            System.out.println("2. Mostrar Cursos");
            System.out.println("3. Volver al Menu de Administracion");
            opcionCursos = Integer.parseInt(leer.readLine());
        } while (opcionCursos != 3);
    }
}
