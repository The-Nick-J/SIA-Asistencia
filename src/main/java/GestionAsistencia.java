import java.io.*;
import java.util.*;


public class GestionAsistencia {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu(leer);
        menu.mostrarMenu();
        
        Alumno alumno1 = new Alumno("12.345.678-K", "Juan", "Soto");
        Alumno alumno2 = new Alumno("22.575.999-1", "Pedro", "Perez");
        
        curso1.addAlumno(alumno1);
        curso2.addAlumno(alumno2);
        
        System.out.println(mapaCursos.get("4A"));
        
    }
}
