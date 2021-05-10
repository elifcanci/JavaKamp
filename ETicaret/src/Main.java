import business.abstracts.UserService;
import business.concrates.UserManager;
import core.concretes.GoogleManagerAdapter;
import dataAccess.concrates.HibernateUser;
import entities.concrates.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateUser(), new GoogleManagerAdapter());
        User user = new User(121, "Elif","Cancý","cancielif433@gmail.com","54");
        userService.add(user);

        System.out.println("\n---------\n");

        User user2 = new User(16516, "Yýlmaz","Sinem","ylmzsnm@gmail.com","1dfsdff2");
        userService.register(user2);
        userService.login("ylmzsnm@gmail.com","123");
        userService.add(user2);

        System.out.println("\n---------\n");

        User user3 = new User(546162, "Engin","Demiroð","engin@gcom","789789789");
        userService.register(user3);

        System.out.println("\n---------\n");

        userService.getAll();
	}

}
