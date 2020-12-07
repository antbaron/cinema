package fr.epsi.test.cinema;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class ThanosTest {

	@Test
	void testThanos0pierre() {
		//Act
		Thanos sut = new Thanos(0);
		//Assert
		assertEquals(0, sut.getNbPierreInfinite());
		assertThat(sut.getNbPierreInfinite()).isEqualTo(0);
	}

	@Test
	void testThanos6pierres() {
		//Act
		Thanos sut = new Thanos(6);
		//Assert
		assertEquals(6, sut.getNbPierreInfinite());
		assertThat(sut.getNbPierreInfinite()).isEqualTo(6);
	}

	@Test
	void testGagnePierreAvec0() {
		//Arrange
		Thanos sut = new Thanos(0);
		//Act
		sut.gagnePierre();
		//Assert
		assertEquals(1, sut.getNbPierreInfinite());
		assertThat(sut.getNbPierreInfinite()).isEqualTo(1);
	}

	@Test
	void testGagnePierreAvec6() {
		//Arrange
		Thanos sut = new Thanos(6);
		//Act
		sut.gagnePierre();
		//Assert
		assertEquals(6, sut.getNbPierreInfinite());
		assertThat(sut.getNbPierreInfinite()).isEqualTo(6);
	}

	@RepeatedTest(7)
	void testGagnePasPlusDe6Pierres(RepetitionInfo testInfo) {
		//Arrange
		Thanos sut = new Thanos(testInfo.getCurrentRepetition() - 1);
		//Act
		sut.gagnePierre();
		//Assert
		assertTrue(sut.getNbPierreInfinite() <= 6);
		
		if(testInfo.getCurrentRepetition() - 1 < 6) {
			assertEquals(testInfo.getCurrentRepetition(), sut.getNbPierreInfinite());
		}else {
			assertEquals(6, sut.getNbPierreInfinite());
		}
	}

	@Test
	void testClaquementDe6Doigts() {
		//Arrange
		Thanos sut = new Thanos(0);
		//Act
		int result = sut.claquementDeDoigts(1_000_000_000);
		//Assert
		assertEquals(1_000_000_000, result);
		assertFalse(sut.isMissionReussi());
		assertThat(sut.isMissionReussi()).isFalse();
	}

	@Test
	void testClaquementDe0Doigts() {
		//Arrange
		Thanos sut = new Thanos(6);
		//Act
		int result = sut.claquementDeDoigts(1_000_000_000);
		//Assert
		assertEquals(500_000_000, result);
		assertTrue(sut.isMissionReussi());
		assertThat(sut.isMissionReussi()).isTrue();
	}

	@Test
	void testToString() {
		//Arrange
		Thanos sut = new Thanos(0);
		//Act
		String result = sut.toString();
		//Assert
		assertEquals("Thanos [nbPierreInfinite=0, missionReussi=false]", result);
		assertThat(sut.toString()).isEqualTo("Thanos [nbPierreInfinite=0, missionReussi=false]");
	}

	@Test
	void test2Thanos() {
		//Arrange
		Thanos sut = new Thanos(0);
		Thanos sut2 = new Thanos(0);
		// Act
		boolean result = sut.equals(sut2);
		//Assert
		assertTrue(result);
	}

}
