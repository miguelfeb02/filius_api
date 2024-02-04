package com.dklb.filius.infrastructure.driven_adapter.firebase;


import com.dklb.filius.infrastructure.driven_adapter.database.admin.AdminCrudRepository;
import com.dklb.filius.infrastructure.driven_adapter.database.user.UserCrudRepository;
import com.dklb.filius.infrastructure.helpers.enums.RoleEnum;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import domain.models.Login;
import domain.repository.FirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;

@Repository
public class FirebaseImplement implements FirebaseRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public String createUserFirebase(String userNick, String pass) {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(userNick + "@filius.com").setPassword(pass);
           UserRecord userRecord= FirebaseAuth.getInstance().createUser(request);
            return userRecord.getEmail();
        } catch (FirebaseAuthException e) {
            System.out.println(e.getMessage());

            return null;
        }


    }

    @Override
    public Login loginFirebase(String uid, String role) {
        try {
            FirebaseAuth.getInstance().getUser(uid);
            UserRecord userFirebase = FirebaseAuth.getInstance().getUser(uid);

            String permission = "";
            if (Objects.equals(role, RoleEnum.ROLE_ADMIN.name())) {
                permission = RoleEnum.ROLE_ADMIN.name();
                Boolean existAdmin = adminCrudRepository.existsByEmail(userFirebase.getEmail());
                if (!existAdmin) return new Login(false, null);
            } else {
                permission = RoleEnum.ROLE_USER.name();
                Boolean existUser = userCrudRepository.existsByEmail(userFirebase.getEmail());
                if (!existUser) return new Login(false, null);

            }
            Map<String, Object> claims = Map.of("authorities", permission);
            String jwt = FirebaseAuth.getInstance().createCustomToken(userFirebase.getUid(), claims);
            return new Login(true, jwt);
        } catch (FirebaseAuthException e) {
            return new Login(false, null);
        }


    }

}
