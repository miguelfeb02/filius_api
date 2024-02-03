package com.dklb.filius.infrastructure.helpers.mapperEntity;

import domain.models.Admin;
import com.dklb.filius.infrastructure.driven_adapter.database.admin.AdminEntity;
import org.modelmapper.ModelMapper;

public class AdminMapper {
    ModelMapper modelMapper=new ModelMapper();

    public Admin AdminEntityToUser(AdminEntity adminEntity) {
        return modelMapper.map(adminEntity,Admin.class);
    }

   public AdminEntity UsertoAdminEntity(Admin admin) {
        return modelMapper.map(admin, AdminEntity.class);
    }


}
