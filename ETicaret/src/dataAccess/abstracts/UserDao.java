package dataAccess.abstracts;

import java.util.List;

import entities.concrates.User;

public interface UserDao {

	 void add(User user);
	    void delete(User user);
	    void update(User user);
	    User getByMail(String email);
	    User getByPassword(String password);
	    List<User> getAll();
	    boolean passwordValidationCheck(String password);
	    boolean nameValidationCheck(String firstName, String lastName);
	    boolean mailUsedCheck(String email);
	    boolean loginByCheck(String email, String password);
}
