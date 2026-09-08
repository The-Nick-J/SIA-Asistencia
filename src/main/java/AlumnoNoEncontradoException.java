
public class AlumnoNoEncontradoException extends Exception {

    public AlumnoNoEncontradoException(String rut) {
        super("No existe un alumno con el RUT: " + rut);
    }
}