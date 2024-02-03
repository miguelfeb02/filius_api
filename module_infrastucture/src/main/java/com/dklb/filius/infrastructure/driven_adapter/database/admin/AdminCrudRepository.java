package com.dklb.filius.infrastructure.driven_adapter.database.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminCrudRepository extends JpaRepository<AdminEntity,String> {
    Optional<AdminEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
    AdminEntity save(AdminEntity adminEntity);

}
