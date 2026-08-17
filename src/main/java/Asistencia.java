import java.time.*;

public class Asistencia {
    private LocalDate fecha;
    private Alumno alumno;
    private boolean presente;
    private boolean retirado;

    public Asistencia(LocalDate fecha, Alumno alumno, boolean presente, boolean retirado) {
        this.fecha = fecha;
        this.alumno = alumno;
        this.presente = presente;
        this.retirado = retirado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public boolean isRetirado() {
        return retirado;
    }

    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }
    
    public Boolean comprobarDatosAsistencia (LocalDate fecha){
        return this.fecha.equals(fecha);
    }
    
    public Boolean comprobarDatosAsistencia (Alumno alumno){
        return this.alumno.equals(alumno);
    }
}
