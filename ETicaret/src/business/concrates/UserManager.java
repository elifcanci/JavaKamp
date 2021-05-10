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
		System.out.println("Kullan�c� listeleri: ");
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
	        System.out.print("L�tfen do�rulama kodunu giriniz: ");
	        int vCode = scanner.nextInt();
	        return vCode;
	}

	@Override
	public void login(String email, String password) {
		if(userDao.loginByCheck(email,password))
            System.out.println("Ba�ar�yla giri� yap�ld�!");
        System.out.println("Giri� ba�ar�s�z! Hatal� email veya parola!");
		
	}

	@Override
	public void logout() {
		System.out.println("��k�� yap�l�yor...");
		
	}

	@Override
	public boolean register(User user) {
		if(this.userDao.nameValidationCheck(user.getFirstName(),user.getLastName())==true &&
                this.userDao.passwordValidationCheck(user.getPassword()) && this.userDao.mailUsedCheck(user.getEmail())==true &&
                googleService.isValidEmail(user.getEmail())) {
            System.out.println("Kayd�n�z al�nd�. Kayd� onaylamak i�in size bir do�rulama kodu g�nderdik!");
            if (sendVerificationCode() == verify(user.getEmail())){
                System.out.println(user.getEmail() + " do�ruland�, kay�t ba�ar�l�!");
                return true;}
            else{
                System.out.println("Hatal� kod! " + user.getEmail() + " do�rulanamad�, Kay�t ba�ar�s�z!");
                return false;}
        }
        else{
            System.out.println(user.getEmail() + " eksik �ifre/ kullan�c� ad�/ email!");
            return false;
        }
	}

}
