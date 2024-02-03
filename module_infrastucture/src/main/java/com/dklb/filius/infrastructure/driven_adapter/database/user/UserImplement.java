package com.dklb.filius.infrastructure.driven_adapter.database.user;

import domain.models.User;
import domain.repository.UserRepository;
import com.dklb.filius.infrastructure.helpers.mapperEntity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserImplement implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;


    private final UserMapper userMapper = new UserMapper();

    @Override
    public Boolean existsByEmail(String email) {
        return userCrudRepository.existsByEmail(email);
    }

    @Override
    public User findByEmail(String email) {
        Optional<UserEntity> user = userCrudRepository.findByEmail(email);
        if (user.isEmpty()) throw new UsernameNotFoundException("No se encontro usuario por email");
        return userMapper.UserEntityToUser(user.get());
    }

    @Override
    public User saveUser(User user) {
        return userMapper.UserEntityToUser(userCrudRepository.save(
                userMapper.UsertoUserEntity(user)));

    }

}
