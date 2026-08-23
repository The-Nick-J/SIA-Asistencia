import java.util.*;
import java.time.*;

public class GestionRegistroAsistencia{
    
    /*Este HashMap usa de key el rut del alumno, y su value es un ArrayList
    que contendra todas las asistencias correspondiente a un alumno
    */
    private final HashMap<String,ArrayList<Asistencia>> registrosAsistencia;
    
    //el HashMap se declara en atributos y se inicializa en el constructor
    public GestionRegistroAsistencia(){
        this.registrosAsistencia = new HashMap<>();
    }
    
    /*Agrega una asistencia al alumno correspondiente, el metodo se encarga
    de revisar si ya hay asistencia para ese dia
    */
    public boolean agregarRegistroAsistencia(Asistencia nuevaAsistencia){
        String rut = nuevaAsistencia.getAlumno().getRut();
        
        if(!registrosAsistencia.containsKey(rut)){
             registrosAsistencia.put(rut, new ArrayList<>());
        }
        
        ArrayList<Asistencia> asistenciaAlumno = registrosAsistencia.get(rut);
        for(Asistencia asistencia : asistenciaAlumno){
            if(asistencia.getFecha().equals(nuevaAsistencia.getFecha())){
                System.out.println("ERROR: El alumno ya tiene una asistencia registrada en esa fecha");
                return false;
            }
        }
        asistenciaAlumno.add(nuevaAsistencia);
        return true;
    }
   
    //Retorna un ArrayList de todas las asistencias registradas de un alumno
    public ArrayList<Asistencia> buscarRegistroAsistencia(Alumno alumno){
        if(alumno != null && registrosAsistencia.containsKey(alumno.getRut())){
            return registrosAsistencia.get(alumno.getRut());
        }
        return null;
    }
    //Retorna un ArrayList de todas las asistencias registradas en una fecha
    public ArrayList<Asistencia> buscarRegistroAsistencia(LocalDate fecha){
        ArrayList<Asistencia> asistenciasFecha = new ArrayList<>();
        for(ArrayList<Asistencia> asistenciasAlumno : registrosAsistencia.values()){
            for(Asistencia asistencia : asistenciasAlumno){
                if(asistencia.getFecha().equals(fecha)){
                    asistenciasFecha.add(asistencia);
                }
            }
        }
        return asistenciasFecha;
    }
    
    public boolean existeAsistenciaRegistrada(Curso curso, LocalDate fecha){
        if(curso.getAlumnos().isEmpty()){
            return false;
        }
        
        String rut = curso.getAlumnos().get(0).getRut();
        
        if(registrosAsistencia.get(rut) == null || registrosAsistencia.get(rut).isEmpty()){
            return false;
        }
        for(Asistencia asistencia : registrosAsistencia.get(curso.getAlumnos().get(0).getRut())){
            if(asistencia.getFecha().equals(fecha)){
                return true;
            }
        }
        
        return false;
    }
    //print las asistencias del arraylist y sus datos, dado que asistencia no tiene metodo mostrar
    public void mostrarRegistros(){
        if(registrosAsistencia.isEmpty()){
            System.out.println("No hay registros de asistencia en el sistema.");
            return;
        }
        for(ArrayList<Asistencia> asistenciasAlumno : registrosAsistencia.values()){   
            for(Asistencia asistencia : asistenciasAlumno){
                System.out.println("Fecha: " + asistencia.getFecha());
                System.out.println("Alumno: " + asistencia.getAlumno().getNombre() +" "+asistencia.getAlumno().getApellido());
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
                System.out.println("\n--------------\n");
            }
        }
    }

    public HashMap<String, ArrayList<Asistencia>> getRegistrosAsistencia() {
        return registrosAsistencia;
    }
    
}