
import java.util.*;
import java.time.*;

public class GestionRegistroAsistencia {

    /*Este HashMap usa de key el rut del alumno, y su value es un ArrayList
    que contendra todas las asistencias correspondiente a un alumno
     */
    private final HashMap<String, ArrayList<Asistencia>> registrosAsistencia;

    //el HashMap se declara en atributos y se inicializa en el constructor
    public GestionRegistroAsistencia() {
        this.registrosAsistencia = new HashMap<>();
    }

    /*Agrega una asistencia al alumno correspondiente, el metodo se encarga
    de revisar si ya hay asistencia para ese dia
     */
    public boolean agregarRegistroAsistencia(Asistencia nuevaAsistencia) {
        String rut = nuevaAsistencia.getAlumno().getRut();

        if (!registrosAsistencia.containsKey(rut)) {
            registrosAsistencia.put(rut, new ArrayList<>());
        }

        ArrayList<Asistencia> asistenciaAlumno = registrosAsistencia.get(rut);
        for (Asistencia asistencia : asistenciaAlumno) {
            if (asistencia.getFecha().equals(nuevaAsistencia.getFecha())) {
                System.out.println("ERROR: El alumno ya tiene una asistencia registrada en esa fecha");
                return false;
            }
        }
        asistenciaAlumno.add(nuevaAsistencia);
        return true;
    }

    public boolean registrarAsistencia(Alumno alumno, LocalDate fecha, boolean presente, String justificacion) {
        Asistencia nuevaAsistencia = new Asistencia(fecha, alumno, presente);

        if (!presente && justificacion != null && !justificacion.trim().isEmpty()) {
            nuevaAsistencia.setFaltaJustificada(true);
            nuevaAsistencia.setJustificacion(justificacion.trim());
        }

        return agregarRegistroAsistencia(nuevaAsistencia);
    }

    //Retorna un ArrayList de todas las asistencias registradas de un alumno
    public ArrayList<Asistencia> buscarRegistroAsistencia(Alumno alumno) {
        if (alumno != null && registrosAsistencia.containsKey(alumno.getRut())) {
            return registrosAsistencia.get(alumno.getRut());
        }
        return null;
    }

    //Retorna un ArrayList de todas las asistencias registradas en una fecha
    public ArrayList<Asistencia> buscarRegistroAsistencia(LocalDate fecha) {
        ArrayList<Asistencia> asistenciasFecha = new ArrayList<>();
        for (ArrayList<Asistencia> asistenciasAlumno : registrosAsistencia.values()) {
            for (Asistencia asistencia : asistenciasAlumno) {
                if (asistencia.getFecha().equals(fecha)) {
                    asistenciasFecha.add(asistencia);
                }
            }
        }
        return asistenciasFecha;
    }

    public boolean existeAsistenciaRegistrada(Curso curso, LocalDate fecha) {
        for (Alumno alumno : curso.getAlumnos()) {
            ArrayList<Asistencia> asistenciasAlumno = buscarRegistroAsistencia(alumno);

            if (asistenciasAlumno != null) {
                for (Asistencia asistencia : asistenciasAlumno) {
                    if (asistencia.getFecha().equals(fecha)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //print las asistencias del arraylist y sus datos, dado que asistencia no tiene metodo mostrar
    public void mostrarRegistros() {
        if (registrosAsistencia.isEmpty()) {
            System.out.println("No hay registros de asistencia en el sistema.");
            return;
        }
        for (ArrayList<Asistencia> asistenciasAlumno : registrosAsistencia.values()) {
            for (Asistencia asistencia : asistenciasAlumno) {
                System.out.println("Fecha: " + asistencia.getFecha());
                System.out.println("Alumno: " + asistencia.getAlumno().getNombre() + " " + asistencia.getAlumno().getApellido());
                if (asistencia.isPresente()) {
                    System.out.println("Estado: Presente");
                } else {
                    System.out.println("Estado: Ausente");
                    System.out.println("Falta justificada: " + (asistencia.isFaltaJustificada() ? "Si" : "No"));
                    if (asistencia.isFaltaJustificada()) {
                        System.out.println("Justificacion: " + asistencia.getJustificacion());
                    }
                }
                if (asistencia.isRetirado()) {
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

    public boolean registrarFaltaJustificada(Alumno alumno, LocalDate fecha, String justificacion) {
        if (alumno == null || fecha == null || justificacion == null || justificacion.trim().isEmpty()) {
            return false;
        }

        ArrayList<Asistencia> listaTemp = buscarRegistroAsistencia(alumno);

        if (listaTemp == null) {
            return false;
        }

        for (Asistencia asistencia : listaTemp) {
            if (asistencia.getFecha().equals(fecha)) {
                if (asistencia.isPresente()) {
                    System.out.println("No se puede justificar una asistencia presente.");
                    return false;
                } else {
                    asistencia.setFaltaJustificada(true);
                    asistencia.setJustificacion(justificacion.trim());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean registrarSalidaAnticipada(Alumno alumno, LocalDate fecha, String motivo) {
        if (alumno == null || fecha == null || motivo == null || motivo.trim().isEmpty()) {
            return false;
        }

        ArrayList<Asistencia> asistenciasAlumno = buscarRegistroAsistencia(alumno);

        if (asistenciasAlumno != null) {
            for (Asistencia asistencia : asistenciasAlumno) {
                if (asistencia.getFecha().equals(fecha)) {
                    if (!asistencia.isPresente()) {
                        return false;
                    }

                    asistencia.setRetirado(true);
                    asistencia.setMotivoSalida(motivo.trim());
                    return true;
                }
            }
        }

        Asistencia nuevaAsistencia = new Asistencia(fecha, alumno, true);
        nuevaAsistencia.setRetirado(true);
        nuevaAsistencia.setMotivoSalida(motivo.trim());

        return agregarRegistroAsistencia(nuevaAsistencia);
    }

    // metodo para mostrar ausentes en una fecha especifica
    public void mostrarAusentesPorFecha(LocalDate fecha) {
        boolean hayAusentes = false;

        for (ArrayList<Asistencia> asistenciasAlumno : registrosAsistencia.values()) {
            for (Asistencia asistencia : asistenciasAlumno) {
                if (asistencia.getFecha().equals(fecha) && !asistencia.isPresente()) {

                    Alumno alumno = asistencia.getAlumno();
                    System.out.println("Alumnos AUSENTES en fecha: " + fecha);
                    System.out.print("RUT: " + alumno.getRut());
                    System.out.print("--- Nombre: " + alumno.getNombre() + " " + alumno.getApellido());
                    System.out.println(" ");
                    System.out.println("Falta justificada: " + (asistencia.isFaltaJustificada() ? "Si" : "No"));
                    if (asistencia.isFaltaJustificada()) {
                        System.out.println("Justificacion: " + asistencia.getJustificacion());
                    }

                    hayAusentes = true;
                }
            }
        }

        if (!hayAusentes) {
            System.out.println("no hay ausentes en la fecha ingresada.");
        }

    }

    public void mostrarAsistenciaPorFechaYCurso(Curso curso, LocalDate fecha) {
        boolean hayAsistenciaTomada = false;

        for (Alumno alumno : curso.getAlumnos()) {
            ArrayList<Asistencia> asistenciasAlumno = buscarRegistroAsistencia(alumno);

            if (asistenciasAlumno != null) {
                for (Asistencia asistencia : asistenciasAlumno) {
                    if (asistencia.getFecha().equals(fecha)) {
                        hayAsistenciaTomada = true;
                        System.out.println("==== ALUMNO ==== ");
                        System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
                        System.out.println("RUT: " + alumno.getRut());

                        if (asistencia.isRetirado()) {
                            System.out.println("Estado: Salida Anticipada");
                            System.out.println("Motivo: " + asistencia.getMotivoSalida());
                        } else if (asistencia.isPresente()) {
                            System.out.println("Estado: Presente");
                        } else {
                            System.out.println("Estado: Ausente");
                        }

                        if (asistencia.isFaltaJustificada()) {
                            System.out.println("Falta Justificada: Si");
                            System.out.println("Justificacion: " + asistencia.getJustificacion());
                        }
                    }
                }
            }
        }

        if (!hayAsistenciaTomada) {
            System.out.println("No hay asistencia tomada para ese curso en esa fecha");
        }
    }

    public String obtenerAusentesPorFecha(LocalDate fecha) {
        String resultado = "";

        for (ArrayList<Asistencia> asistenciasAlumno : registrosAsistencia.values()) {
            for (Asistencia asistencia : asistenciasAlumno) {
                if (asistencia.getFecha().equals(fecha) && !asistencia.isPresente()) {
                    Alumno alumno = asistencia.getAlumno();

                    resultado = resultado + "RUT: " + alumno.getRut() + "\n";
                    resultado = resultado + "Nombre: " + alumno.getNombre() + " " + alumno.getApellido() + "\n";
                    resultado = resultado + "Falta justificada: " + (asistencia.isFaltaJustificada() ? "Sí" : "No") + "\n";

                    if (asistencia.isFaltaJustificada()) {
                        resultado = resultado + "Justificación: " + asistencia.getJustificacion() + "\n";
                    }

                    resultado = resultado + "\n";
                }
            }
        }

        if (resultado.isEmpty()) {
            return "No hay alumnos ausentes en la fecha ingresada.";
        }

        return resultado;
    }

    public String obtenerAsistenciaPorFechaYCurso(Curso curso, LocalDate fecha) {
        String resultado = "";

        for (Alumno alumno : curso.getAlumnos()) {
            ArrayList<Asistencia> asistenciasAlumno = buscarRegistroAsistencia(alumno);

            if (asistenciasAlumno != null) {
                for (Asistencia asistencia : asistenciasAlumno) {
                    if (asistencia.getFecha().equals(fecha)) {
                        resultado = resultado + "Alumno: " + alumno.getNombre() + " " + alumno.getApellido() + "\n";
                        resultado = resultado + "RUT: " + alumno.getRut() + "\n";

                        if (asistencia.isRetirado()) {
                            resultado = resultado + "Estado: Salida anticipada\n";
                            resultado = resultado + "Motivo: " + asistencia.getMotivoSalida() + "\n";
                        } else if (asistencia.isPresente()) {
                            resultado = resultado + "Estado: Presente\n";
                        } else {
                            resultado = resultado + "Estado: Ausente\n";
                        }

                        if (asistencia.isFaltaJustificada()) {
                            resultado = resultado + "Falta justificada: Sí\n";
                            resultado = resultado + "Justificación: " + asistencia.getJustificacion() + "\n";
                        }

                        resultado = resultado + "\n";
                    }
                }
            }
        }

        if (resultado.isEmpty()) {
            return "No hay asistencia registrada para ese curso en esa fecha.";
        }

        return resultado;
    }

}
