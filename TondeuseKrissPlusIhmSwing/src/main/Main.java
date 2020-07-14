package main;

import exception.SuiteTondeuseNullException;
import exception.TondeuseNullException;
import lecture.Lire;
import mouvement.Mouvement;
import tondeuse.SuiteTondeuse;
import tondeuse.Tondeuse;

/**
 * Point d'entré du projet Tondeuse automatique
 * 
 * @author Clotilde kriss
 *
 */
public class Main {

	/**
	 * Test si chaine est un entier ou non si c'est le cas return true
	 * 
	 * @param chaine : paramètre à tester
	 * 
	 * @return true or false
	 */
	public static boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Main point d'entré du programme
	 * 
	 * @param args
	 * @throws SuiteTondeuseNullException
	 */
	public static void main(String[] args) throws SuiteTondeuseNullException {
		try {
			// Lecture du fichier type avec les direction la taille de la grille et la
			// position initiale de la tondeuse
			Lire lire = new Lire(new java.io.File("").getAbsolutePath() + "\\src\\txt\\direction.txt");
			// Instantiation de la class mouvement
			Mouvement mouv = new Mouvement();

			// Initialisation du tableau parts
			String[] tableauAcquisition = null;
			// Découpage du fichier lu en sous chaine qui correspondent aux lignes du
			// fichier texte
			tableauAcquisition = lire.lecture().split(";");
			// Instantiation de suitetondeuse
			SuiteTondeuse suiteTondeuse = new SuiteTondeuse();

			// Instanciation de tondeuse
			Tondeuse tondre = new Tondeuse();
			// for each: pour chaque acquisition si la premiere lettre est un entier on l
			// ajoute dans position en sachant que
			// la position à zéro est
			// la taille en x et y de la grille
			// si ce n'est pas un entier alors on l'ajoute dans les la liste des directions
			// de l objet Tondeuse
			//
			for (String acquisition : tableauAcquisition) {
				try {
					if (acquisition != null) {
						if (acquisition.equals("")) {
							System.out.println(
									"Erreur Il n'y a pas de directions ou de positions pour une tondeuse ou pas d'acquisition de grille.\n "
											+ "Le fichier ne correspond pas à un fichier standard");
							break;
						} else {
							if (!(estUnEntier(acquisition.substring(0, 1))))
								try {
									suiteTondeuse.getSuiteTondeuse().add(new Tondeuse(acquisition));
								} catch (TondeuseNullException e) {
									System.out.println("Liste de direction de tondeuse null");
									e.printStackTrace();
								}
							else {
								tondre.getTondeusePosition().add(acquisition);

							}
						}
					}
				} catch (Exception e) {
					System.out.println("Une erreur s'est produite dans la lecture du fichier." + e);
				}
			}
			int x;
			int y;
			int xmax;
			int ymax;
			String orientation = "";
			String tableauValeur[];
			String acquisition0[];

			for (int i = 0; i < suiteTondeuse.getSuiteTondeuse().size(); i++) {
				// On sépare la liste en zéro de getTondeusePosition en sous chaine dont le
				// séparateur est espace
				acquisition0 = tondre.getTondeusePosition().get(0).split(" ");
				// xmax est l'abscisse maximale de la pelouse
				xmax = Integer.parseInt(acquisition0[0]);
				// ymax est l'ordonné maximale de la pelouse
				ymax = Integer.parseInt(acquisition0[1]);
				// On sépare la liste en i+1 de getTondeusePosition en sous chaine dont le
				// séparateur est espace
				tableauValeur = tondre.getTondeusePosition().get(i + 1).split(" ");
				// Position initiale en abscisse de la tondeuse de la liste getTondeusePosition
				// en position i+1
				// puisque 0 est la position de la grille
				x = Integer.parseInt(tableauValeur[0]);
				// Position initiale en ordonné de la tondeuse de la liste getTondeusePosition
				// en position i+1
				// puisque 0 est la position de la grille
				y = Integer.parseInt(tableauValeur[1]);
				// Orientation initiale de la tondeuse tableauValeur[2] correspond au 3eme
				// caractére de la position qui est une lettre
				orientation = tableauValeur[2];

				// Permet de retourner les positions finales des tondeuses avec tous les
				// paramétres necessaires en entré
				mouv.mouvement(suiteTondeuse.getSuiteTondeuse().get(i).getTondeuseDirection(), orientation, x, y, xmax,
						ymax);

			}

		} catch (Exception e) {
			System.out.println(
					"Une erreur s'est produite vérifier que le format du fichier txt en entré est conforme." + e);

		}

	}
}
