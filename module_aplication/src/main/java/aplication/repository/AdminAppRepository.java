package aplication.repository;

import domain.models.Admin;
import domain.models.Login;

public interface AdminAppRepository {
    Boolean createAdmin(Admin admn);
    Login loginAdmin(String uid);
}
