package homework_Day3;

public class Main {

	public static void main(String[] args) {
		
	Student student1 = new Student();
		student1.setId(1);
		student1.setFirstName("Elif");
		student1.setLastName("Cancı");
		student1.setComment("Yorum");
		
	Instructor instractor1 = new Instructor();
		instractor1.setId(24);
		instractor1.setFirstName("Engin");
		instractor1.setLastName("Demiroğ");
		instractor1.setSertificate(".Net");
		
	StudentManager studentManager = new StudentManager();
	studentManager.Add(student1);
	
	InstructorManager instructorManager = new InstructorManager();
	instructorManager.Add(instractor1);
	
	
		
	
		
		
	}
}
