import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
    
    private final BufferedReader leer;
    private final MenuPrincipal menuPrincipal;

    public Menu(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos,GestionRegistroAsistencia gestionRegistroAsistencia){
        this.leer = leer;
        this.menuPrincipal = new MenuPrincipal(leer, gestionCursos, gestionAlumnos,gestionRegistroAsistencia);
    }
    
    public void mostrarMenu() throws IOException {
        int opcion;
        do {
            System.out.println("Seleccione el modo: ");
            System.out.println("1. Usar consola");
            System.out.println("2. Usar ventana");
            System.out.println("3. Salir");
            
            opcion = Integer.parseInt(leer.readLine());
            
            if(opcion == 1){
                menuPrincipal.mostrarMenu();
            } else if (opcion == 2){
                System.out.println("VENTANA WORK IN PROGRESS");
                //TO DO: ACA VA LA LLAMADA A LA VENTANA
            } else if (opcion != 3){
                System.out.println("Error: Opcion invalida");
            }
        } while (opcion != 3);
    }
}
