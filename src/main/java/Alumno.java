
public class Alumno extends Persona {
	private Curso curso;
    
    public Alumno(String rut, String nombre, String apellido) {
    	super(rut,nombre,apellido);
    }
    
    public void setCurso(Curso curso) {
    	this.curso = curso;
    }
    
    @Override
    public String mostrarResumen() {
    	String nombre = this.getNombre();
    	String rut = this.getRut();
    	String apellido = this.getApellido();
    	
    	if(curso != null) {
    		return rut + ", " + nombre + ", " + apellido + ", " + this.curso.getCodigo();
    	} else {
    		return rut + ", " + nombre + ", " + apellido + ", " + "Sin curso";
    	}
    }
}
