import java.io.BufferedReader;
import java.io.IOException;
import java.time.*;

public class MenuAsistencia {

    private final BufferedReader leer;
    private final GestionCursos gestionCursos;
    private final GestionRegistroAsistencia gestionRegistroAsistencia;

    public MenuAsistencia(BufferedReader leer,GestionCursos gestionCursos,GestionRegistroAsistencia gestionRegistroAsistencia) {
        this.leer = leer;
        this.gestionCursos = gestionCursos;
        this.gestionRegistroAsistencia = gestionRegistroAsistencia;
    }

    public void mostrarMenu() throws IOException {
        int opcionAsistencia;
        String codigoCurso;
        Curso cursoAsistencia;
        LocalDate fechaActual = LocalDate.now();
        String presente;
        do {
            System.out.println("Bienvenido al Menu de Asistencia");
            System.out.println("1. Pasar Asistencia");
            System.out.println("2. Registrar una Inasistencia Extraordinaria");
            System.out.println("3. Registrar salida anticipada");
            System.out.println("4. Consultar Asistencia");
            System.out.println("5. Volver al menu principal");
            opcionAsistencia = Integer.parseInt(leer.readLine());
            
            
            switch(opcionAsistencia){
                case 1:
                    System.out.println("Ingrese el codigo del curso en el que pasara asistencia:");
                    codigoCurso = leer.readLine();
                    cursoAsistencia = gestionCursos.getCursos().get(codigoCurso);
                    if(cursoAsistencia == null) {
                        System.out.println("ERROR: No existe un curso con este codigo.");
                        break;
                    }
                    
                    if(gestionRegistroAsistencia.existeAsistenciaRegistrada(cursoAsistencia, fechaActual)){
                        System.out.println("ERROR: Ya se tomo asistencia para este curso.");
                        break;
                    }
                    
                    
                    System.out.println("Para cada alumno, ingrese 'S' si esta presente o 'N' si esta ausente");
                    for(Alumno alumno : cursoAsistencia.getAlumnos()){
                        System.out.println("Alumn@: "+alumno.getNombre()+" "+alumno.getApellido());
                        System.out.println("Presente?");
                        do{
                        presente = leer.readLine().trim().toUpperCase();
                        if(!presente.equals("S") && !presente.equals("N"))System.out.println("Ingrese una opcion valida.");
                        }while(!presente.equals("S") && !presente.equals("N"));
                        if(presente.equals("S")){
                            gestionRegistroAsistencia.agregarRegistroAsistencia(new Asistencia(fechaActual,alumno,true));
                        }else
                            gestionRegistroAsistencia.agregarRegistroAsistencia(new Asistencia(fechaActual,alumno,false));
                        
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ingrese una opción valida.");
                    break;
            }
            
            
            
            
            
            
            
            
            
        } while (opcionAsistencia != 5);
        
        
    }
}
