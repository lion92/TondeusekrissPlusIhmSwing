package testJunit;

import org.junit.Assert;
import org.junit.Test;

import exception.SuiteTondeuseNullException;
import exception.TondeuseNullException;
import lecture.Lire;
import mouvement.Mouvement;
import tondeuse.SuiteTondeuse;
import tondeuse.Tondeuse;

/***
 * Test unitaire
 * 
 * @author Clotilde kriss
 *
 */
public class TestUnitaire {

	private void main(int numeroTondeuse, String resultatAttendu) throws SuiteTondeuseNullException {
		// lecture du fichier type avec les direction la taille de la grille et la
		// position initiale de la tondeuse
		Lire lire = new Lire(new java.io.File("").getAbsolutePath() + "\\src\\txt\\test.txt");
		// Instanciation de la class mouvement
		Mouvement mouv = new Mouvement();

		// initialisation du tableau parts
		String[] tableauAcquisition = null;
		// découpage du fichier lu en sous chaine qui correspondent aux lignes du
		// fichier texte
		tableauAcquisition = lire.lecture().split(";");
		// Instanciation de suitetondeuse
		SuiteTondeuse suiteTondeuse = new SuiteTondeuse();

		// Instanciation de tondeuse
		Tondeuse tondre = new Tondeuse();

		// for each: pour chaque acquisition si la première lettre est un entier on l
		// ajoute dans position en sachant que
		// la position à zéro est
		// la taille en x et y de la grille

		for (String acquisition : tableauAcquisition) {
			if (acquisition != null) {
				if (acquisition.equals("")) {
					System.out.println(
							"Erreur Il n'y a pas de directions ou de positions pour une tondeuse ou pas d'acquisition de grille.\n "
									+ "Le fichier ne correspond pas à un fichier standard");
					break;
				}

				else {
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
		}
		int x;
		int y;
		int xmax;
		int ymax;
		String orientation = "";
		String tableauValeur[];
		String acquisition0[];

		acquisition0 = tondre.getTondeusePosition().get(0).split(" ");
		xmax = Integer.parseInt(acquisition0[0]);
		ymax = Integer.parseInt(acquisition0[1]);

		tableauValeur = tondre.getTondeusePosition().get(numeroTondeuse + 1).split(" ");
		x = Integer.parseInt(tableauValeur[0]);
		y = Integer.parseInt(tableauValeur[1]);
		orientation = tableauValeur[2];

		Assert.assertTrue((resultatAttendu)
				.equals(mouv.mouvement(suiteTondeuse.getSuiteTondeuse().get(numeroTondeuse).getTondeuseDirection(),
						orientation, x, y, xmax, ymax)));

	}

	public static boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	@Test
	public void test1() throws TondeuseNullException, SuiteTondeuseNullException {

		// Lecture du fichier test.txt dans le package txt.
		// La première tondeuse est situé à 1 2 N ligne 2 avec les directions indiquées
		// sur la ligne 3 et le résultat attendu est 1 3 N.
		// on test donc le main et on voit s'il indique bien la position finale attendue
		main(0, "1 3 N");

	}

	@Test
	public void test2() throws SuiteTondeuseNullException {
		// Lecture du fichier test.txt dans le package txt.
		// La deuxième tondeuse est situé à 3 3 E ligne 4 avec les directions indiquées
		// sur la ligne 5 et le résultat attendu est 5 1 E.
		// on test donc le main et on voit s'il indique bien la position finale attendue
		main(1, "5 1 E");

	}

	@Test
	public void test3() throws TondeuseNullException {
		// On test la méthode mouvement de la class Mouvement. Si les directions sont
		// chaine vide,
		// la position finale est la même qu depart soit ici 3 3 E
		Mouvement mouv = new Mouvement();

		Tondeuse tondeuse3;

		tondeuse3 = new Tondeuse("");
		Assert.assertTrue(
				mouv.mouvement(tondeuse3.getTondeuseDirection(), "E", 3, 3, 5, 5).equals("" + 3 + " " + 3 + " " + "E"));

	}

	@Test(expected = TondeuseNullException.class)
	public void test4() throws TondeuseNullException {

		Mouvement mouv = new Mouvement();

		Tondeuse tondeuse4;
		// On test l'exception que les directions de tondeuse soit null
		tondeuse4 = new Tondeuse(null);
		Assert.assertFalse(
				mouv.mouvement(tondeuse4.getTondeuseDirection(), "N", 1, 2, 5, 5).equals("" + 1 + " " + 1 + " " + "N"));

	}

	@Test
	public void test5() throws TondeuseNullException {
		// On test la methode mouvement de la class Mouvement. Si les directions sont
		// chaine vide,
		// la position finale est la meme qu'au départ soit ici 3 3 E. Il s'agit d'un
		// test en erreur on attend 1 3 E et non 3 3 E
		Mouvement mouv = new Mouvement();

		Tondeuse tondeuse5;

		tondeuse5 = new Tondeuse("");
		Assert.assertFalse(
				mouv.mouvement(tondeuse5.getTondeuseDirection(), "E", 3, 3, 5, 5).equals("" + 1 + " " + 3 + " " + "E"));

	}

}
