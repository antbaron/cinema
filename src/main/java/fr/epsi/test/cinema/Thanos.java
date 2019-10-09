package fr.epsi.test.cinema;

public class Thanos {

	int nbPierreInfinite;
	boolean missionReussi;

	public Thanos(int nbPierreInfinite) {
		if(nbPierreInfinite <=6) {
			this.nbPierreInfinite = nbPierreInfinite;
		}else {
			this.nbPierreInfinite = 6;
		}
		this.missionReussi = false;
	}

	public void gagnePierre() {
		if (this.nbPierreInfinite < 6) {
			this.nbPierreInfinite++;
		}
	}

	public int claquementDeDoigts(int nbPopulation) {
		int result;
		if (this.nbPierreInfinite == 6) {
			result = nbPopulation / 2;
			this.missionReussi = true;
		} else {
			result = nbPopulation;
		}
		return result;
	}

	public int getNbPierreInfinite() {
		return nbPierreInfinite;
	}

	public void setNbPierreInfinite(int nbPierreInfinite) {
		this.nbPierreInfinite = nbPierreInfinite;
	}

	public boolean isMissionReussi() {
		return missionReussi;
	}

	public void setMissionReussi(boolean missionReussi) {
		this.missionReussi = missionReussi;
	}

	@Override
	public String toString() {
		return "Thanos [nbPierreInfinite=" + nbPierreInfinite + ", missionReussi=" + missionReussi + "]";
	}
	

}
