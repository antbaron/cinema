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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (missionReussi ? 1231 : 1237);
		result = prime * result + nbPierreInfinite;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thanos other = (Thanos) obj;
		if (missionReussi != other.missionReussi)
			return false;
		if (nbPierreInfinite != other.nbPierreInfinite)
			return false;
		return true;
	}
	

}
