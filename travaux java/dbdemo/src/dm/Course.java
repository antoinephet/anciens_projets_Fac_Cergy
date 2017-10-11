package dm;

public class Course {
	private String name;
	private Score score;

	public Course(String name, Score score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public Score getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
