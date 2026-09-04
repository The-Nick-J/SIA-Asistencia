import java.time.*;

public class Asistencia {
    private LocalDate fecha;
    private Alumno alumno;
    private boolean presente;
    private boolean faltaJustificada;
    private String justificacion;
    private String motivoSalida;
    private boolean retirado;

    public Asistencia(LocalDate fecha, Alumno alumno, boolean presente, boolean retirado, boolean faltaJustificada, String justificacion, String motivoSalida) {
        this.fecha = fecha;
        this.alumno = alumno;
        this.presente = presente;
        this.retirado = retirado;
        this.faltaJustificada = faltaJustificada;
        this.justificacion = justificacion;
        this.motivoSalida = motivoSalida;
    }
    
    public Asistencia(LocalDate fecha, Alumno alumno, boolean presente) {
        this.fecha = fecha;
        this.alumno = alumno;
        this.presente = presente;
        this.retirado = false;
        this.faltaJustificada = false;
        this.justificacion = null;
        this.motivoSalida = null;
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
    
    public boolean comprobarDatosAsistencia (LocalDate fecha){
        return this.fecha.equals(fecha);
    }
    
    public boolean comprobarDatosAsistencia (Alumno alumno){
        return this.alumno.equals(alumno);
    }
    
    public boolean isFaltaJustificada() {
        return this.faltaJustificada;
    }
    
    public void setFaltaJustificada(boolean faltaJustificada) {
        this.faltaJustificada = faltaJustificada;
    }
    
    public String getJustificacion() {
        return this.justificacion;
    }
    
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    public String getMotivoSalida() {
        return this.motivoSalida;
    }
    
    public void setMotivoSalida(String motivoSalida) {
        this.motivoSalida = motivoSalida;
    }
}

    
