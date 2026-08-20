import java.util.*;
import java.time.*;

public class GestionRegistroAsistencia{
    private ArrayList<Asistencia> registrosAsistencia;
    
    //el arraylist se declara en atributos y se inicializa en el constructor
    public void GestionRegistrosAsistencias(){
        this.registrosAsistencia = new ArrayList<Asistencia>();
    }
    
    public void agregarRegistroAsistencia(Asistencia asistencia){
        //validacion si el alumno de esta asistencia ya esta en el registro Y la fecha de esta asistencia es la misma que la de la asistencia del alumno que ya esta, quiere decir que esta repitiendo alumno Y fecha, NO PERMITIDO
        if(buscarRegistroAsistencia(asistencia.getAlumno()) != null && asistencia.getFecha() == buscarRegistroAsistencia(asistencia.getAlumno()).getFecha()){
            System.out.println("ERROR! No se puede registrar asistencia dos veces en un mismo dia para el mismo alumno!");
        } else {
            this.registrosAsistencia.add(asistencia);
        }
    }
   
    //metodo para buscar por alumno, utiliza sobrecarga
    public Asistencia buscarRegistroAsistencia(Alumno alumno){
        for(Asistencia asistencia : registrosAsistencia){
            if(asistencia.getAlumno().equals(alumno)){
                return asistencia;
            }
        }
        return null;
    }
    //metodo para buscar por fecha, utiliza sobrecarga
    public Asistencia buscarRegistroAsistencia(LocalDate fecha){
        for(Asistencia asistencia : registrosAsistencia){
            if(asistencia.getFecha().equals(fecha)){
                return asistencia;
            }
        }
        return null;
    }
    //print las asistencias del arraylist y sus datos, dado que asistencia no tiene metodo mostrar
    public void mostrarRegistros(){
        for(Asistencia asistencia : registrosAsistencia){
            System.out.println("Fecha: " + asistencia.getFecha());
            System.out.println("Alumno: " + asistencia.getAlumno());
            if(asistencia.isPresente()){
                System.out.println("Estado: Presente");
            } else {
                System.out.println("Estado: No presente");
            }
            if(asistencia.isRetirado()){
                System.out.println("Estado: Retirado");
            } else {
                System.out.println("Estado: No retirado");
            }
        }
    }
    
}