package domain.repository;
import domain.models.Admin;


public interface AdminRepository {
    Admin adminByEmail(String email);
    Admin saveAdmin(Admin admin);
    Boolean existsByEmail(String email);

}
