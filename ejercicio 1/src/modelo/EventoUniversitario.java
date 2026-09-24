package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jdk.jfr.Event;
import modelo.actividades.*; ////Importaciones

public class EventoUniversitario implements Serializable {
    // Atributos
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;
    private Sala sala;
    private List<Actividad> actividades = new ArrayList<>();

    // Constructor
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    // Constructor de copia
    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id + "_copia";
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        cantidadEventos++;
    }




    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public Sala getSala() {
        return sala;
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }





    // Métodos
    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo, String disertante) {
        Actividad nuevaCharla = new Charla(id, titulo, cupo, disertante);
        this.actividades.add(nuevaCharla);
    }

    public void crearActividad(int id, String titulo, int cupo, boolean requiereNotebook) {
        Actividad nuevoTaller = new Taller(id, titulo, cupo, requiereNotebook);
        this.actividades.add(nuevoTaller);
    }

    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        }
        double costoTotalActividades = 0.0;
        for (Actividad act : this.actividades) {
            costoTotalActividades += act.calcularCostoMateriales();
        }
        return (this.costoBase + costoTotalActividades) * 1.21;
    }

    public void mostrarDatos() {
        System.out.println("---------------------");
        System.out.println("ID Evento: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("modelo.Sala: " + (this.sala != null ? this.sala.getNombre() : "Sin asignar"));
        System.out.println("Gratuito: " + (this.gratuito ? "Sí" : "No"));
        System.out.println(this.actividades.size() + " actividad/es vinculada");

        int indice = 1;
        for (Actividad act : this.actividades) {
            System.out.print("  " + indice + ". " + act.getTipo() + " " + act.getTitulo() + " . ");
            act.mostrarIdentificacion();
            indice++;
        }
        System.out.println("-----------------------");
    }

    public boolean persistirEvento()throws FileNotFoundException,IOException{
        FileOutputStream fos = new FileOutputStream(this.id+".dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        fos.close();
        System.out.println("Evento " +this.getTitulo()+" persistido con exito");
        return true;
    }

    public static EventoUniversitario recuperarEvento(String id)throws FileNotFoundException,ClassNotFoundException,IOException{
        FileInputStream fis = new FileInputStream(id+".dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        EventoUniversitario eventoRecuperado = (EventoUniversitario) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Evento " +eventoRecuperado.getTitulo()+" recuperado con exito");
        return eventoRecuperado;
    }

}