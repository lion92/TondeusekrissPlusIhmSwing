package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/***
 * Class Ihm pour gerer une ihm pour des xmax et ymax inférieurs à 30 Pour aller
 * plus vite changer la valeur du Threadsleep dans la class Mouvement dans la
 * méthode mouvement
 * 
 * @author Clotilde kriss
 *
 */
public class Ihm {
	static ArrayList<String> coupe = new ArrayList<String>();
	static JFrame jFrame = new JFrame("Tondeuse");
	static boolean coupefini = false;

	private Ihm()

	{
	}

	/** Instance unique pré-initialisée */
	private static Ihm instance = new Ihm();

	/** Point d'accès pour l'instance unique du singleton */
	public static Ihm getInstance() {
		return instance;
	}

	public static JPanel createAndShowJFrame(String str) {

		JPanel jpan = new JPanel();
		JLabel label = new JLabel(str);
		jpan.add(label);

		return jpan;
	}

	/**
	 * Placement de la tondeuse dans l ihm Pas d'ihm au dela de xmax>30 ou ymax>30
	 * 
	 * @param xp          Position en abscisse de la tondeuse dans l'ihm
	 * @param yp          Position en ordonné de la tondeuse dans l'ihm
	 * @param xmax        Position en abscisse max de la pelouse dans l'ihm
	 * @param ymax        Position en ordonné max de la tondeuse dans l'ihm
	 * @param orientation Orientation de la tondeuse
	 * @param direction   Directions de la tondeuse
	 * @param str         log correspondant à l'historique des positions de la
	 *                    tondeuse dans l'ihm
	 */
	public static void createAndShowJFrame(int xp, int yp, int xmax, int ymax, String orientation, String direction,
			String str) {
		// "Pas d'ihm au dela de x ou y max>30");

		if (!(xmax > 30 || ymax > 30)) {

			// Instantiation de la fenetre principale
			JPanel jprincipale = new JPanel(new BorderLayout());

			// Instantiation de la fenetre ihm viewer
			JPanel jPanel = new JPanel(new GridLayout(xmax + 1, ymax + 1));
			// algorithme pour placer les positions des cases et de la tondeuse dans le
			// viewer
			// On parcours les y en commençant par ymax jusqu'à y0 afin d avoir le y max en
			// haut à droite par raport au gridLayout
			for (int y = ymax; y >= 0; y--) {
				for (int x = 0; x < xmax + 1; x++) {
					if (xp == x && yp == y) {
						JLabel x1 = new JLabel("X " + direction + " " + orientation);
						x1.setOpaque(true);
						x1.setBackground(Color.gray);
						x1.setForeground((Color.red));
						// On ajoute les xmax en commençant par zero
						jPanel.add(x1);
						coupe.add("" + xp + yp);
						// on garde en mémoire les positions de la tondeuse

					} else {

						if (dejaCouper(x, y)) {
							// si la tondeuse est déjà passé sur une case, celle-ci reste grise
							JLabel autre = new JLabel(("" + x + "" + y));
							autre.setOpaque(true);
							autre.setBackground(Color.gray);

							jPanel.add(autre);
						} else {
							// si la tondeuse n est pas déjà passé sur une case, celle-ci est verte
							JLabel autre = new JLabel(("" + x + "" + y));
							autre.setOpaque(true);
							autre.setBackground(Color.green);

							jPanel.add(autre);

						}
					}
				}
			}
			// A l est de la fenetre prinicipale, il y aura le viewer de la tomdeuse
			jprincipale.add(jPanel, BorderLayout.EAST);
			JScrollPane panelPane2 = new JScrollPane(createAndShowJFrame(str));
			// A l ouest de la fenetre principale il y aura des suivis de positions en
			// console
			jprincipale.add(panelPane2, BorderLayout.WEST);

			// setting de la fenetre principale en jframe
			jFrame.setPreferredSize(new Dimension(1000, 1000));
			jFrame.setContentPane(jprincipale);
			jFrame.pack();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setLocationRelativeTo(null);
			jFrame.setVisible(true);
		}
	}

	/**
	 * 
	 * @param x Position en abscisse des positions de la pelouse déjà coupées
	 * @param y Position en ordonné des positions de la pelouse déjà coupées
	 * @return true si la position x et y existe déjà dans la liste coupe
	 */
	private static boolean dejaCouper(int x, int y) {

		for (String coup : coupe) {
			if (coup.equals("" + x + y)) {
				coupefini = true;
				break;
			} else {

				coupefini = false;
			}
		}
		return coupefini;
	}
}
