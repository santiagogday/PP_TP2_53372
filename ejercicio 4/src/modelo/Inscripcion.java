package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    //Atributos
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private TicketDeAcceso ticket;

    //Constructor
    public Inscripcion(LocalDate fecha,Estudiante estudiante){
        this.fecha = fecha;
        this.estado = "Pendiente";
        this.estudiante =estudiante;
    }

    //Getters
    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public TicketDeAcceso getTicket() {
        return ticket;
    }


    //Setter
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTicket(TicketDeAcceso ticket) {
        this.ticket = ticket;
    }

    //Clase anidada miembro TicketDeAcceso
    public class TicketDeAcceso implements Serializable{
        //Atributos de la clase anidada miembro
        private String idTicket;
        private LocalDate fechaEmision;

        //Constructor de la clase anidada
        public TicketDeAcceso(String idTicket){
            this.idTicket = idTicket;
            this.fechaEmision = LocalDate.now();
        }

        //Getters

        public String getIdTicket(){
            return idTicket;
        }
        public LocalDate getFechaEmision(){
            return fechaEmision;
        }

        //Metodos de la clase anidada miembro
        public void enviarTicket(){
            System.out.println("[" + Thread.currentThread().getName() + "] -> Ticket " + this.idTicket + " enviado a: " + estudiante.getNombre());
        }

    }

}
