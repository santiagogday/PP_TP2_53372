package modelo.actividades;

import modelo.Certificable;
import modelo.Estudiante;

public class Curso extends Actividad implements Certificable {
    //Atributos
    private int nivel;


    //Constructor
    public Curso(int id, String titulo, int cupoMaximo, int nivel){
        super(id,titulo,cupoMaximo);
        this.nivel = nivel;
    }


    //Metodos
    public double calcularCostoMateriales(){
        return 1500;//Suponiendo que el costo de los materiales de una actividad de tipo taller es de 2000
    }

    public String getTipo(){
        return "Curso";
    }

    public String generarCertificado(Estudiante estudiante){
        return "Certificado generado para el estudiante "+estudiante.getNombre();
    }


}
