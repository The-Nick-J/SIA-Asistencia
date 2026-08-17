import java.util.*;


//clase que contiene todos los metodos para operaciones de gestion de cursos
public class GestionCursos {
    
    //inicializa un mapa vacio de cursos
    public HashMap<String,Curso> cursos = new HashMap<>();
    
    public boolean agregarCurso(String nombre, String codigo, String profesorJefe){
        //checkea si ya existe el curso con el codigo ingresado
        if (cursos.containsKey(codigo)){
            return false;
        }
        //crea el curso con el input dado
        Curso nuevoCurso = new Curso(nombre, codigo, profesorJefe);
        //se mete al mapa con key codigo y value objeto Curso nuevoCurso
        cursos.put(codigo, nuevoCurso);
        //return true si exito
        return true;
    }
    
    public void mostrarCurso(String codigo){
        
        //buscar el curso segun el codigo
        Curso mostrado = cursos.get(codigo);
        
        //revisar que el curso efectivamente existad
        if(mostrado == null){
            System.out.println("No existe un curso con ese codigo");
            return;
        }
        
        //printear los datos del curso
        System.out.println("Codigo: " + mostrado.getCodigo());
        System.out.println("Nombre: " + mostrado.getNombre());
        System.out.println("Profesor Jefe: " + mostrado.getProfesorJefe());
        
        //printear alumnos registrados en curso
        mostrado.mostrarAlumnos();
    }
    
    public void mostrarCursos(){
        //checkea que existan cursos
        if(cursos.isEmpty()){
            System.out.println("No hay cursos registrados");
            return;
        }
        //itera por el map de cursos y llama al metodo mostrarCurso
        for(String codigo : cursos.keySet()){
            mostrarCurso(codigo);
        }
    }
}