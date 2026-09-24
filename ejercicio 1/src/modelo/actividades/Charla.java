package modelo.actividades;

public class Charla extends Actividad{
    //Atributos propios de la clase
    private String disertante;

    //Constructor de la clase y uso de super para constructor de la clase padre
    public Charla(int id, String titulo, int cupoMaximo,String disertante){
        super(id,titulo,cupoMaximo);
        this.disertante = disertante;
    }
    
    //Implementacion del metodo abstracto calcularCostoMateriales()
    public double calcularCostoMateriales(){
        return 0;
    }


    //Implementacion del metodo abstracto getTipo()
    public String getTipo(){
        return "La actividad es de tipo: modelo.actividades.Charla";
    }


}
