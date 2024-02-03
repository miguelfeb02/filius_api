package com.dklb.filius.infrastructure.driven_adapter.database.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
    UserEntity save(UserEntity user);
}
