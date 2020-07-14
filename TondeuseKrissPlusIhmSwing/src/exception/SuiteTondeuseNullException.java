package exception;

/**
 * Class d'exception pour la liste suiteTondeuse dans l'objet suiteTondeuse si
 * elle est null
 * 
 * @author Clotilde kriss
 *
 */
public class SuiteTondeuseNullException extends Exception {

	private static final long serialVersionUID = 1L;

	public SuiteTondeuseNullException() {
		super("SuiteTondeuse est null");

	}

}
