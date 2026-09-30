
import java.util.*;

//clase que contiene todos los metodos para operaciones de gestion de cursos
public class GestionCursos {

    //inicializa un mapa vacio de cursos
    private final HashMap<String, Curso> cursos = new HashMap<>();
    
    public boolean agregarCurso(String nombre, String codigo, String rutProfesor, String nombreProfesor, String apellidoProfesor, String asignatura){
        Profesor profesor = new Profesor(rutProfesor, nombreProfesor, apellidoProfesor, asignatura);
        
        return agregarCurso(nombre, codigo, profesor);
    }
    
    public boolean agregarCurso(String nombre, String codigo, Profesor profesor) {
        //checkea si ya existe el curso con el codigo ingresado
        if (cursos.containsKey(codigo)) {
            return false;
        }
        //crea el curso con el input dado
        Curso nuevoCurso = new Curso(nombre, codigo, profesor);
        //se mete al mapa con key codigo y value objeto Curso nuevoCurso
        cursos.put(codigo, nuevoCurso);
        //return true si exito
        return true;
    }

    public Curso buscarCurso(String codigo) {
        return cursos.get(codigo);
    }

    public Curso obtenerCurso(String codigo) throws CursoNoEncontradoException {
        Curso curso = buscarCurso(codigo);

        if (curso == null) {
            throw new CursoNoEncontradoException(codigo);
        }

        return curso;
    }

    public String obtenerDetalleCurso(String codigo) {
        Curso mostrado = buscarCurso(codigo);
        if (mostrado == null) {
            return "No existe un curso con ese codigo";
        }
        
        Profesor profesor = mostrado.getProfesorJefe();
        String resumenProfesor = profesor == null ? "Sin profesor jefe asignado" : profesor.obtenerResumen();
        
        return "-------------------------------\nCodigo: " + mostrado.getCodigo() + "\nNombre: " + mostrado.getNombre() + "\nProfesor Jefe: " + resumenProfesor + "\nAlumnos: \n" + mostrado.obtenerListadoAlumnos();
    }

    public String obtenerListadoCursos() {
        if (cursos.isEmpty()) {
            return "No hay cursos registrados";
        }

        String resultado = "";
        for (String codigo : cursos.keySet()) {
            resultado += obtenerDetalleCurso(codigo) + "\n";
        }
        return resultado;
    }

    public HashMap<String, Curso> getCursos() {
        return new HashMap<>(cursos);
    }

    public boolean editarCurso(String codigo, String nuevoNombre, String rutProfesor, String nombreProfesor, String apellidoProfesor, String asignatura) {
        Curso curso = buscarCurso(codigo);
        if (curso == null) {
            return false;
        }
        
        Profesor profesor = new Profesor(rutProfesor, nombreProfesor, apellidoProfesor, asignatura);

        curso.setNombre(nuevoNombre);
        curso.setProfesorJefe(profesor);

        return true;
    }

    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCurso(codigo);

        if (curso == null) {
            return false;
        }

        for (Alumno alumno : curso.getAlumnos()) {
            alumno.setCurso(null);
        }

        cursos.remove(codigo);
        return true;
    }

}
