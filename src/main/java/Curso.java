
import java.util.ArrayList;

public class Curso {

    private String nombre;
    private String codigo;
    private String profesorJefe;
    private final ArrayList<Alumno> alumnos;

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
    
    public void mostrarAlumnos(){
        //revisar que existan alumnos en el arraylist
        if(alumnos.isEmpty()){
            System.out.println("No hay alumnos en este curso");
            return;
        }
        //iterar sobre el arraylist y printear los atributos de los alumnos
        for(Alumno alumno : alumnos){
            System.out.println(alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido());
        }
        
    }

}
