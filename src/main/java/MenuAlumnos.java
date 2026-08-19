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
        String alumnoBuscar;

        do {
            System.out.println("Bienvenido al Menu de Gestion de Alumnos");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Mostrar Alumno");
            System.out.println("3. Mostrar Todos los Alumnos");
            System.out.println("4. Registrar Alumno en Curso");
            System.out.println("5. Volver al Menu de Administracion");
            opcionAlumnos = Integer.parseInt(leer.readLine());
            if(opcionAlumnos == 1){
                //promptea al usuario por los datos
                System.out.print("RUT: ");
                String rut = leer.readLine();
                System.out.print("Nombre: ");
                String nombre = leer.readLine();
                System.out.print("Apellido: ");
                String apellido = leer.readLine();
                
                
                if(gestionAlumnos.agregarAlumno(rut, nombre, apellido)){
                    System.out.println("Alumno agregado con exito!");
                    System.out.println("--------------------------");
                } else {
                    System.out.println("Error al agregar alumno");
                    System.out.println("-----------------------");
                }
                
                
            } else if(opcionAlumnos == 2) { 
            	
            	System.out.println("Ingrese el RUT del alumno que desea mostrar:");
            	alumnoBuscar = leer.readLine();
            	//quiza es buena idea cambiar arraylist de alumnos por map?
            	Alumno alumno = gestionAlumnos.mostrarAlumno(alumnoBuscar);
            	if(alumno != null) {
            		alumno.mostrarResumen();
            	} else {
            		System.out.println("el RUT ingresado no tiene un alumno asociado");
            	}
            	
            	
            	
            } else if(opcionAlumnos == 3){
            	
            	gestionAlumnos.mostrarAlumnos();
            	
            } else if (opcionAlumnos == 4){
                
            	System.out.print("RUT: ");
                String rut = leer.readLine();
                System.out.print("Codigo de curso: ");
                String codigo = leer.readLine();
                
                if(gestionAlumnos.registrarAlumno(rut,codigo)){
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
