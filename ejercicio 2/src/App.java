import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.Sala;
import modelo.actividades.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("----------------------------------------------------");

            List<Estudiante> estudiantes = new ArrayList<>();

            // a. Se crean 3 estudiantes
            Estudiante estudiante1 = new Estudiante("53372", "Santiago");
            Estudiante estudiante2 = new Estudiante("54323", "Juan");
            Estudiante estudiante3 = new Estudiante("53124", "Maria");
            estudiantes.add(estudiante1);
            estudiantes.add(estudiante2);
            estudiantes.add(estudiante3);

            // b. Se crea 1 evento
            EventoUniversitario evento = new EventoUniversitario("1", "Programacion", 25000, true);

            // c. Se crea 1 sala y se asigna al evento
            Sala sala = new Sala(1, "San Martin");
            evento.asignarSala(sala);

            // d. Se crean 2 actividades para el evento: una Charla y un Taller
            evento.crearActividad(2, "Javascript", 100, "Charla");
            evento.crearActividad(3, "Git y GitHub", 40, true);
            evento.crearActividad(30,"Ajedrez",400,5);

            //Intentando inscribir a alumnos en actividades
            evento.getActividades().get(0).inscribir(estudiante1);
            evento.getActividades().get(0).inscribir(estudiante2);
            evento.getActividades().get(1).inscribir(estudiante2);
            evento.getActividades().get(1).inscribir(estudiante3);
            evento.getActividades().get(2).inscribir(estudiante2);
            evento.getActividades().get(2).inscribir(estudiante3);

            for(Actividad actividad:evento.getActividades()){
                if(actividad.getTipo().equals("Curso")){
                    Curso actividadCurso = (Curso)actividad;
                    for(Inscripcion inscripcion:actividad.getInscripcionesActividad()){
                        System.out.println(actividadCurso.generarCertificado(inscripcion.getEstudiante())+" debido al Curso de "+actividad.getTitulo());;
                    }
                } else if (actividad.getTipo().equals("Taller")) {
                    Taller actividadTaller = (Taller)actividad;
                    for(Inscripcion inscripcion:actividad.getInscripcionesActividad()){
                        System.out.println(actividadTaller.generarCertificado(inscripcion.getEstudiante())+" debido al Taller de "+actividad.getTitulo());;
                    }
                }
            }


            evento.mostrarDatos();



            //Serializamos el evento
            evento.persistirEvento();

            //Recuperando evento persistido
            EventoUniversitario.recuperarEvento("1");


        }catch (CupoExcedidoException e){
            System.err.println("Se ha alcanzado el cupo maximo para la actividad");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("FIN DE PROGRAMA");
            System.out.println("----------------------------------------------------");
        }

    }
}