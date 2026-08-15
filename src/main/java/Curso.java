
import java.util.ArrayList;

public class Curso {

    private String nombre;
    private String codigo;
    private String profesorJefe;
    private ArrayList<Alumno> alumnos;

    public Curso(String nombre, String codigo, String profesorJefe) {
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

    public String getProfesorJefe() {
        return profesorJefe;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setProfesorJefe(String profesorJefe) {
        this.profesorJefe = profesorJefe;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

}
