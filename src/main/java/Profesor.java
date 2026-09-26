
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
    public String obtenerResumen() {
        String resumen = "-----Datos del Profesor-----\nRUT: " + this.getRut() + "\nNombre: " + this.getNombre() + "\nApellido: " + this.getApellido();

        if (this.asignatura != null && !this.asignatura.isBlank()) {
            resumen += "\nAsignatura: " + this.getAsignatura();
        } else {
            resumen += "\nAsignatura: Sin Asignatura Asignada";
        }

        return resumen;
    }
}
