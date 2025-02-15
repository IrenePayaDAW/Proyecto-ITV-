package excepciones;

/**
 *
 * @author ÁLVARO CARRIÓN ROMERO
 */
public class AlreadyExistsException extends Exception{
    private String stringExistente;
    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String stringExistente, String message) {
        super(message);
        this.stringExistente = stringExistente;
    }
    
    public String getStringExistente(){
        return stringExistente;
    }

    @Override
    public String toString() {
        return "\n " +super.getMessage();
    }
    
}
