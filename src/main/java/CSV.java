import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

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
    
    public void cargarTodo() throws IOException{
        if(!Files.exists(carpetaDatos)){
            Files.createDirectories(carpetaDatos);
            return;
        }
        
        cargarCursos();
        cargarAlumnos();
        cargarAsistencias();
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
    
    private void cargarCursos() throws IOException{
        Path archivo = carpetaDatos.resolve("cursos.csv");
        
        if(!Files.exists(archivo)) return;
        
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)){
            String linea = lector.readLine();
            
            while((linea = lector.readLine()) != null){
                if(linea.trim().isEmpty()) continue;
                
                String[] info = linea.split(",");
                if(info.length>=3){
                    String codigo = limpiar(info[0]);
                    String nombre = limpiar(info[1]);
                    String profesorJefe = limpiar(info[2]);
                    
                    gestionCursos.agregarCurso(nombre, codigo, profesorJefe);
                }
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
    
    private void cargarAlumnos() throws IOException{
        Path archivo = carpetaDatos.resolve("alumnos.csv");
        
        if(!Files.exists(archivo)) return;
        
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)){
            String linea = lector.readLine();
            
            while((linea = lector.readLine()) != null){
                if(linea.trim().isEmpty()) continue;
                
                String[] info = linea.split(",");
                if(info.length>=4){
                    String rut = limpiar(info[0]);
                    String nombre = limpiar(info[1]);
                    String apellido = limpiar(info[2]);
                    
                    gestionAlumnos.agregarAlumno(rut, nombre, apellido);
                    
                    if(info.length >= 4){
                        String codigoCurso = limpiar(info[3]);
                        
                        if(!codigoCurso.isEmpty()){
                            Curso curso = gestionCursos.buscarCurso(codigoCurso);
                            Alumno alumno = gestionAlumnos.buscarAlumno(rut);
                            
                            if(curso != null && alumno != null){
                                alumno.setCurso(curso);
                                curso.addAlumno(alumno);
                            }
                        }
                    }
                    
                    
                }
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
    
    private void cargarAsistencias() throws IOException{
        Path archivo = carpetaDatos.resolve("asistencias.csv");
        
        if(!Files.exists(archivo)) return;
        
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)){
            String linea = lector.readLine();
            
            while((linea = lector.readLine()) != null){
                if(linea.trim().isEmpty()) continue;
                
                String[] info = linea.split(",");
                if(info.length>=7){
                    String rut = limpiar(info[0]);
                    
                    Alumno alumno = gestionAlumnos.buscarAlumno(rut);
                    if(alumno == null) continue;
                    
                    
                    LocalDate fecha = LocalDate.parse(limpiar(info[1]));
                    boolean presente = Boolean.parseBoolean(limpiar(info[2]));
                    boolean retirado = Boolean.parseBoolean(limpiar(info[3]));
                    boolean faltaJustificada = Boolean.parseBoolean(limpiar(info[4]));
                    String justificacion = limpiar(info[5]);
                    String motivoSalida = limpiar(info[6]);
                    
                    Asistencia asistencia = new Asistencia(fecha, alumno, presente, retirado, faltaJustificada, justificacion, motivoSalida);
                    gestionRegistroAsistencia.agregarRegistroAsistencia(asistencia);
                    
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
    
    private String limpiar(String texto) {
    if (texto == null) return "";
    texto = texto.trim();
    if (texto.startsWith("\"") && texto.endsWith("\"") && texto.length() >= 2) {
        return texto.substring(1, texto.length() - 1).replace("\"\"", "\"");
    }
    return texto;
    
    
    
    
}
    
}
