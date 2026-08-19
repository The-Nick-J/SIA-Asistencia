
public class Persona {
	private String rut;
    private String nombre;
    private String apellido;
    
    public Persona(String rut, String nombre, String apellido) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    public String getRut() {
        return rut;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String mostrarResumen() {
    	return this.rut + ", " + this.nombre + ", " + this.apellido;
    }
}
