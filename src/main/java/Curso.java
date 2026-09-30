
import java.util.ArrayList;

public class Curso {

    private String nombre;
    private String codigo;
    private Profesor profesorJefe;
    private final ArrayList<Alumno> alumnos;

    public Curso(String nombre, String codigo, Profesor profesorJefe) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.profesorJefe = profesorJefe;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public Profesor getProfesorJefe() {
        return profesorJefe;
    }

    public ArrayList<Alumno> getAlumnos() {
        return new ArrayList<>(alumnos);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setProfesorJefe(Profesor profesorJefe) {
        this.profesorJefe = profesorJefe;
    }
    public boolean addAlumno(Alumno alumno) {
        if(buscarAlumno(alumno.getRut()) != null){
            return false;
        }
        this.alumnos.add(alumno);
        return true;
    }
    
    public Alumno buscarAlumno(String rut){
        for(Alumno alumno : alumnos){
            if(alumno.getRut().equals(rut)){
                return alumno;
            }
        }
        return null;
    }
    
    public boolean eliminarAlumno(String rut) {
        Alumno alumno = buscarAlumno(rut);

        if (alumno == null) {
            return false;
        }

        alumnos.remove(alumno);
        return true;
    }

    public String obtenerListadoAlumnos() {
        if (alumnos.isEmpty()) {
            return "No hay alumnos en este curso";
        }

        String resultado = "";
        for (Alumno alumno : alumnos) {
            resultado += alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido() + "\n";
        }

        return resultado;
    }

}
