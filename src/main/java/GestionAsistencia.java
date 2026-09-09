import java.io.*;
import java.util.*;


public class GestionAsistencia {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        GestionCursos gestionCursos = new GestionCursos();
        GestionAlumnos gestionAlumnos = new GestionAlumnos(gestionCursos);
        GestionRegistroAsistencia gestionRegistroAsistencia = new GestionRegistroAsistencia();
        
        CSV csv = new CSV(gestionCursos, gestionAlumnos, gestionRegistroAsistencia);
        csv.cargarTodo();
        
        Runtime.getRuntime().addShutdownHook(new Thread (() -> {
            try {
                csv.guardarTodo();
            } catch (IOException e) {
                System.err.println("Error al guardar los datos en CSV: " + e.getMessage());
            }
        }));
        
        Menu menu = new Menu(leer, gestionCursos, gestionAlumnos,gestionRegistroAsistencia);
        menu.mostrarMenu();
        
    }
}
