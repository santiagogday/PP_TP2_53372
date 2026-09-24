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

            //Se crean estudiantes
            Estudiante estudiante1 = new Estudiante("53372", "Santiago");
            Estudiante estudiante2 = new Estudiante("54323", "Juan");
            Estudiante estudiante3 = new Estudiante("53124", "Maria");
            estudiantes.add(estudiante1);
            estudiantes.add(estudiante2);
            estudiantes.add(estudiante3);

            //Se crean eventos
            EventoUniversitario evento1 = new EventoUniversitario("1", "Programacion estructurada", 0, false);
            EventoUniversitario evento2 = new EventoUniversitario("234", "POO", 25005, true);
            EventoUniversitario evento3 = new EventoUniversitario("125", "Programacion estructurada y POO", 25000, true);

            //Se crean salas y se asignan a los eventos
            Sala sala1 = new Sala(1, "San Martin");
            Sala sala2 = new Sala(10, "Belgrano");
            Sala sala3 = new Sala(14, "Rosas");
            evento1.asignarSala(sala1);
            evento2.asignarSala(sala2);
            evento3.asignarSala(sala3);

            // d. Se crean 2 actividades para el evento: una Charla y un Taller
            evento1.crearActividad(2, "Javascript", 100, "Charla");
            evento1.crearActividad(3, "Git y GitHub", 40, true);
            evento1.crearActividad(30,"Ajedrez",400,5);

            evento2.crearActividad(101, "Introducción a Docker", 60, "Taller");
            evento2.crearActividad(102, "Clean Code y Buenas Prácticas", 45, false);
            evento2.crearActividad(103, "Hackathon Nocturna", 150, 8);

            evento3.crearActividad(501, "Ilustración Digital", 30, "Masterclass");
            evento3.crearActividad(502, "Modelado 3D con Blender", 25, true);
            evento3.crearActividad(503, "Torneo de Speed Painting", 80, 4);

            //Avisando que vamos a inscribir estudiantes
            System.out.println("INSCRIBIENDO ESTUDIANTES EN ACTIVIDADES");

            //Intentando inscribir a alumnos en actividades
            evento1.getActividades().get(0).inscribir(estudiante1);
            evento1.getActividades().get(0).inscribir(estudiante2);
            evento1.getActividades().get(1).inscribir(estudiante2);
            evento1.getActividades().get(1).inscribir(estudiante3);
            evento1.getActividades().get(2).inscribir(estudiante3);
            evento1.getActividades().get(0).inscribir(estudiante3);
            evento1.getActividades().get(1).inscribir(estudiante1);
            evento1.getActividades().get(2).inscribir(estudiante1);
            evento2.getActividades().get(0).inscribir(estudiante1);
            evento2.getActividades().get(0).inscribir(estudiante3);
            evento2.getActividades().get(2).inscribir(estudiante2);
            evento2.getActividades().get(2).inscribir(estudiante3);
            evento3.getActividades().get(0).inscribir(estudiante2);
            evento3.getActividades().get(1).inscribir(estudiante3);
            evento3.getActividades().get(2).inscribir(estudiante2);
            evento3.getActividades().get(2).inscribir(estudiante3);

            System.out.println("----------------------------------------------------");

            //Avisando que vamos a generar certificados para los alumnos inscriptos en actividades de tipo Taller y Curso
            System.out.println("GENERANDO CERTIFICADOS PARA ALUMNOS INSCRIPTOS EN TALLERES Y CURSOS");

            for(Actividad actividad:evento1.getActividades()){
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
            System.out.println("----------------------------------------------------");


            //Filtrando eventos por actividad
            // --- Filtrados para Evento 1 ---
            List<Charla> listaCharlasEvento1 = evento1.filtrarActividadesPorTipo(Charla.class);
            List<Curso>  listaCursosEvento1  = evento1.filtrarActividadesPorTipo(Curso.class);
            List<Taller> listaTalleresEvento1 = evento1.filtrarActividadesPorTipo(Taller.class);
            List<Charla> listaCharlasEvento2 = evento2.filtrarActividadesPorTipo(Charla.class);
            List<Curso>  listaCursosEvento2  = evento2.filtrarActividadesPorTipo(Curso.class);
            List<Taller> listaTalleresEvento2 = evento2.filtrarActividadesPorTipo(Taller.class);
            List<Charla> listaCharlasEvento3 = evento3.filtrarActividadesPorTipo(Charla.class);
            List<Curso>  listaCursosEvento3  = evento3.filtrarActividadesPorTipo(Curso.class);
            List<Taller> listaTalleresEvento3 = evento3.filtrarActividadesPorTipo(Taller.class);


            System.out.println("----------------------------------------------------");
            System.out.println("CANTIDAD DE ACTIVIDADES POR TIPO DE CADA EVENTO");

            //Mostrando la cantidad de actividades que tiene cada evento
            evento1.calcularCostoMateriales(listaCharlasEvento1);
            evento1.calcularCostoMateriales(listaCursosEvento1);
            evento1.calcularCostoMateriales(listaTalleresEvento1);
            evento2.calcularCostoMateriales(listaCharlasEvento2);
            evento2.calcularCostoMateriales(listaCursosEvento2);
            evento2.calcularCostoMateriales(listaTalleresEvento2);
            evento3.calcularCostoMateriales(listaCharlasEvento3);
            evento3.calcularCostoMateriales(listaCursosEvento3);
            evento3.calcularCostoMateriales(listaTalleresEvento3);


            System.out.println("----------------------------------------------------");
            System.out.println("PERSISTIENDO Y RECUPERANDO OBEJTOS");

            //Serializamos el evento
            evento1.persistirEvento();
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
            System.out.println("----------------------------------------------------");
            System.out.println("FIN DE PROGRAMA");
        }

    }
}