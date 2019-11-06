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
		Thanos thanos = new Thanos(0);

		assertEquals(0, thanos.getNbPierreInfinite());
		assertThat(thanos.getNbPierreInfinite()).isEqualTo(0);
	}

	@Test
	void testThanos6pierre() {
		Thanos thanos = new Thanos(6);

		assertEquals(6, thanos.getNbPierreInfinite());
		assertThat(thanos.getNbPierreInfinite()).isEqualTo(6);
	}

	@Test
	void testGagne0Pierre() {
		Thanos thanos = new Thanos(0);

		thanos.gagnePierre();

		assertEquals(1, thanos.getNbPierreInfinite());
		assertThat(thanos.getNbPierreInfinite()).isEqualTo(1);
	}

	@Test
	void testGagne6Pierre() {
		Thanos thanos = new Thanos(6);

		thanos.gagnePierre();

		assertEquals(6, thanos.getNbPierreInfinite());
		assertThat(thanos.getNbPierreInfinite()).isEqualTo(6);
	}

	@RepeatedTest(7)
	void testGagnePasPlusDe6Pierre(RepetitionInfo testInfo) {
		Thanos sut = new Thanos(testInfo.getCurrentRepetition() - 1);

		sut.gagnePierre();

		assertTrue(sut.getNbPierreInfinite() <= 6);
		
		if(testInfo.getCurrentRepetition() - 1 < 6) {
			assertEquals(testInfo.getCurrentRepetition(), sut.getNbPierreInfinite());
		}else {
			assertEquals(6, sut.getNbPierreInfinite());
		}
	}

	@Test
	void testClaquementDe6Doigts() {
		Thanos sut = new Thanos(0);

		int result = sut.claquementDeDoigts(1_000_000_000);

		assertEquals(1_000_000_000, result);
		assertFalse(sut.isMissionReussi());
		assertThat(sut.isMissionReussi()).isFalse();
	}

	@Test
	void testClaquementDe0Doigts() {
		Thanos thanos = new Thanos(6);

		int result = thanos.claquementDeDoigts(1_000_000_000);

		assertEquals(500_000_000, result);
		assertTrue(thanos.isMissionReussi());
		assertThat(thanos.isMissionReussi()).isTrue();
	}

	@Test
	void testToString() {
		Thanos thanos = new Thanos(0);

		String result = thanos.toString();

		assertEquals("Thanos [nbPierreInfinite=0, missionReussi=false]", result);
		assertThat(thanos.toString()).isEqualTo("Thanos [nbPierreInfinite=0, missionReussi=false]");
	}

	@Test
	void test2Thanos() {
		Thanos thanos = new Thanos(0);
		Thanos thanos2 = new Thanos(0);

		assertEquals(thanos2, thanos);
	}

}
