import java.io.BufferedReader;
import java.io.IOException;

public class MenuPrincipal {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;
    private final GestionAlumnos gestionAlumnos;
    private final GestionRegistroAsistencia gestionRegistroAsistencia;
    private final MenuAsistencia menuAsistencia;
    private final MenuAdministracion menuAdministracion;

    public MenuPrincipal(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos,GestionRegistroAsistencia gestionRegistroAsistencia){
        this.leer = leer;
        this.gestionCursos = gestionCursos;
        this.gestionAlumnos = gestionAlumnos;
        this.gestionRegistroAsistencia = gestionRegistroAsistencia;
        menuAsistencia = new MenuAsistencia(leer,gestionCursos,gestionRegistroAsistencia,gestionAlumnos);
        menuAdministracion = new MenuAdministracion(leer, gestionCursos, gestionAlumnos);
    }

    public void mostrarMenu() throws IOException {
        int opcion = 0;

        do {
            System.out.println("Bienvenido al Menu Principal!");
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Gestion de Asistencia");
            System.out.println("2. Gestion de Administracion");
            System.out.println("3. Salir");
            String entrada = leer.readLine();

            if (entrada == null) {
                return;
            }

            try {
                opcion = Integer.parseInt(entrada);

                if (opcion == 1) {
                    menuAsistencia.mostrarMenu();
                } else if (opcion == 2) {
                    menuAdministracion.mostrarMenu();
                } else if (opcion != 3) {
                    System.out.println("Error: opcion no es valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero de las opciones del menu.");
            }
        } while (opcion != 3);
    }
}
