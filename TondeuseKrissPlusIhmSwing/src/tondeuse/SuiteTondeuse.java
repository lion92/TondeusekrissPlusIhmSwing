package tondeuse;

import java.util.ArrayList;
import java.util.List;

import exception.SuiteTondeuseNullException;

/***
 * Class Suite Tondeuse qui permet d'avoir la liste des tondeuses
 * 
 * @author Clotilde kriss
 *
 */
public class SuiteTondeuse {
	private List<Tondeuse> SuiteTondeuse = new ArrayList<>();

	/**
	 * Constructeur de suite Tondeuse
	 * 
	 * @throws SuiteTondeuseNullException
	 */
	public SuiteTondeuse() throws SuiteTondeuseNullException {
		if (SuiteTondeuse == null) {
			throw new SuiteTondeuseNullException();
		}

	}

	public List<Tondeuse> getSuiteTondeuse() {
		return SuiteTondeuse;
	}

	public void setSuiteTondeuse(List<Tondeuse> suiteTondeuse) {
		SuiteTondeuse = suiteTondeuse;
	}

}
