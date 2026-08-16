
import java.io.BufferedReader;
import java.io.IOException;

public class MenuAvanzado {

    private final BufferedReader leer;

    public MenuAvanzado(BufferedReader leer) {
        this.leer = leer;
    }

    public void mostrarMenu() throws IOException {
        int opcionAvanzada;

        do {
            System.out.println("Bienvenido al Menu Avanzado");
            System.out.println("1. Eliminar Alumno");
            System.out.println("2. Eliminar Curso");
            System.out.println("3. Volver al menu de Administracion");
            opcionAvanzada = Integer.parseInt(leer.readLine());
        } while (opcionAvanzada != 3);
    }
}
