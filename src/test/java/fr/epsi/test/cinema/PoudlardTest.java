package fr.epsi.test.cinema;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PoudlardTest {

	private Poudlard poudlard;

	@BeforeEach
	void setUp() {
		poudlard = new Poudlard();
	}

	@Test
	void testPoudlard() {
		assertEquals(4, poudlard.getMaisonsEleves().size());
		assertNull(poudlard.getMaisonsEleves().get(Maison.Griffondor));
		assertNull(poudlard.getMaisonsEleves().get(Maison.Poufsoufle));
		assertNull(poudlard.getMaisonsEleves().get(Maison.Serpentard));
		assertNull(poudlard.getMaisonsEleves().get(Maison.Serdaigle));

		assertThat(poudlard.getMaisonsEleves()).containsOnly(entry(Maison.Griffondor, null),
				entry(Maison.Poufsoufle, null), entry(Maison.Serpentard, null), entry(Maison.Serdaigle, null));
	}

	@Test
	@DisplayName("Test de l’inscription de Lucius Malefoy")
	void testInscriptionEleve() {

		poudlard.inscriptionEleve("Lucius Malefoy", Maison.Serpentard);

		assertEquals("Lucius Malefoy", poudlard.getMaisonsEleves().get(Maison.Serpentard).get(0));
		assertThat(poudlard.getMaisonsEleves().get(Maison.Serpentard).contains("Lucius Malefoy"));

	}

	@Test
	void testArriveDesHeros() {

		poudlard.arriveDesHeros();

		assertEquals("Harry Potter", poudlard.getMaisonsEleves().get(Maison.Griffondor).get(0));
		assertEquals("Ron Whisley", poudlard.getMaisonsEleves().get(Maison.Griffondor).get(1));
		assertEquals("Hermionne Granger", poudlard.getMaisonsEleves().get(Maison.Griffondor).get(2));
		assertThat(poudlard.getMaisonsEleves().get(Maison.Griffondor)).containsExactly("Harry Potter", "Ron Whisley",
				"Hermionne Granger");
	}

	@ParameterizedTest(name = "Test de la maison de ''{0}''")
	@ValueSource(strings = { "Harry Potter", "Ron Whisley", "Hermionne Granger" })
	void testFindMaison(String eleve) {
		poudlard.arriveDesHeros();
		Maison response = poudlard.findMaison(eleve);
		assertEquals(Maison.Griffondor, response);
	}

}
