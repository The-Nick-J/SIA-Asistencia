import java.util.*;
import java.time.*;

public class GestionRegistroAsistencia{
    private ArrayList<Asistencia> registrosAsistencia;
    
    //el arraylist se declara en atributos y se inicializa en el constructor
    public GestionRegistroAsistencia(){
        this.registrosAsistencia = new ArrayList<Asistencia>();
    }
    
    public void agregarRegistroAsistencia(Asistencia nuevaAsistencia){
        for(Asistencia asistencia : registrosAsistencia){
            boolean alumno = asistencia.getAlumno().getRut().equals(nuevaAsistencia.getAlumno().getRut());
            boolean fecha = asistencia.getFecha().equals(nuevaAsistencia.getFecha());
            
            if(alumno && fecha){
                System.out.println("ERROR: El alumno ya tiene una asistencia registra en esa fecha");
                return;
            }
        }
        registrosAsistencia.add(nuevaAsistencia);
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