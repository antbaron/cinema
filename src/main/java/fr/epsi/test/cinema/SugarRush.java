package fr.epsi.test.cinema;

public class SugarRush {
	
	private Joueur[] joueurs = {new Joueur("Vaneloppe"), new Joueur("Sa sucrerie"), new Joueur("Candlehead")};
	
	
	public Joueur selectionJoueur(String nom) {
		Joueur joueurSelectionne = null;
		for(int i = 0; i < 3; i++) {
			joueurSelectionne = isJoueur(joueurs[i], nom);
			if(joueurSelectionne != null) {
				break;
			}
		}
		return joueurSelectionne;
	}
	
	private Joueur isJoueur(Joueur j, String nom) {
		if(new Joueur(nom).equals(j)) {
			return j;
		} else {
			return null;
		}
	}

}
