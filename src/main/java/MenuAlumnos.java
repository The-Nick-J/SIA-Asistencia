
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
        int opcionAlumnos = 0;
        int opcionAlumnoBuscar;
        String rutBuscar;
        String nombreBuscar;
        String apellidoBuscar;

        do {
            System.out.println("Bienvenido al Menu de Gestion de Alumnos");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Mostrar Alumno");
            System.out.println("3. Mostrar Todos los Alumnos");
            System.out.println("4. Registrar Alumno en Curso");
            System.out.println("5. Editar Alumno");
            System.out.println("6. Volver al Menu de Administracion");

            String entrada = leer.readLine();

            if (entrada == null) {
                return;
            }

            try {
                opcionAlumnos = Integer.parseInt(entrada);

                if (opcionAlumnos == 1) {
                    //promptea al usuario por los datos
                    System.out.print("RUT: ");
                    String rut = leer.readLine();
                    System.out.print("Nombre: ");
                    String nombre = leer.readLine();
                    System.out.print("Apellido: ");
                    String apellido = leer.readLine();

                    if (gestionAlumnos.agregarAlumno(rut, nombre, apellido)) {
                        System.out.println("Alumno agregado con exito!");
                        System.out.println("--------------------------");
                    } else {
                        System.out.println("Error al agregar alumno");
                        System.out.println("-----------------------");
                    }

                } else if (opcionAlumnos == 2) {

                    System.out.println("Como desea buscar al alumno?:");
                    System.out.println("1. Buscar por RUT");
                    System.out.println("2. Buscar por Nombre y Apellido");

                    String entradaBusqueda = leer.readLine();

                    if (entradaBusqueda == null) {
                        return;
                    }

                    opcionAlumnoBuscar = Integer.parseInt(entradaBusqueda);

                    if (opcionAlumnoBuscar == 1) {
                        System.out.println("Ingrese el RUT del alumno: ");
                        rutBuscar = leer.readLine();
                        Alumno alumno = gestionAlumnos.obtenerAlumno(rutBuscar);
                        alumno.mostrarResumen();
                    } else if (opcionAlumnoBuscar == 2) {
                        System.out.println("Ingrese el Nombre del alumno: ");
                        nombreBuscar = leer.readLine();
                        System.out.println("Ingrese el Apellido del alumno: ");
                        apellidoBuscar = leer.readLine();
                        Alumno alumno = gestionAlumnos.buscarAlumno(nombreBuscar, apellidoBuscar);
                        if (alumno != null) {
                            alumno.mostrarResumen();
                        } else {
                            System.out.println("El alumno no ha sido encontrado");
                        }
                    } else {
                        System.out.println("Opcion invalida.");
                    }

                } else if (opcionAlumnos == 3) {

                    gestionAlumnos.mostrarAlumnos();

                } else if (opcionAlumnos == 4) {

                    System.out.print("RUT: ");
                    String rut = leer.readLine();
                    System.out.print("Codigo de curso: ");
                    String codigo = leer.readLine();

                    if (gestionAlumnos.registrarAlumno(rut, codigo)) {
                        System.out.println("Alumno registrado con exito!");
                        System.out.println("----------------------------");
                    } else {
                        System.out.println("Error al registrar alumno");
                        System.out.println("-------------------------");
                    }
                } else if (opcionAlumnos == 5) {
                    System.out.println("RUT del alumno que se edita: ");
                    String rut = leer.readLine();

                    gestionAlumnos.obtenerAlumno(rut);

                    System.out.println("Nuevo nombre: ");
                    String nuevoNombre = leer.readLine();
                    System.out.println("Nuevo apellido: ");
                    String nuevoApellido = leer.readLine();

                    if (gestionAlumnos.editarAlumno(rut, nuevoNombre, nuevoApellido)) {
                        System.out.println("Alumno editado con exito!");
                    } else {
                        System.out.println("No existe un alumno con ese RUT");
                    }

                } else if (opcionAlumnos != 6) {
                    System.out.println("Opcion invalida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero de las opciones del menu.");
            } catch (AlumnoNoEncontradoException | CursoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        } while (opcionAlumnos != 6);
    }
}
