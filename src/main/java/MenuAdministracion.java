import java.io.BufferedReader;
import java.io.IOException;

public class MenuAdministracion {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;
    private final GestionAlumnos gestionAlumnos;
    private final MenuAlumnos menuAlumnos;
    private final MenuCursos menuCursos;
    private final MenuAvanzado menuAvanzado;

    public MenuAdministracion(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos) {
        this.leer = leer;
        this.gestionCursos = gestionCursos;
        this.gestionAlumnos = gestionAlumnos;
        this.menuAlumnos = new MenuAlumnos(leer, gestionAlumnos);
        this.menuCursos = new MenuCursos(leer, gestionCursos);
        this.menuAvanzado = new MenuAvanzado(leer, gestionAlumnos, gestionCursos);
    }

    public void mostrarMenu() throws IOException {
        int opcionAdmin = 0;

        do {
            System.out.println("Bienvenido al Menu de Administracion");
            System.out.println("1. Gestion de Alumnos");
            System.out.println("2. Gestion de Cursos");
            System.out.println("3. Opciones Avanzadas");
            System.out.println("4. Volver al Menu Principal");

            String entrada = leer.readLine();

            if(entrada == null) {
                return;
            }

            try {
                opcionAdmin = Integer.parseInt(entrada);

                if (opcionAdmin == 1) {
                    menuAlumnos.mostrarMenu();
                } else if (opcionAdmin == 2) {
                    menuCursos.mostrarMenu();
                } else if (opcionAdmin == 3) {
                    menuAvanzado.mostrarMenu();
                } else if (opcionAdmin != 4) {
                    System.out.println("Error: Opcion no es Valida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero de las opciones del menu.");
            }
        } while (opcionAdmin != 4);
    }
}
