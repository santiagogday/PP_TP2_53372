package excepciones;

public class CupoExcedidoException extends Exception{

    //Constructor
    public CupoExcedidoException(String contenido){
        super(contenido);
    }

}
