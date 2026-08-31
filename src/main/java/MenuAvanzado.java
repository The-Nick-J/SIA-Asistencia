
import java.io.BufferedReader;
import java.io.IOException;

public class MenuAvanzado {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;
    private final GestionAlumnos gestionAlumnos;
    
    public MenuAvanzado(BufferedReader leer, GestionCursos gestionCursos, GestionAlumnos gestionAlumnos) {
        this.leer = leer;
        this.gestionAlumnos = gestionAlumnos;
        this.gestionCursos = gestionCursos;
    }

    public void mostrarMenu() throws IOException {
        int opcionAvanzada;

        do {
            System.out.println("Bienvenido al Menu Avanzado");
            System.out.println("1. Eliminar Alumno");
            System.out.println("2. Eliminar Curso");
            System.out.println("3. Volver al menu de Administracion");
            opcionAvanzada = Integer.parseInt(leer.readLine());
            
            if(opcionAvanzada == 1){
                System.out.println("Ingrese el RUT del alumno a eliminar");
                String rut = leer.readLine();
                
                String confirmar;
                do {
                    System.out.println("Esta segur@ de eliminar al alumno? (S/N: ");
                    confirmar = leer.readLine().trim().toUpperCase();
                    if(!confirmar.equals("S") && !confirmar.equals("N")){
                        System.out.println("Ingrese una opcion valida.");
                    }
                } while (!confirmar.equals("S") && !confirmar.equals("N"));
                if(confirmar.equals("S")){
                    if(gestionAlumnos.eliminarAlumno(rut)){
                        System.out.println("Alumno eliminado con exito.");
                    } else {
                        System.out.println("No se encontro un alumno con ese RUT.");
                    }
                } else{
                    System.out.println("Operacion cancelada");
                }
            }
            
            if(opcionAvanzada == 2){
                System.out.println("Ingrese el codigo del curso a eliminar");
                String codigo = leer.readLine();
                
                String confirmar;
                do {
                    System.out.println("Esta segur@ de eliminar el curso? (S/N: ");
                    confirmar = leer.readLine().trim().toUpperCase();
                    if(!confirmar.equals("S") && !confirmar.equals("N")){
                        System.out.println("Ingrese una opcion valida.");
                    }
                } while (!confirmar.equals("S") && !confirmar.equals("N"));
                if(confirmar.equals("S")){
                    if(gestionCursos.eliminarCurso(codigo)){
                        System.out.println("Curso eliminado con exito.");
                    } else {
                        System.out.println("No se encontro un curo con ese codigo.");
                    }
                } else{
                    System.out.println("Operacion cancelada");
                }
            }
            
            
        } while (opcionAvanzada != 3);
    }
}
