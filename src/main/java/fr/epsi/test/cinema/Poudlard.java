package fr.epsi.test.cinema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Poudlard {

	private static final String HARRY_POTTER = "Harry Potter";
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
		inscriptionEleve(HARRY_POTTER, Maison.Griffondor);
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

	/**
	 * Ex 2 bonus.
	 * @return
	 */
	public Maison findBiggestHome() {		
		Optional<Entry<Maison, List<String>>> result = maisonsEleves.entrySet().stream().max((Entry<Maison, List<String>> e1, Entry<Maison, List<String>> e2) ->  compare(e1,e2));
		return result.get().getKey();
	}

	private int compare(Entry<Maison, List<String>> e1, Entry<Maison, List<String>> e2) {

		List<String> elevesMaison1 = e1.getValue() == null? Collections.emptyList() : e1.getValue();
		List<String> elevesMaison2 = e2.getValue() == null? Collections.emptyList() : e2.getValue();
		
		int result = Integer.compare(elevesMaison1.size(), elevesMaison2.size());
		if(result == 0) {
			result = compare(e1.getKey(), elevesMaison1, e2.getKey(), elevesMaison2);
		}
		
		return result;
	}

	private int compare(Maison maison1, List<String> eleves1, Maison maison2,
			List<String> eleves2) {
		int result;
		boolean eleves2containHP = eleves2.contains(HARRY_POTTER);
		if(eleves1.contains(HARRY_POTTER)) {
			 if(eleves2containHP) {
				 result = maison1.compareTo(maison2); 
			 }else {
				 result = 1;
			 }
		} else if(eleves2containHP) {
			result = -1;
		} else {
			result = maison1.compareTo(maison2);
		}
		return result;
	}
}
