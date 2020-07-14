package tondeuse;

import java.util.ArrayList;
import java.util.List;

import exception.TondeuseNullException;

/**
 * Class Tondeuse pour l'objet Tondeuse possedant les directions et les
 * positions de la tondeuse
 * 
 * @author Clotilde kriss
 *
 */
public class Tondeuse {
	private List<String> TondeuseDirection = new ArrayList<>();
	private List<String> tondeusePosition = new ArrayList<>();

	/**
	 * Constructeur de Tondeuse sans paramètres
	 */
	public Tondeuse() {
	}

	/**
	 * Constructeur de Tondeuse avec paramètre String
	 * 
	 * @param direction Direction de la Tondeuse
	 * @throws TondeuseNullException
	 */
	public Tondeuse(String direction) throws TondeuseNullException {
		if (direction == null) {
			throw new TondeuseNullException("Direction null");
		}
		this.TondeuseDirection = new ArrayList<>();

		for (int i = 0; i < direction.length(); i++) {

			this.TondeuseDirection.add(direction.substring(i, i + 1));

		}

	}

	public List<String> getTondeuseDirection() {
		return TondeuseDirection;
	}

	public List<String> getTondeusePosition() {
		return tondeusePosition;
	}

}
