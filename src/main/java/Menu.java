import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

    private final MenuPrincipal menuPrincipal;

    public Menu(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos,GestionRegistroAsistencia gestionRegistroAsistencia){
        menuPrincipal = new MenuPrincipal(leer, gestionCursos, gestionAlumnos,gestionRegistroAsistencia);
    }

    public void mostrarMenu() throws IOException {
        menuPrincipal.mostrarMenu();
    }
}
