package dm;

public class Score {
	private double continuousAssessment;
	private double examen;

	public Score(double continuousAssessment, double examen) {
		this.continuousAssessment = continuousAssessment;
		this.examen = examen;
	}

	@Override
	public String toString() {
		return "Score [continuousAssessment=" + continuousAssessment + ", examen=" + examen + "]";
	}

	public double getContinuousAssessment() {
		return continuousAssessment;
	}

	public double getExamen() {
		return examen;
	}

}
