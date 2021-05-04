package homework_Day3;

public class Student extends User {
	String comment;

	public Student() {

	}

	public Student(String comment) {

		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
