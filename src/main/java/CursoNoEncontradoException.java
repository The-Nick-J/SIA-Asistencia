
public class CursoNoEncontradoException extends Exception {

    public CursoNoEncontradoException(String codigo) {
        super("No existe un curso con el codigo: " + codigo);
    }
}