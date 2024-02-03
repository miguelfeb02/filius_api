package com.dklb.filius.infrastructure.config.beans;


import aplication.service.AdminAppService;
import aplication.service.ProductAppService;
import aplication.service.UserAppService;
import com.dklb.filius.infrastructure.config.singleton.SingletonBean;
import domain.repository.AdminRepository;
import domain.repository.FirebaseRepository;
import domain.repository.ProductRepository;
import domain.repository.UserRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;


import java.io.FileInputStream;
import java.io.IOException;


@Configuration
public class BeanConfiguration {


    @Bean
    public ProductAppService productService(ProductRepository productRepository){
        return new ProductAppService(productRepository);
    }

    @Bean
    public AdminAppService adminService(AdminRepository adminRepository, FirebaseRepository firebaseRepository){
        return new AdminAppService(adminRepository,firebaseRepository);
    }

    @Bean
    public UserAppService userService(UserRepository userRepository, FirebaseRepository firebaseRepository){
        return new UserAppService(userRepository, firebaseRepository);
    }

    @Bean
    @Scope("singleton")
    public SingletonBean singletonBean(){
        return new SingletonBean();
    }

    @Bean
    @Primary
    public FirebaseApp firebaseInit() throws IOException {
        ClassPathResource resource = new ClassPathResource("firebase.json");

        FileInputStream serviceAccount =
                new FileInputStream(resource.getFile());
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();


        return   FirebaseApp.initializeApp(options);

    }




}