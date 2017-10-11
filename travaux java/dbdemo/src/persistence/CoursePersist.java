package persistence;

class CoursePersist {
	private String id;
	private String name;
	private ScorePersist score;

	public CoursePersist() {
	}

	public CoursePersist(String name, ScorePersist score) {
		this.name = name;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ScorePersist getScore() {
		return score;
	}

	public void setScore(ScorePersist score) {
		this.score = score;
	}

}
