package homework_Day2;

public class CourseManager {
	
	public void add(Course course) {
		System.out.println(course.courseName + " kursu eklendi.");
	}
	public void delete(Course course) {
		System.out.println(course.courseName + " kursu silindi.");
	}
	public void update(Course course) {
		System.out.println(course.courseName + " kursu güncellendi.");
	}
}
