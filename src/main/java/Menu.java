
import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

    private final BufferedReader leer;
    private final MenuPrincipal menuPrincipal;
    private final GestionCursos gestionCursos;
    private final GestionAlumnos gestionAlumnos;
    private final GestionRegistroAsistencia gestionRegistroAsistencia;

    public Menu(
            BufferedReader leer,
            GestionCursos gestionCursos,
            GestionAlumnos gestionAlumnos,
            GestionRegistroAsistencia gestionRegistroAsistencia) {

        this.leer = leer;
        this.gestionCursos = gestionCursos;
        this.gestionAlumnos = gestionAlumnos;
        this.gestionRegistroAsistencia = gestionRegistroAsistencia;

        this.menuPrincipal = new MenuPrincipal(leer, gestionCursos, gestionAlumnos, gestionRegistroAsistencia);
    }

    public void mostrarMenu() throws IOException {
        int opcion = 0;
        do {
            System.out.println("Seleccione el modo: ");
            System.out.println("1. Usar consola");
            System.out.println("2. Usar ventana");
            System.out.println("3. Salir");

            String entrada = leer.readLine();

            if(entrada == null) {
                return;
            }

            try {
                opcion = Integer.parseInt(entrada);

                if (opcion == 1) {
                    menuPrincipal.mostrarMenu();
                } else if (opcion == 2) {
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(
                            gestionCursos,
                            gestionAlumnos,
                            gestionRegistroAsistencia
                    );

                    ventanaPrincipal.setVisible(true);
                    return;
                } else if (opcion != 3) {
                    System.out.println("Error: Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero de las opciones del menu.");
            }
        } while (opcion != 3);
    }
}
