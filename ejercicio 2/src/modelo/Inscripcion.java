package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    //Atributos
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;

    //Constructor
    public Inscripcion(LocalDate fecha,String estado,Estudiante estudiante){
        this.fecha = fecha;
        this.estado = estado;
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
}
