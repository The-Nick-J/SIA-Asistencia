import java.time.LocalDate;

public class DatosIniciales {

    public static void cargarDatos(GestionCursos gestionCursos, GestionAlumnos gestionAlumnos, GestionRegistroAsistencia gestionRegistroAsistencia) throws AlumnoNoEncontradoException, CursoNoEncontradoException {

        String codigoCurso = "curso";
        String rutAlumno1 = "11111111-1";
        String rutAlumno2 = "22222222-2";

        // crear
        gestionCursos.agregarCurso("curso",codigoCurso,"profesor");
        gestionAlumnos.agregarAlumno(rutAlumno1,"xxxx","yyyy");
        gestionAlumnos.agregarAlumno(rutAlumno2,"oooo","zzzz");

        Alumno alumno1 = gestionAlumnos.obtenerAlumno(rutAlumno1);
        Alumno alumno2 = gestionAlumnos.obtenerAlumno(rutAlumno2);

        // registrar
        gestionAlumnos.registrarAlumno(rutAlumno1, codigoCurso);
        gestionAlumnos.registrarAlumno(rutAlumno2, codigoCurso);
        
        LocalDate fecha1 = LocalDate.of(2026, 8, 10);
        LocalDate fecha2 = LocalDate.of(2026, 8, 11);
        LocalDate fecha3 = LocalDate.of(2026, 8, 12);

        // test1 presente y ausente
        if (gestionRegistroAsistencia.buscarAsistencia(alumno1, fecha1) == null) {
            gestionRegistroAsistencia.registrarAsistencia(alumno1,fecha1,true,null);
        }

        if (gestionRegistroAsistencia.buscarAsistencia(alumno2, fecha1) == null) {
            gestionRegistroAsistencia.registrarAsistencia(alumno2,fecha1,false,null);
        }

        // test2 inasistencia con justificacion
        if (gestionRegistroAsistencia.buscarAsistencia(alumno1, fecha2) == null) {
            gestionRegistroAsistencia.registrarAsistencia(alumno1,fecha2,false,"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }

        // test3 presente
        if (gestionRegistroAsistencia.buscarAsistencia(alumno2, fecha2) == null) {
            gestionRegistroAsistencia.registrarAsistencia(alumno2,fecha2,true,null);
        }

        // test4 retirado
        if (gestionRegistroAsistencia.buscarAsistencia(alumno1, fecha3) == null) {
            gestionRegistroAsistencia.registrarSalidaAnticipada(alumno1,fecha3,"oooooooooooooooooooooo");
        }
    }
}