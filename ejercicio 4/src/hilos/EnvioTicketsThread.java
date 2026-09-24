package hilos;

import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.actividades.Actividad;

public class EnvioTicketsThread extends Thread{
    //Atributos
    private EventoUniversitario evento;

    //Constructor
    public EnvioTicketsThread(EventoUniversitario evento){
        this.evento = evento;
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Iniciando envio de tickets del evento " + evento.getTitulo());
        int enviados = 0;
        for(Actividad actividad : evento.getActividades()){
            for(Inscripcion inscripcion:actividad.getInscripcionesActividad()){
                if(inscripcion.getTicket()!=null){
                    inscripcion.getTicket().enviarTicket();
                }
            }
        }
        System.out.println("Envio de tickets finalizado");
    }
}
