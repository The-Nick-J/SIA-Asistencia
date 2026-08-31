import java.io.BufferedReader;
import java.io.IOException;

public class MenuCursos {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;

    public MenuCursos(BufferedReader leer, GestionCursos gestionCursos) {
        this.leer = leer;
        this.gestionCursos = gestionCursos;
    }

    public void mostrarMenu() throws IOException {
        int opcionCursos;

        do {
            //promptea al usuario por opciones
            System.out.println("Bienvenido al Menu de Gestion de Cursos");
            System.out.println("1. Agregar Curso");
            System.out.println("2. Mostrar Cursos");
            System.out.println("3. Editar Curso");
            System.out.println("4. Buscar Curso");
            System.out.println("5. Volver al Menu de Administracion");
            opcionCursos = Integer.parseInt(leer.readLine());
            
            if (opcionCursos == 1){
                
                //promptea al usuario por los datos
                System.out.print("Nombre del curso: ");
                String nombre = leer.readLine();
                System.out.print("Codigo del curso: ");
                String codigo = leer.readLine();
                System.out.print("Profesor jefe: ");
                String profesorJefe = leer.readLine();
                
                //feedback al usuario sobre la operacion y llama el metodo de agregado
                if(gestionCursos.agregarCurso(nombre, codigo, profesorJefe)){
                    System.out.println("Curso agregado con exito!");
                    System.out.println("--------------------------");
                } else {
                    System.out.println("Error al agregar curso");
                    System.out.println("--------------------------");
                }
                
            } else if (opcionCursos == 2){
                gestionCursos.mostrarCursos();
            } else if (opcionCursos == 3){
                System.out.println("Codigo del curso a editar: ");
                String codigo = leer.readLine();
                System.out.println("Nuevo nombre del curso: ");
                String nuevoNombre = leer.readLine();
                System.out.println("Nuevo profesor jefe: ");
                String nuevoProfesorJefe = leer.readLine();
                
                if(gestionCursos.editarCurso(codigo, nuevoNombre, nuevoProfesorJefe)){
                    System.out.println("Curso editado con exito!");
                } else {
                    System.out.println("No existe un curso con ese codigo");
                }
            } else if (opcionCursos == 4){
                System.out.print("Ingrese el codigo del curso a buscar: ");
                String codigo = leer.readLine();
                gestionCursos.mostrarCurso(codigo);
            }
        } while (opcionCursos != 5);
    }
}
