
public class Alumno extends Persona {
	private Curso curso;
    
    public Alumno(String rut, String nombre, String apellido) {
    	super(rut,nombre,apellido);
    }
    
    public void setCurso(Curso curso) {
    	this.curso = curso;
    }
    
    public String getCodigoCurso() {
    	return this.curso.getCodigo();
    }
    
    public Curso getCurso() {
    	return this.curso;
    }
    
    @Override
    public String obtenerResumen() {
        String resumen = "-----Datos del Alumno-----\nRUT: " + this.getRut() + "\nNombre: " + this.getNombre() + "\nApellido: " + this.getApellido();

        if (this.curso != null) {
            resumen += "\nCurso: " + this.getCodigoCurso();
        } else {
            resumen += "\nCurso: Sin curso asignado";
        }

        return resumen;
    }
   
    public String obtenerResumen(boolean formatoCorto) {
        if (!formatoCorto) {
            return obtenerResumen();
        }
        if (this.curso != null) {
            return this.getRut() + " - " + this.getNombre() + " " + this.getApellido() + " - Curso: " + this.getCodigoCurso();
        } else {
            return this.getRut() + " - " + this.getNombre() + " " + this.getApellido() + " - Sin curso asignado";
        }
    }
}
