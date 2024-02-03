package aplication.service;

import aplication.repository.AdminAppRepository;
import domain.enums.RoleEnum;
import domain.models.Admin;
import domain.models.Login;
import domain.repository.FirebaseRepository;
import java.time.LocalDateTime;

public class AdminAppService implements AdminAppRepository {
    private final domain.repository.AdminRepository adminRepository;
    private final FirebaseRepository firebaseRepository;

    public AdminAppService(domain.repository.AdminRepository adminRepository, FirebaseRepository firebaseRepository) {
        this.adminRepository = adminRepository;
        this.firebaseRepository = firebaseRepository;
    }

    @Override
    public Login loginAdmin(String uid) {
        return firebaseRepository.loginFirebase(uid, RoleEnum.ROLE_ADMIN.name());
    }

    @Override
    public Boolean createAdmin(Admin admin) {
        Boolean existAdmin = adminRepository.existsByEmail(admin.getEmail());
        if (!existAdmin) {
            admin.setRole(RoleEnum.ROLE_ADMIN);
            admin.setActive(true);
            admin.setDateCreated(LocalDateTime.now());
            adminRepository.saveAdmin(admin);
        }
        return existAdmin;
    }
}
