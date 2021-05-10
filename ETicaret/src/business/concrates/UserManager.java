package business.concrates;

import java.util.Random;
import java.util.Scanner;

import business.abstracts.UserService;
import core.abstracts.GoogleService;
import dataAccess.abstracts.UserDao;
import entities.concrates.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private GoogleService googleService;

	public UserManager(UserDao userDao, GoogleService googleService) {
		this.userDao = userDao;
		this.googleService = googleService;
	}

	@Override
	public void add(User user) {
		userDao.add(user);

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void getAll() {
		System.out.println("Kullanýcý listeleri: ");
        int i=1;
        for(User user : userDao.getAll()){
                System.out.println(i + "- " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
                i++;}
		
	}

	@Override
	public int sendVerificationCode() {
		  Random random = new Random();
	        int verificationCode = random.nextInt(500)*10;
	        System.out.println(verificationCode);
	        return verificationCode;
	}

	@Override
	public int verify(String email) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Lütfen doðrulama kodunu giriniz: ");
	        int vCode = scanner.nextInt();
	        return vCode;
	}

	@Override
	public void login(String email, String password) {
		if(userDao.loginByCheck(email,password))
            System.out.println("Baþarýyla giriþ yapýldý!");
        System.out.println("Giriþ baþarýsýz! Hatalý email veya parola!");
		
	}

	@Override
	public void logout() {
		System.out.println("Çýkýþ yapýlýyor...");
		
	}

	@Override
	public boolean register(User user) {
		if(this.userDao.nameValidationCheck(user.getFirstName(),user.getLastName())==true &&
                this.userDao.passwordValidationCheck(user.getPassword()) && this.userDao.mailUsedCheck(user.getEmail())==true &&
                googleService.isValidEmail(user.getEmail())) {
            System.out.println("Kaydýnýz alýndý. Kaydý onaylamak için size bir doðrulama kodu gönderdik!");
            if (sendVerificationCode() == verify(user.getEmail())){
                System.out.println(user.getEmail() + " doðrulandý, kayýt baþarýlý!");
                return true;}
            else{
                System.out.println("Hatalý kod! " + user.getEmail() + " doðrulanamadý, Kayýt baþarýsýz!");
                return false;}
        }
        else{
            System.out.println(user.getEmail() + " eksik þifre/ kullanýcý adý/ email!");
            return false;
        }
	}

}
