package dataAccess.concrates;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concrates.User;

public class HibernateUser implements UserDao {

	private List<User> userList;

	public HibernateUser() {
        userList = new ArrayList<>();
    }
	
	@Override
	public void add(User user) {
		userList.add(user);
        System.out.println("Kullanýcý eklendi: " + user.getFirstName() + "  " + user.getEmail());
		
	}

	@Override
	public void delete(User user) {
		 System.out.println("Kullanýcý silindi: " + user.getFirstName() + " " + user.getEmail());
	        userList.remove(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý güncellendi: " + user.getFirstName() + " " + user.getEmail());
		
	}

	@Override
	public User getByMail(String email) {
		for (User user : userList) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
	}

	@Override
	public User getByPassword(String password) {
		for (User user : userList) {
            if (user.getPassword().equals(password))
                return user;
        }
        return null;
	}

	@Override
	public List<User> getAll() {
		return userList;
	}

	@Override
	public boolean passwordValidationCheck(String password) {
		if (password.length() >= 6)
            return true;
        return false;
	}

	@Override
	public boolean nameValidationCheck(String firstName, String lastName) {
		 if ((firstName.length() >= 2) && (lastName.length() >= 2))
	            return true;
	        return false;
	}

	@Override
	public boolean mailUsedCheck(String email) {
		 for (User user : userList) {
	            if (user.getEmail() == email)
	                return false;
	        }
	        return true;
	}

	@Override
	public boolean loginByCheck(String email, String password) {
		for(User user : userList){
            if(user.getEmail() == email && user.getPassword() == password)
                return true;}
        return false;

    }
}

