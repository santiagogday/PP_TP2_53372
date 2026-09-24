package modelo;

public interface Certificable {
    //Atributos
    String ENTIDAD_EMISORA="Gobierno de Mendoza";

    //Metodos que deben implementarse en las clases que implementen esta interfaz.
    String generarCertificado(Estudiante estudiante);



}
