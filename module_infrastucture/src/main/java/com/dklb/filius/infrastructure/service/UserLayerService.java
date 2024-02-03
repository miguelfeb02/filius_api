package com.dklb.filius.infrastructure.service;

import aplication.service.UserAppService;
import com.dklb.filius.infrastructure.helpers.models.request.userReuqest.ActiveUserRequest;
import com.dklb.filius.infrastructure.helpers.models.request.userReuqest.UserRequest;
import domain.models.ActiveUser;
import domain.models.Login;
import domain.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLayerService {

    @Autowired
    private UserAppService userAppService;

    ModelMapper modelMapper=new ModelMapper();

    public void createUserFirebaseYJpa(UserRequest userRequest){
        User user= modelMapper.map(userRequest, User.class);
        userAppService.createUserFirebaseYJpa(user);
    }

    public Login loginUser(String uid){
       return userAppService.loginUser(uid);
    }

    public void cambiarEstado(ActiveUserRequest activeUserRequest){
        ActiveUser activeUser= modelMapper.map(activeUserRequest, ActiveUser.class);
        userAppService.cambiarEstado(activeUser);
    }



}
