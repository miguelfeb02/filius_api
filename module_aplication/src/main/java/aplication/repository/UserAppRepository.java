package aplication.repository;

import domain.models.ActiveUser;
import domain.models.Login;
import domain.models.User;

public interface UserAppRepository {
    void createUserFirebaseYJpa(User user);
    Login loginUser(String uid);
    void cambiarEstado(ActiveUser activeUser);
}
