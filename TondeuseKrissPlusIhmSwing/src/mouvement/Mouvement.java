package mouvement;

import java.util.List;

import ihm.Ihm;

/**
 * class permettant de gérer le déplacement des tondeuses
 * 
 * @author Clotilde kriss
 *
 */
public class Mouvement {
	// console uniquement utilisé dans le programme utilisant l 'ihm
	private String console = "";

	/***
	 * Mouvement de la tondeuse
	 * 
	 * @param DirectionTondeuse  Les directions de la tondeuse
	 * @param orientationInitial Orientation de la tondeuse au départ
	 * @param positionx          Position en abscisse de la tondeuse au cours du
	 *                           temps
	 * @param positiony          Position en ordonné de la tondeuse au cours du
	 *                           temps
	 * @param xmax               Position maximale en abscisse de la pelouse
	 * @param ymax               Position maximale en ordonné de la pelouse
	 * @return Position finale des tondeuses
	 */
	public String mouvement(List<String> directionTondeuse, String orientationInitial, int positionx, int positiony,
			int xmax, int ymax) {
		boolean encoursOrientation = true;

		for (int i = 0; i < directionTondeuse.size(); i++) {

			encoursOrientation = true;
			if (i == 0) {
				console += "Direction: " + directionTondeuse.get(i) + " Orientation initial: " + orientationInitial
						+ " positionx: " + positionx + " positiony: " + positiony + "<br>";
				Ihm.getInstance().createAndShowJFrame(positionx, positiony, xmax, ymax, orientationInitial,
						directionTondeuse.get(i), "<html>" + console + "</html>");

			}

			if (directionTondeuse.get(i).equals("G")) {

				if (orientationInitial.equals("N") && encoursOrientation == true) {
					orientationInitial = "W";
					encoursOrientation = false;

				} else if (orientationInitial.equals("E") && encoursOrientation == true) {
					orientationInitial = "N";
					encoursOrientation = false;

				} else if (orientationInitial.equals("S") && encoursOrientation == true) {
					orientationInitial = "E";
					encoursOrientation = false;
				}

				else if (orientationInitial.equals("W") && encoursOrientation == true) {

					orientationInitial = "S";
					encoursOrientation = false;

				}
				console += "Direction: " + directionTondeuse.get(i) + " Orientation initial: " + orientationInitial
						+ " positionx: " + positionx + " positiony: " + positiony + "<br>";

				Ihm.getInstance().createAndShowJFrame(positionx, positiony, xmax, ymax, orientationInitial,
						directionTondeuse.get(i), "<html>" + console + "</html>");
			} else if (directionTondeuse.get(i).equals("D")) {

				if (orientationInitial.equals("N") && encoursOrientation == true) {
					orientationInitial = "E";
					encoursOrientation = false;

				} else if (orientationInitial.equals("E") && encoursOrientation == true) {
					orientationInitial = "S";
					encoursOrientation = false;

				} else if (orientationInitial.equals("S") && encoursOrientation == true) {
					orientationInitial = "W";
					encoursOrientation = false;
				}

				else if (orientationInitial.equals("W") && encoursOrientation == true) {

					orientationInitial = "N";
					encoursOrientation = false;

				}
				console += "Direction: " + directionTondeuse.get(i) + " Orientation initial: " + orientationInitial
						+ " positionx: " + positionx + " positiony: " + positiony + "<br>";
				Ihm.getInstance().createAndShowJFrame(positionx, positiony, xmax, ymax, orientationInitial,
						directionTondeuse.get(i), "<html>" + console + "</html>");

			}

			else if (directionTondeuse.get(i).equals("A")) {

				if (orientationInitial.equals("N")) {
					if (positiony >= ymax) {

						positiony = ymax;

					} else {
						positiony = positiony + 1;
					}

				} else if (orientationInitial.equals("S")) {
					if (positiony == 0) {
						positiony = 0;
					} else {
						positiony = positiony - 1;
					}

				} else if (orientationInitial.equals("E")) {
					if (positionx >= xmax) {

						positionx = xmax;
					} else {
						positionx = positionx + 1;
					}

				} else if (orientationInitial.equals("W")) {

					if (positionx == 0) {
						positionx = 0;

					} else {
						positionx = positionx - 1;
					}

				}

				// Pour aller plus vite supprimer le thread sleep, il sert uniquement à mieux
				// voir le mouvement
				if (!(xmax > 30 || ymax > 30)) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				console += "Direction: " + directionTondeuse.get(i) + " Orientation initial: " + orientationInitial
						+ " positionx: " + positionx + " positiony: " + positiony + "<br>";
				Ihm.getInstance().createAndShowJFrame(positionx, positiony, xmax, ymax, orientationInitial,
						directionTondeuse.get(i), "<html>" + console + "</html>");

				// System.out.println(""+positionx+" "+positiony+" "+orientationInitial);

			}

		}
		console += "<br>";
		System.out.println("" + positionx + " " + positiony + " " + orientationInitial);
		return "" + positionx + " " + positiony + " " + orientationInitial;

	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

}
