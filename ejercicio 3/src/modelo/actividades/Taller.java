package modelo.actividades;

import modelo.Certificable;
import modelo.Estudiante;

public class Taller extends Actividad implements Certificable {
    //Atributos propios de la clase
    private boolean requiereNotebook;

    //Constructor de la clase y uso de super para constructor de la clase padre
    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook){
        super(id,titulo,cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    //Implementacion del metodo abstracto calcularCostoMateriales()
    public double calcularCostoMateriales(){
        if(requiereNotebook){
            return 5000;
        }else{
            return 2000;
        }
    }


    //Implementacion del metodo abstracto getTipo()
    public String getTipo(){
        return "Taller";
    }

    public String generarCertificado(Estudiante estudiante){
        return "Certificado generado para el estudiante "+estudiante.getNombre();
    }


}
