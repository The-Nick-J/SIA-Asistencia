
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
        int opcionCursos = 0;

        do {
            //promptea al usuario por opciones
            System.out.println("Bienvenido al Menu de Gestion de Cursos");
            System.out.println("1. Agregar Curso");
            System.out.println("2. Mostrar Cursos");
            System.out.println("3. Editar Curso");
            System.out.println("4. Buscar Curso");
            System.out.println("5. Volver al Menu de Administracion");

            String entrada = leer.readLine();

            if (entrada == null) {
                return;
            }

            try {
                opcionCursos = Integer.parseInt(entrada);

                if (opcionCursos == 1) {

                    //promptea al usuario por los datos
                    System.out.print("Nombre del curso: ");
                    String nombre = leer.readLine();
                    System.out.print("Codigo del curso: ");
                    String codigo = leer.readLine();
                    System.out.print("RUT del profesor jefe: ");
                    String rutProfesor = leer.readLine();
                    System.out.print("Nombre del profesor jefe: ");
                    String nombreProfesor = leer.readLine();
                    System.out.print("Apellido del profesor jefe: ");
                    String apellidoProfesor = leer.readLine();
                    System.out.print("Asignatura del profesor jefe: ");
                    String asignatura = leer.readLine();
                    
                    if(rutProfesor == null || nombreProfesor == null || apellidoProfesor == null || asignatura == null){
                        return;
                    }
                    
                    rutProfesor = rutProfesor.trim();
                    nombreProfesor = nombreProfesor.trim();
                    apellidoProfesor = apellidoProfesor.trim();
                    asignatura = asignatura.trim();
                    
                    if(rutProfesor.isEmpty() || nombreProfesor.isEmpty() || apellidoProfesor.isEmpty() || asignatura.isEmpty()){
                        System.out.println("Debe completar los datos del profesor.");
                        continue;
                    }

                    //feedback al usuario sobre la operacion y llama el metodo de agregado
                    if (gestionCursos.agregarCurso(nombre, codigo, rutProfesor, nombreProfesor, apellidoProfesor, asignatura)) {
                        System.out.println("Curso agregado con exito!");
                        System.out.println("--------------------------");
                    } else {
                        System.out.println("Error al agregar curso");
                        System.out.println("--------------------------");
                    }

                } else if (opcionCursos == 2) {
                    System.out.println(gestionCursos.obtenerListadoCursos());
                } else if (opcionCursos == 3) {
                    System.out.println("Codigo del curso a editar: ");
                    String codigo = leer.readLine();

                    gestionCursos.obtenerCurso(codigo);

                    System.out.println("Nuevo nombre del curso: ");
                    String nuevoNombre = leer.readLine();
                    System.out.print("RUT del profesor jefe: ");
                    String rutProfesor = leer.readLine();
                    System.out.print("Nombre del profesor jefe: ");
                    String nombreProfesor = leer.readLine();
                    System.out.print("Apellido del profesor jefe: ");
                    String apellidoProfesor = leer.readLine();
                    System.out.print("Asignatura del profesor jefe: ");
                    String asignatura = leer.readLine();

                    if (nuevoNombre == null || rutProfesor == null || nombreProfesor == null || apellidoProfesor == null|| asignatura == null){
                        return;
                    }
                    
                    nuevoNombre = nuevoNombre.trim();
                    rutProfesor = rutProfesor.trim();
                    nombreProfesor = nombreProfesor.trim();
                    apellidoProfesor = apellidoProfesor.trim();
                    asignatura = asignatura.trim();

                    if (nuevoNombre.isEmpty() || rutProfesor.isEmpty() || nombreProfesor.isEmpty() || apellidoProfesor.isEmpty() || asignatura.isEmpty()){
                        System.out.println("Debe completar todos los datos.");
                        continue;
                    }

                    if (gestionCursos.editarCurso(codigo, nuevoNombre, rutProfesor, nombreProfesor, apellidoProfesor, asignatura)) {
                        System.out.println("Curso editado con exito!");
                    } else {
                        System.out.println("No existe un curso con ese codigo");
                    }
                } else if (opcionCursos == 4) {
                    System.out.println("Código del curso que desea buscar: ");

                    String codigo = leer.readLine();

                    gestionCursos.obtenerCurso(codigo);
                    System.out.println(gestionCursos.obtenerDetalleCurso(codigo));

                } else if (opcionCursos != 5) {
                    System.out.println("Error, tu opcion elegida no es valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero de las opciones del menu.");
            } catch (CursoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        } while (opcionCursos != 5);
    }
}
