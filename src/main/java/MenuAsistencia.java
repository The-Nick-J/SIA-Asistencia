
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
        int opcionAsistencia = 0;
        String codigoCurso;
        Curso cursoAsistencia;
        String presente;
        do {
            System.out.println("Bienvenido al Menu de Asistencia");
            System.out.println("1. Pasar Asistencia");
            System.out.println("2. Registrar una falta justificada");
            System.out.println("3. Registrar salida anticipada");
            System.out.println("4. Mostrar alumnos ausentes del colegio en fecha");
            System.out.println("5. Consultar asistencia de un curso por fecha");
            System.out.println("6. Consultar asistencia de un alumno");
            System.out.println("7. Modificar asistencia de un alumno");
            System.out.println("8. Volver al menu principal");

            String entrada = leer.readLine();

            if (entrada == null) {
                return;
            }

            try {
                opcionAsistencia = Integer.parseInt(entrada);

                switch (opcionAsistencia) {
                    case 1:
                        System.out.println("Ingrese el codigo del curso en el que pasara asistencia:");
                        codigoCurso = leer.readLine();
                        cursoAsistencia = gestionCursos.obtenerCurso(codigoCurso);

                        if (cursoAsistencia.getAlumnos().isEmpty()) {
                            System.out.println("ERROR: El curso no tiene alumnos registrados.");
                            break;
                        }

                        System.out.println("Ingrese la fecha de la asistencia (AAAA-MM-DD):");
                        LocalDate fechaAsistencia;

                        fechaAsistencia = LocalDate.parse(leer.readLine());

                        if (gestionRegistroAsistencia.existeAsistenciaRegistrada(cursoAsistencia, fechaAsistencia)) {
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
                                gestionRegistroAsistencia.registrarAsistencia(alumno, fechaAsistencia, true, null);
                            } else {
                                System.out.println("Ingrese una justificacion o presione Enter para dejar la falta sin justificar:");
                                String justificacion = leer.readLine().trim();
                                gestionRegistroAsistencia.registrarAsistencia(alumno, fechaAsistencia, false, justificacion);
                            }

                        }
                        break;
                    case 2:
                        String rutAlumno;
                        Alumno alumno;
                        String justificacion;
                        String fechaTexto;

                        System.out.println("Ingrese el RUT del alumno: ");
                        rutAlumno = leer.readLine();
                        
                        alumno = gestionAlumnos.obtenerAlumno(rutAlumno);

                        System.out.println("Ingrese la fecha de la falta a justificar (AAAA-MM-DD):");
                        fechaTexto = leer.readLine();
                        LocalDate fechaFalta;

                        fechaFalta = LocalDate.parse(fechaTexto);

                        System.out.println("Ingrese la justificacion: ");
                        justificacion = leer.readLine().trim();

                        if (justificacion.isEmpty()) {
                            System.out.println("Debe ingresar una justificacion.");
                            break;
                        }

                        boolean resultado = gestionRegistroAsistencia.registrarFaltaJustificada(alumno, fechaFalta, justificacion);

                        if (resultado == true) {
                            System.out.println("La falta ha sido justificada correctamente");
                        } else {
                            System.out.println("La falta no pudo ser justificada");
                        }
                        break;
                    case 3:
                        String rut;
                        Alumno alumnoSalida;
                        String fechaTextoSalida;
                        LocalDate fecha;
                        String motivo;

                        System.out.println("Ingrese el RUT del alumno: ");
                        rut = leer.readLine();

                        alumnoSalida = gestionAlumnos.obtenerAlumno(rut);

                        System.out.println("Ingrese la fecha de la salida anticipada (AAAA-MM-DD): ");
                        fechaTextoSalida = leer.readLine();

                        fecha = LocalDate.parse(fechaTextoSalida);

                        System.out.println("Ingrese el motivo de la salida: ");
                        motivo = leer.readLine();

                        boolean salidaRegistrada = gestionRegistroAsistencia.registrarSalidaAnticipada(alumnoSalida, fecha, motivo);

                        if (salidaRegistrada) {
                            System.out.println("Salida anticipada registrada correctamente");
                        } else {
                            System.out.println("No se pudo registrar la salida anticipada");
                        }
                        break;
                    case 4:
                        String fechaTextoConsulta;
                        LocalDate fechaConsulta;

                        System.out.println("Ingrese la fecha que desea revisar la asistencia en formato (AAAA-MM-DD): ");
                        fechaTextoConsulta = leer.readLine();

                        fechaConsulta = LocalDate.parse(fechaTextoConsulta);

                        gestionRegistroAsistencia.mostrarAusentesPorFecha(fechaConsulta);
                        break;
                    case 5:
                        String fechaTextoBuscar;
                        LocalDate fechaBuscar;
                        String codigoCursoBuscar;
                        Curso cursoBuscar;

                        System.out.println("Ingrese la fecha que desea revisar en formato (AAAA-MM-DD)");
                        fechaTextoBuscar = leer.readLine();

                        fechaBuscar = LocalDate.parse(fechaTextoBuscar);

                        System.out.println("Ingrese el codigo del curso a buscar: ");
                        codigoCursoBuscar = leer.readLine();

                        cursoBuscar = gestionCursos.obtenerCurso(codigoCursoBuscar);

                        gestionRegistroAsistencia.mostrarAsistenciaPorFechaYCurso(cursoBuscar, fechaBuscar);

                        break;
                    case 6:
                        System.out.println("Ingrese el rut del alumno a consultar: ");
                        String rutConsulta = leer.readLine();
                        
                        Alumno alumnoConsulta = gestionAlumnos.obtenerAlumno(rutConsulta);

                        gestionRegistroAsistencia.mostrarAsistenciaPorAlumno(alumnoConsulta);
                        break;
                    case 7:
                        System.out.println("Ingrese el RUT del alumno: ");
                        String rutModificar = leer.readLine();
                        Alumno alumnoModificar = gestionAlumnos.obtenerAlumno(rutModificar);
                        
                        if(alumnoModificar == null){
                            System.out.println("No existe un alumno con ese RUT.");
                            break;
                        }
                        
                        System.out.println("Ingrese la fecha de la asistencia a modificar (AAAA-MM-DD)");
                        LocalDate fechaModificar = LocalDate.parse(leer.readLine());
                        
                        Asistencia asistenciaActual = gestionRegistroAsistencia.buscarAsistencia(alumnoModificar, fechaModificar);
                        
                        if(asistenciaActual == null){
                            System.out.println("No hay asistencia registrada en esa fecha.");
                            break;
                        }
                        
                        if(asistenciaActual.isPresente()){
                            System.out.println("Estado actual: Presente");
                            System.out.println("¿Desea marcarlo como AUSENTE? (S/N)");
                            
                            String resp = leer.readLine().trim().toUpperCase();
                            if(resp.equals("S")){
                                gestionRegistroAsistencia.modificarAsistencia(alumnoModificar, fechaModificar, false);
                                System.out.println("Asistencia modificada a AUSENTE correctamente.");
                            }else System.out.println("No se realizaron cambios");
                        }else{
                            System.out.println("Estado actual: Ausente");
                            System.out.println("¿Desea marcarlo como PRESENTE? (S/N)");
                            
                            String resp = leer.readLine().trim().toUpperCase();
                            if(resp.equals("S")){
                                gestionRegistroAsistencia.modificarAsistencia(alumnoModificar, fechaModificar, true);
                                System.out.println("Asistencia modificada a PRESENTE correctamente.");
                            }else System.out.println("No se realizaron cambios");
                        }
                        
                        
                        
                        break;
                    case 8:
                    
                        break;
                    default:
                        System.out.println("Ingrese una opción valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero de las opciones del menu.");
            } catch (DateTimeParseException e) {
                System.out.println("El formato de fecha ingresado no es valido. Use AAAA-MM-DD.");
            } catch (AlumnoNoEncontradoException | CursoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        } while (opcionAsistencia != 8);

    }
}
