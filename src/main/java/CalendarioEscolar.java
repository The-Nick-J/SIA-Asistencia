
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.DayOfWeek;

public class CalendarioEscolar {

    private int anio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<LocalDate> feriados;

    public CalendarioEscolar(int anio, LocalDate fechaInicio, LocalDate fechaFin) {
        this.anio = anio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.feriados = new ArrayList<>();
    }

    public void agregarFeriado(LocalDate feriado) {
        feriados.add(feriado);
    }

    public boolean esDiaLectivo(LocalDate fecha) {
        if (fecha.isBefore(fechaInicio) || fecha.isAfter(fechaFin)) {
            return false;
        }

        if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY
                || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }

        if (feriados.contains(fecha)) {
            return false;
        }

        return true;
    }

    public int contarDiasLectivos() {
        int cantidad = 0;
        LocalDate fechaActual = fechaInicio;

        while (!fechaActual.isAfter(fechaFin)) {
            if (esDiaLectivo(fechaActual)) {
                cantidad++;
            }

            fechaActual = fechaActual.plusDays(1);
        }

        return cantidad;
    }

    public int getAnio() {
        return anio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public ArrayList<LocalDate> getFeriados() {
        return feriados;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFeriados(ArrayList<LocalDate> feriados) {
        this.feriados = feriados;
    }

    
    // mas adelante aca quiero poner tipo un CSV para que carguemos los feriados mas facil,.
}
