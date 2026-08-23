import java.io.*;
import java.util.*;


public class GestionAsistencia {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        GestionCursos gestionCursos = new GestionCursos();
        GestionAlumnos gestionAlumnos = new GestionAlumnos(gestionCursos);
        GestionRegistroAsistencia gestionRegistroAsistencia = new GestionRegistroAsistencia();
        
        Menu menu = new Menu(leer, gestionCursos, gestionAlumnos,gestionRegistroAsistencia);
        menu.mostrarMenu();
        
    }
}
