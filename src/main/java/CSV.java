import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class CSV {
    private final GestionCursos gestionCursos;
    private final GestionAlumnos gestionAlumnos;
    private final GestionRegistroAsistencia gestionRegistroAsistencia;
    private final Path carpetaDatos;
    
    public CSV(GestionCursos gestionCursos, GestionAlumnos gestionAlumnos, GestionRegistroAsistencia gestionRegistroAsistencia){
        this.gestionCursos = gestionCursos;
        this.gestionAlumnos = gestionAlumnos;
        this.gestionRegistroAsistencia = gestionRegistroAsistencia;
        this.carpetaDatos = Paths.get("datos");
    }
    
    public void guardarTodo() throws IOException{
        Files.createDirectories(carpetaDatos);
        guardarCursos();
        guardarAlumnos();
        guardarAsistencias();
    }
    
    private void guardarCursos() throws IOException{
        Path archivo = carpetaDatos.resolve("cursos.csv");
        
        try(BufferedWriter escribir = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)){
            escribir.write("codigo,nombre,profesorJefe");
            escribir.newLine();
            
            for(Curso curso : gestionCursos.getCursos().values()){
                escribir.write(formatear(curso.getCodigo()) + "," + formatear(curso.getNombre()) + "," + formatear(curso.getProfesorJefe()));
                escribir.newLine();
            }
        }
    }
    private void guardarAlumnos() throws IOException{
        Path archivo = carpetaDatos.resolve("alumnos.csv");
        
        try(BufferedWriter escribir = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)){
            escribir.write("rut,nombre,apellido,codigoCurso");
            escribir.newLine();
            
            for(Alumno alumno : gestionAlumnos.getAlumnos()){
                
                String codigoCurso = "";
                if(alumno.getCurso() != null){
                    codigoCurso = alumno.getCurso().getCodigo();
                }
                
                escribir.write(formatear(alumno.getRut()) + "," + formatear(alumno.getNombre()) + "," + formatear(alumno.getApellido()) + "," + formatear(codigoCurso));
                escribir.newLine();
            }
        }
    }
    
    private void guardarAsistencias() throws IOException{
        Path archivo = carpetaDatos.resolve("asistencias.csv");
        
        try(BufferedWriter escribir = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)){
            escribir.write("rut,fecha,presente,retirado,"+"faltaJustificada,justificacion,motivoSalida");
            escribir.newLine();
            
            for(String rut : gestionRegistroAsistencia.getRegistrosAsistencia().keySet()){
                for(Asistencia asistencia : gestionRegistroAsistencia.getRegistrosAsistencia().get(rut)){
                    escribir.write(formatear(rut) + "," + formatear(asistencia.getFecha().toString()) + "," + formatear(String.valueOf(asistencia.isPresente())) + "," + formatear(String.valueOf(asistencia.isRetirado())) + "," + formatear(String.valueOf(asistencia.isFaltaJustificada())) + "," + formatear(asistencia.getJustificacion()) + "," + formatear(asistencia.getMotivoSalida()));
                    escribir.newLine();
                }
            }
        }    
    }
    
    private String formatear(String texto){
        if(texto == null){
            return "";
        } else {
            return "\"" + texto.replace("\"", "\"\"") + "\"";
        }
    }
    
}
