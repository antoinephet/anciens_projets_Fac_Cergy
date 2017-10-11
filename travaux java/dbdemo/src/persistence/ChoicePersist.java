package persistence;

class ChoicePersist {
	private String id;
	private String courseId;
	private int year;

	public ChoicePersist() {
	}

	public ChoicePersist(String courseId, int year) {
		this.courseId = courseId;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
