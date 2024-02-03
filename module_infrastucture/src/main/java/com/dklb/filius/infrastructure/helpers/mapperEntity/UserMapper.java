package com.dklb.filius.infrastructure.helpers.mapperEntity;

import com.dklb.filius.infrastructure.driven_adapter.database.user.UserEntity;
import domain.models.User;
import org.modelmapper.ModelMapper;

public class UserMapper {


        ModelMapper modelMapper=new ModelMapper();

        public User UserEntityToUser(UserEntity userEntity) {
            return modelMapper.map(userEntity,User.class);
        }

        public UserEntity UsertoUserEntity(User user) {
            return modelMapper.map(user, UserEntity.class);
        }



}
