package persistence;

import javax.persistence.Embeddable;

@Embeddable
class ScorePersist {
	private double continuousAssessment;
	private double examen;

	public ScorePersist() {
	}

	public double getContinuousAssessment() {
		return continuousAssessment;
	}

	public void setContinuousAssessment(double continuousAssessment) {
		this.continuousAssessment = continuousAssessment;
	}

	public double getExamen() {
		return examen;
	}

	public void setExamen(double examen) {
		this.examen = examen;
	}

}
