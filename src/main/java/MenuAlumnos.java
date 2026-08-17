import java.io.BufferedReader;
import java.io.IOException;

public class MenuAlumnos {

    private final BufferedReader leer;
    private final GestionAlumnos gestionAlumnos;

    public MenuAlumnos(BufferedReader leer, GestionAlumnos gestionAlumnos) {
        this.leer = leer;
        this.gestionAlumnos = gestionAlumnos;
    }

    public void mostrarMenu() throws IOException {
        int opcionAlumnos;

        do {
            System.out.println("Bienvenido al Menu de Gestion de Alumnos");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Mostrar Alumnos");
            System.out.println("3. Registrar Alumno en Curso");
            System.out.println("4. Volver al Menu de Administracion");
            opcionAlumnos = Integer.parseInt(leer.readLine());
            if(opcionAlumnos == 1){
                gestionAlumnos.agregarAlumno(leer.readLine(), leer.readLine(), leer.readLine());
            } else if(opcionAlumnos == 2){
                gestionAlumnos.mostrarAlumnos();
            }
        } while (opcionAlumnos != 4);
    }
}
