package com.dklb.filius.infrastructure.service;

import aplication.service.AdminAppService;
import com.dklb.filius.infrastructure.helpers.models.request.adminRequest.AdminRequest;
import domain.models.Admin;
import domain.models.Login;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLayerService {

    @Autowired
    private AdminAppService adminAppService;

    ModelMapper modelMapper=new ModelMapper();

   public Boolean createAdmin(AdminRequest AdminRequest){
      Admin admin= modelMapper.map(AdminRequest, Admin.class);
       return adminAppService.createAdmin(admin);
    }

   public Login loginAdmin(String uid){
        return adminAppService.loginAdmin(uid);
    }


}
