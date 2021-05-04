package homework_Day2;

public class Main {

	public static void main(String[] args) {
		Course course1 = new Course("C# + Angular", true, "Engin Demiroð",  "variable/Condition Blocks/Loops/Arrays");
		Course course2 = new Course("Java + React",true , "Engin Demiroð",  "Class/Constractor/Method");
		Course course3 = new Course("Temel Kurs",true , "Engin Demiroð", "Loops...");

		Course[] courses = {course1, course2, course3};
		
		Category category1 = new Category(1234, "Kurslarým");
		Category category2 = new Category(1345, "Tüm Kurslar");
		Category category3 = new Category(1876, "Kampa Hazýrlýk");
		Category category4 = new Category(1948, "Sýk Sorulan Sorular");
		
		Category[] categories = {category1, category2, category3, category4};
		
		for(Course course : courses) {
			System.out.println(course.courseName);
		}
		System.out.println("-------------------------------------");
		
		for(Course course : courses) {
			System.out.println(course.homework);
		}
		
		System.out.println("-------------------------------------");
		
		for (Category category : categories) {
			System.out.println(category.categoryName);
		}
		System.out.println("--------------------------------------");
		
		CourseManager courseManager = new CourseManager();
		courseManager.add(course1);
		courseManager.delete(course2);
		
		
		
		
	}
}