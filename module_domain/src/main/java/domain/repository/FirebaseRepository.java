package domain.repository;


import domain.models.Login;

public interface FirebaseRepository {
    public Login loginFirebase(String uid, String role);
    public String createUserFirebase(String userNick, String pass);
}
