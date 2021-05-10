package business.abstracts;

import entities.concrates.User;

public interface UserService {

	void add(User user);
    void delete(User user);
    void update(User user);
    void getAll();
    int sendVerificationCode();
    int verify(String email);
    void login(String email, String password);
    void logout();
    boolean register(User user);
}
