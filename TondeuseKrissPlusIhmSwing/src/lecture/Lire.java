package lecture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class permettant la lecture et la récupération des lignes avec separateur ;
 * 
 * @author Clotilde kriss
 *
 */
public class Lire {
	private String path;
	private String recup = "";

	public Lire(String path) {
		this.path = path;

	}

	/***
	 * Lecture et récupération des lignes avec séparateur ;
	 * 
	 * @return Les lignes du fichier txt avec un séparateur ; en bout de chaine
	 */
	public String lecture() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.path));
			String lecture;
			try {
				while ((lecture = reader.readLine()) != null) {

					recup += lecture + ";";
				}
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);

		}

		return recup;
	}

}
