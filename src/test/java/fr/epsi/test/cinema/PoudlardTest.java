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

	private Poudlard sut;

	@BeforeEach
	void setUp() {
		sut = new Poudlard();
	}

	@Test
	void testPoudlard() {
		assertEquals(4, sut.getMaisonsEleves().size());
		assertNull(sut.getMaisonsEleves().get(Maison.Griffondor));
		assertNull(sut.getMaisonsEleves().get(Maison.Poufsoufle));
		assertNull(sut.getMaisonsEleves().get(Maison.Serpentard));
		assertNull(sut.getMaisonsEleves().get(Maison.Serdaigle));

		assertThat(sut.getMaisonsEleves()).containsOnly(entry(Maison.Griffondor, null),
				entry(Maison.Poufsoufle, null), entry(Maison.Serpentard, null), entry(Maison.Serdaigle, null));
	}

	@Test
	@DisplayName("Test de l’inscription de Lucius Malefoy")
	void testInscriptionEleve() {
		// Act
		sut.inscriptionEleve("Lucius Malefoy", Maison.Serpentard);
		// Assert
		assertEquals("Lucius Malefoy", sut.getMaisonsEleves().get(Maison.Serpentard).get(0));
		assertThat(sut.getMaisonsEleves().get(Maison.Serpentard).contains("Lucius Malefoy"));

	}

	@Test
	void testArriveDesHeros() {
		// Act
		sut.arriveDesHeros();
		// Assert
		assertEquals("Harry Potter", sut.getMaisonsEleves().get(Maison.Griffondor).get(0));
		assertEquals("Ron Whisley", sut.getMaisonsEleves().get(Maison.Griffondor).get(1));
		assertEquals("Hermionne Granger", sut.getMaisonsEleves().get(Maison.Griffondor).get(2));
		assertThat(sut.getMaisonsEleves().get(Maison.Griffondor)).containsExactly("Harry Potter", "Ron Whisley",
				"Hermionne Granger");
	}

	@ParameterizedTest(name = "Test de la maison de ''{0}''")
	@ValueSource(strings = { "Harry Potter", "Ron Whisley", "Hermionne Granger" })
	void testFindMaison(String eleve) {
		// Arrange
		sut.arriveDesHeros();
		// Act
		Maison response = sut.findMaison(eleve);
		// Assert
		assertEquals(Maison.Griffondor, response);
	}

}
