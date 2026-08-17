import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

    private final MenuPrincipal menuPrincipal;

    public Menu(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos){
        menuPrincipal = new MenuPrincipal(leer, gestionCursos, gestionAlumnos);
    }

    public void mostrarMenu() throws IOException {
        menuPrincipal.mostrarMenu();
    }
}
