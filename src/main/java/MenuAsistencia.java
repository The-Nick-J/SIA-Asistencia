import java.io.BufferedReader;
import java.io.IOException;

public class MenuAsistencia {

    private final BufferedReader leer;

    public MenuAsistencia(BufferedReader leer) {
        this.leer = leer;
    }

    public void mostrarMenu() throws IOException {
        int opcionAsistencia;

        do {
            System.out.println("Bienvenido al Menu de Asistencia");
            System.out.println("1. Pasar Asistencia");
            System.out.println("2. Registrar una Inasistencia Extraordinaria");
            System.out.println("3. Registrar salida anticipada");
            System.out.println("4. Consultar Asistencia");
            System.out.println("5. Volver al menu principal");
            opcionAsistencia = Integer.parseInt(leer.readLine());
        } while (opcionAsistencia != 5);
    }
}
