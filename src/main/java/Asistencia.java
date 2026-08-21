import java.time.*;

public class Asistencia {
    private LocalDate fecha;
    private Alumno alumno;
    private boolean presente;
    private boolean inasistenciaExtraordinaria;
    private String motivoInasistencia;
    private String motivoSalida;
    private boolean retirado;

    public Asistencia(LocalDate fecha, Alumno alumno, boolean presente, boolean retirado, boolean inasistenciaExtraordinaria, String motivoInasistencia, String motivoSalida) {
        this.fecha = fecha;
        this.alumno = alumno;
        this.presente = presente;
        this.retirado = retirado;
        this.inasistenciaExtraordinaria = inasistenciaExtraordinaria;
        this.motivoInasistencia = motivoInasistencia;
        this.motivoSalida = motivoSalida;
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
    
    public boolean isInasistenciaExtraordinaria() {
        return this.inasistenciaExtraordinaria;
    }
    
    public void setInasistenciaExtraordinaria(boolean inasistenciaExtraordinaria) {
        this.inasistenciaExtraordinaria = inasistenciaExtraordinaria;
    }
    
    public String getMotivoInasistencia() {
        return this.motivoInasistencia;
    }
    
    public void setMotivoInasistencia(String motivoInasistencia) {
        this.motivoInasistencia = motivoInasistencia;
    }
    
    public String getMotivoSalida() {
        return this.motivoSalida;
    }
    
    public void setMotivoSalida(String motivoSalida) {
        this.motivoSalida = motivoSalida;
    }
}

    
