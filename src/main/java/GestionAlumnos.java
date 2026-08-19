import java.util.*;

public class GestionAlumnos {
	
	private final ArrayList<Alumno> alumnos = new ArrayList<>();
	private final GestionCursos gestionCursos;

	public GestionAlumnos(GestionCursos gestionCursos) {
		this.gestionCursos = gestionCursos;
	}

	public boolean agregarAlumno(String rut, String nombre, String apellido) {
		// revisa si ya existe el alumno en el arraylist
		if (buscarAlumno(rut) != null) {
			return false;
		}
		// crea el alumno y los agregamos al arrayList
		Alumno nuevoAlumno = new Alumno(rut, nombre, apellido);
		alumnos.add(nuevoAlumno);
		// confirmam exito con return true
		return true;
	}

	public Alumno buscarAlumno(String rut) {
		// itera sobre los alumnos
		for (Alumno alumno : alumnos) {
			// busca un alumno con el rut indicado
			if (alumno.getRut().equals(rut)) {
				// si hay exito retorna el alumno
				return alumno;
			}
		}
		// si hay fallo retorna null
		return null;
	}

	public Alumno buscarAlumno(String nombre, String apellido) {
		// itera sobre los alumnos
		for (Alumno alumno : alumnos) {
			// busca un alumno con el nombre y apellido indicado
			if (alumno.getNombre().equals(nombre) && alumno.getApellido().equals(apellido)) {
				// si hay exito retorna el alumno
				return alumno;
			}
		}
		// si hay fallo retorna null
		return null;
	}

	public Alumno mostrarAlumno(String rut) {
		Alumno alumno = buscarAlumno(rut);
		return alumno;
	}

	public void mostrarAlumnos() {
		// verifica que existan alumnos en el arraylist
		if (alumnos.isEmpty()) {
			System.out.println("No hay alumnos registrados");
			return;
		}

		// itera por el arraylist de alumnos y llama el metodo mostrarAlumno por cada
		// alumno existente
		for (Alumno alumno : alumnos) {
			mostrarAlumno(alumno.getRut());
		}

	}

	public boolean registrarAlumno(String rut, String codigo) {
		Alumno alumno = buscarAlumno(rut);

		if (alumno == null) {
			System.out.println("No existe un alumno con ese RUT");
			return false;
		}

		Curso curso = gestionCursos.cursos.get(codigo);

		if (curso == null) {
			System.out.println("No existe un curso con ese codigo");
			return false;
		}

		curso.addAlumno(alumno);
		alumno.setCurso(curso);
		return true;
	}

}