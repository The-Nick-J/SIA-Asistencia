
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
    
    @Override
    public void mostrarResumen() {
    	String nombre = this.getNombre();
    	String rut = this.getRut();
    	String apellido = this.getApellido();
    	
    	if(this.curso != null) {
    		System.out.println("-----Datos del Alumno-----");
    		System.out.println("RUT: " + rut);
    		System.out.println("Nombre: " + nombre);
    		System.out.println("Apellido: " + apellido);
    		System.out.println("Curso: " + this.getCodigoCurso());
    	} else {
    		System.out.println("-----Datos del Alumno-----");
    		System.out.println("RUT: " + rut);
    		System.out.println("Nombre: " + nombre);
    		System.out.println("Apellido: " + apellido);
    		System.out.println("Curso: Sin curso asignado");
    	}
    }
}
