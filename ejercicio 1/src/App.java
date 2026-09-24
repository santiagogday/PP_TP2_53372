import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");


        Estudiante estudiante1 = new Estudiante("53372", "Santiago");
        Estudiante estudiante2 = new Estudiante("54323", "Juan");
        Estudiante estudiante3 = new Estudiante("53124", "Maria");


        EventoUniversitario evento = new EventoUniversitario("1", "Programacion", 25000, true);


        Sala sala = new Sala(1, "San Martin");
        evento.asignarSala(sala);


        evento.crearActividad(2, "Javascript", 1, "Carlos Gomez");
        evento.crearActividad(3, "Git y GitHub", 40, true);


        try {
            System.out.println(">>> Intentando inscripciones:");
            evento.getActividades().get(0).inscribir(estudiante1); // Caso exitoso (1/1)
            evento.getActividades().get(0).inscribir(estudiante2); // Caso fallido (lanza CupoExcedidoException)
        } catch (CupoExcedidoException e) {

            System.err.println("Control de cupo: " + e.getMessage());
        }


        try {
            System.out.println("\n>>> Probando persistencia:");
            evento.persistirEvento();

            System.out.println("\n>>> Recuperando evento existente (Caso exitoso):");
            EventoUniversitario.recuperarEvento("1");

            System.out.println("\n>>> Intentando recuperar evento inexistente (Caso fallido):");
            EventoUniversitario.recuperarEvento("10");

        } catch (FileNotFoundException e) {

            System.err.println("Error de archivo: No se encontró el archivo del evento solicitado.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error de clase: No se reconoció la clase del objeto almacenado.");
        } catch (IOException e) {
            System.err.println("Error de E/S: Ocurrió un fallo general de entrada/salida.");
        } finally {

            System.out.println("\nFIN DE PROGRAMA");
            System.out.println("----------------------------------------------------");
        }
    }
}