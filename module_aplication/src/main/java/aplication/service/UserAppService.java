package aplication.service;

import aplication.repository.UserAppRepository;
import domain.enums.RoleEnum;
import domain.models.ActiveUser;
import domain.models.Login;
import domain.models.User;
import domain.repository.FirebaseRepository;
import domain.repository.UserRepository;


public class UserAppService implements UserAppRepository {

    private final UserRepository userRepository;
    private final FirebaseRepository firebaseRepository;

    public UserAppService(UserRepository userRepository, FirebaseRepository firebaseRepository) {
        this.userRepository = userRepository;
        this.firebaseRepository = firebaseRepository;
    }

    @Override
    public void createUserFirebaseYJpa(User user)  {
       String email= firebaseRepository
               .createUserFirebase(user.getUserNick(),user.getPass());

       if (email!=null){
           Boolean existUser=userRepository.existsByEmail(email);
           if (!existUser){
               user.setName(user.getName());
               user.setEmail(email);
               user.setRole(RoleEnum.ROLE_USER);
               user.setBusinessId(user.getBusinessId());
               userRepository.saveUser(user);
           }

       }
    }
    @Override
    public Login loginUser(String uid)  {
       return  firebaseRepository.loginFirebase(uid,RoleEnum.ROLE_USER.name());

    }
    @Override
    public void cambiarEstado(ActiveUser activeUser){
        User user = userRepository.findByEmail(activeUser.getUserNick()+"@filius.com");
        user.setActive(activeUser.getActive());
        userRepository.saveUser(user);
    }




}
