package homework_Day3;

public class Instructor extends User {
	String sertificate;
	
public Instructor() {
		
	}  

	public Instructor(String sertificate) {
		super();
		this.sertificate = sertificate;
	}

	public String getSertificate() {
		return sertificate;
	}

	public void setSertificate(String sertificate) {
		this.sertificate = sertificate;
	
	}
	
}

