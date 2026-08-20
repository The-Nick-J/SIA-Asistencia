
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
            System.out.println("5. Volver al Menu de Administracion");
            opcionAlumnos = Integer.parseInt(leer.readLine());
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
                opcionAlumnoBuscar = Integer.parseInt(leer.readLine());
                if (opcionAlumnoBuscar == 1) {
                    System.out.println("Ingrese el RUT del alumno: ");
                    rutBuscar = leer.readLine();
                    Alumno alumno = gestionAlumnos.buscarAlumno(rutBuscar);
                    if (alumno != null) {
                        alumno.mostrarResumen();
                    } else {
                        System.out.println("El alumno no ha sido encontrado");
                    }
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

            }
        } while (opcionAlumnos != 5);
    }
}
