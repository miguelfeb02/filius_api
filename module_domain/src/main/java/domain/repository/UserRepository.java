package domain.repository;

import domain.models.User;


public interface UserRepository {
    User saveUser(User user);
    Boolean existsByEmail(String email);
    User findByEmail(String email);
}
