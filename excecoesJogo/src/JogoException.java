public class JogoException extends RuntimeException {
    public JogoException(String message) {
        super("Deu ruim pia " + message);
    }
}
