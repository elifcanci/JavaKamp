package homework_Day3;

public class UserManager {
	public void Add(User user) {
		System.out.println(user.firstName +" " + user.lastName + " eklendi.");
	}
	public void Remove(User user) {
		System.out.println(user.firstName + " " + user.lastName + " silindi.");
	}
	public void Update(User user) {
		System.out.println(user.firstName + " güncellendi.");
	}
	
}
