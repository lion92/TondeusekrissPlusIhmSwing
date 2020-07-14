package exception;

/***
 * Class d'exception pour la liste tondeuseDirection si elle est null
 * 
 * @author Clotilde kriss
 *
 */
public class TondeuseNullException extends Exception {

	private static final long serialVersionUID = 1L;

	public TondeuseNullException(String str) {
		super(str);

	}

}
