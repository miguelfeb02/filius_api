package com.dklb.filius.infrastructure.driven_adapter.database.admin;


import com.dklb.filius.infrastructure.helpers.mapperEntity.AdminMapper;
import domain.models.Admin;
import domain.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class AdminImplement implements AdminRepository {

    private final AdminCrudRepository adminCrudRepository;

    private final AdminMapper adminMapper = new AdminMapper();

    public AdminImplement(AdminCrudRepository adminCrudRepository) {
        this.adminCrudRepository = adminCrudRepository;
    }

    @Override
    public Admin adminByEmail(String email) {
        Optional<AdminEntity> admin = adminCrudRepository.findByEmail(email);
        if (admin.isEmpty()) throw new UsernameNotFoundException("No se encontro admin por email");
        return adminMapper.AdminEntityToUser(admin.get());
    }

    @Override
    public Boolean existsByEmail(String email) {
        return adminCrudRepository.existsByEmail(email);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminMapper.AdminEntityToUser(adminCrudRepository.save(
                adminMapper.UsertoAdminEntity(admin)));

    }






}
