package modelo.actividades;

import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    //Atributos
    protected int id;
    protected String titulo;
    protected int cupoMaximo;
    protected static final int CUPO_MINIMO = 5;  //El cupo minimo para toda actividad es de 5 personas.
    private List <Inscripcion> inscripcionesActividad = new ArrayList<>(); //Lista de las inscripciones a una actividad

    //Constructor
    public Actividad(int id,String titulo,int cupoMaximo){
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }



    //Getters
    public List<Inscripcion> getInscripcionesActividad() {
        return inscripcionesActividad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }




    //Metodos
    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (this.inscripcionesActividad.size() >= this.cupoMaximo) {
            throw new CupoExcedidoException("Se ha alcanzado el cupo máximo para esta actividad.");
        }
        Inscripcion nuevaInscripcion = new Inscripcion(LocalDate.now(), "Ocupado");
        inscripcionesActividad.add(nuevaInscripcion);
        System.out.println(estudiante.getNombre() + " inscripto con éxito a " + this.getTitulo());
        return nuevaInscripcion;
    }

    public void mostrarInscripciones(){
        System.out.println(inscripcionesActividad);
    }

    public final void  mostrarIdentificacion(){
        System.out.println("El id de la actividad es " + this.id);
    }

    public abstract double calcularCostoMateriales();//Metodo abstracto nuevo

    public abstract String getTipo();//Metodo abstracto nuevo

}
