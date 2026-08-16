import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

    private final MenuPrincipal menuPrincipal;

    public Menu(BufferedReader leer) {
        menuPrincipal = new MenuPrincipal(leer);
    }

    public void mostrarMenu() throws IOException {
        menuPrincipal.mostrarMenu();
    }
}
