
public class Profesor extends Persona {

    private String asignatura;

    public Profesor(String rut, String nombre, String apellido, String asignatura) {
        super(rut, nombre, apellido);
        this.asignatura = asignatura;
    }
    
    public String getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    
    @Override
    public void mostrarResumen() {
    	String nombre = this.getNombre();
    	String rut = this.getRut();
    	String apellido = this.getApellido();
    	
    	if(this.asignatura != null) {
    		System.out.println("-----Datos del Profesor-----");
    		System.out.println("RUT: " + rut);
    		System.out.println("Nombre: " + nombre);
    		System.out.println("Apellido: " + apellido);
    		System.out.println("Asignatura: " + this.getAsignatura());
    	} else {
    		System.out.println("-----Datos del Profesor-----");
    		System.out.println("RUT: " + rut);
    		System.out.println("Nombre: " + nombre);
    		System.out.println("Apellido: " + apellido);
    		System.out.println("Asignatura: Sin Asignatura Asignada");
    	}
    }
}
