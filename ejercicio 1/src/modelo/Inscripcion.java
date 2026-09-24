package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    //Atributos
    private LocalDate fecha;
    private String estado;

    //Constructor
    public Inscripcion(LocalDate fecha,String estado){
        this.fecha = fecha;
        this.estado = estado;
    }

    //Getters
    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }
}
