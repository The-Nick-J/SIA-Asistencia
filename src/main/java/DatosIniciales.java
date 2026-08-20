import java.time.LocalDate;

public class DatosIniciales {

    public static void main(String[] args) {

        Curso curso = new Curso(
                "1ro Medio A",
                "1MA",
                "John Java"
        );

        Alumno alumno1 = new Alumno("20.123.456-7", "Mike", "Ceplus");
        Alumno alumno2 = new Alumno("21.987.654-3", "Carla", "Python");

        curso.addAlumno(alumno1);
        curso.addAlumno(alumno2);

        Asistencia asistencia = new Asistencia(
                LocalDate.now(),
                alumno1,
                true,
                false,
                false,
                null,
                null
        );

        System.out.println("Curso: " + curso.getNombre());
        System.out.println("Código: " + curso.getCodigo());
        System.out.println("Profesor jefe: " + curso.getProfesorJefe());

        System.out.println("\nAlumnos:");
        for (Alumno alumno : curso.getAlumnos()) {
            System.out.println("- " + alumno.getNombre() + " "
                    + alumno.getApellido() + " | RUT: " + alumno.getRut());
        }

        System.out.println("\nAsistencia:");
        System.out.println("Fecha: " + asistencia.getFecha());
        System.out.println("Alumno: " + asistencia.getAlumno().getNombre());
        System.out.println("Presente: " + asistencia.isPresente());

        // Probar setters
        alumno1.setNombre("Ana María");
        curso.setProfesorJefe("Pedro Ramírez");
        asistencia.setRetirado(true);

        System.out.println("\nDatos modificados:");
        System.out.println("Alumno: " + alumno1.getNombre());
        System.out.println("Profesor jefe: " + curso.getProfesorJefe());
        System.out.println("¿Retirado?: " + asistencia.isRetirado());
    }
}