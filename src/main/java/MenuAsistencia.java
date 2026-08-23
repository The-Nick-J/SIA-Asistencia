
import java.io.BufferedReader;
import java.io.IOException;
import java.time.*;
import java.time.format.*;

public class MenuAsistencia {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;
    private final GestionRegistroAsistencia gestionRegistroAsistencia;
    private final GestionAlumnos gestionAlumnos;

    public MenuAsistencia(BufferedReader leer, GestionCursos gestionCursos, GestionRegistroAsistencia gestionRegistroAsistencia, GestionAlumnos gestionAlumnos) {
        this.leer = leer;
        this.gestionCursos = gestionCursos;
        this.gestionRegistroAsistencia = gestionRegistroAsistencia;
        this.gestionAlumnos = gestionAlumnos;
    }

    public void mostrarMenu() throws IOException {
        int opcionAsistencia;
        String codigoCurso;
        Curso cursoAsistencia;
        LocalDate fechaActual = LocalDate.now();
        String presente;
        do {
            System.out.println("Bienvenido al Menu de Asistencia");
            System.out.println("1. Pasar Asistencia");
            System.out.println("2. Registrar una Inasistencia Extraordinaria");
            System.out.println("3. Registrar salida anticipada");
            System.out.println("4. Consultar Asistencia");
            System.out.println("5. Volver al menu principal");
            opcionAsistencia = Integer.parseInt(leer.readLine());

            switch (opcionAsistencia) {
                case 1:
                    System.out.println("Ingrese el codigo del curso en el que pasara asistencia:");
                    codigoCurso = leer.readLine();
                    cursoAsistencia = gestionCursos.getCursos().get(codigoCurso);
                    if (cursoAsistencia == null) {
                        System.out.println("ERROR: No existe un curso con este codigo.");
                        break;
                    }

                    if (gestionRegistroAsistencia.existeAsistenciaRegistrada(cursoAsistencia, fechaActual)) {
                        System.out.println("ERROR: Ya se tomo asistencia para este curso.");
                        break;
                    }

                    System.out.println("Para cada alumno, ingrese 'S' si esta presente o 'N' si esta ausente");
                    for (Alumno alumno : cursoAsistencia.getAlumnos()) {
                        System.out.println("Alumn@: " + alumno.getNombre() + " " + alumno.getApellido());
                        System.out.println("Presente?");
                        do {
                            presente = leer.readLine().trim().toUpperCase();
                            if (!presente.equals("S") && !presente.equals("N")) {
                                System.out.println("Ingrese una opcion valida.");
                            }
                        } while (!presente.equals("S") && !presente.equals("N"));
                        if (presente.equals("S")) {
                            gestionRegistroAsistencia.agregarRegistroAsistencia(new Asistencia(fechaActual, alumno, true));
                        } else {
                            gestionRegistroAsistencia.agregarRegistroAsistencia(new Asistencia(fechaActual, alumno, false));
                        }

                    }
                    break;
                case 2:
                    String rutAlumno;
                    Alumno alumno;
                    String motivoInasistencia;
                    String fechaTexto;

                    System.out.println("Ingrese el RUT del alumno: ");
                    rutAlumno = leer.readLine();
                    alumno = gestionAlumnos.buscarAlumno(rutAlumno);

                    if (alumno == null) {
                        System.out.println("Alumno no encontrado");
                        break;
                    }

                    System.out.println("Ingrese la fecha de Inasistencia a justificar (AAAA-MM-DD):");
                    fechaTexto = leer.readLine();
                    LocalDate fechaInasistencia;

                    try {
                        fechaInasistencia = LocalDate.parse(fechaTexto);
                    } catch (DateTimeParseException e) {
                        System.out.println("El formato de fecha ingresado no es valido");
                        break;
                    }

                    System.out.println("Ingrese la justificacion: ");
                    motivoInasistencia = leer.readLine();

                    boolean resultado = gestionRegistroAsistencia.registrarInasistenciaExtraordinaria(alumno, fechaInasistencia, motivoInasistencia);
                    
                    if(resultado == true) {
                        System.out.println("La asistencia ha sido justificada correctamente");
                    } else { 
                        System.out.println("La asistencia no pudo ser justificada");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ingrese una opción valida.");
                    break;
            }

        } while (opcionAsistencia != 5);

    }
}
