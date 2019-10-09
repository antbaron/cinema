package fr.epsi.test.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Poudlard {

	Map<Maison, List<String>> maisonsEleves = new HashMap<>();

	public Poudlard() {
		this.maisonsEleves.put(Maison.Griffondor, null);
		this.maisonsEleves.put(Maison.Poufsoufle, null);
		this.maisonsEleves.put(Maison.Serpentard, null);
		this.maisonsEleves.put(Maison.Serdaigle, null);
	}

	public void inscriptionEleve(String nomPrenom, Maison maison) {
		List<String> eleves = this.maisonsEleves.get(maison);
		if (eleves == null) {
			eleves = new ArrayList<String>();
			this.maisonsEleves.put(maison, eleves);
		}
		eleves.add(nomPrenom);

	}

	public void arriveDesHeros() {
		inscriptionEleve("Harry Potter", Maison.Griffondor);
		inscriptionEleve("Ron Whisley", Maison.Griffondor);
		inscriptionEleve("Hermionne Granger", Maison.Griffondor);
	}

	public Maison findMaison(String eleve) {
		Maison maison = null;
		for (Entry<Maison, List<String>> maisonEleve : maisonsEleves.entrySet()) {
			if (maisonEleve.getValue() != null && maisonEleve.getValue().contains(eleve)) {
				maison = maisonEleve.getKey();
			}
		}
		return maison;
	}

	public Map<Maison, List<String>> getMaisonsEleves() {
		return maisonsEleves;
	}

	public void setMaisonsEleves(Map<Maison, List<String>> maisonsEleves) {
		this.maisonsEleves = maisonsEleves;
	}

}
