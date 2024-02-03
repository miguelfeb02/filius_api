package com.dklb.filius.infrastructure.controllers;

import com.dklb.filius.infrastructure.config.security.encrypt.EncriptFilter;
import com.dklb.filius.infrastructure.helpers.models.request.adminRequest.AdminRequest;
import com.dklb.filius.infrastructure.helpers.models.request.loginRequest.LoginRequest;
import com.dklb.filius.infrastructure.service.AdminLayerService;
import com.dklb.filius.infrastructure.helpers.models.general.Resultado;
import domain.models.Login;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/filiusApi")
public class AdminController {

    @Autowired
    private AdminLayerService adminLayerService;

    @GetMapping("/free/login-admin")
    public ResponseEntity<Resultado> login(@EncriptFilter @Valid @RequestBody LoginRequest loginRequest){
        Resultado resultado =new Resultado();

        Login login =adminLayerService.loginAdmin(loginRequest.getUid());
        if (!login.getLogin()) {
            resultado.mensaje="usuario no registrado";
            return new ResponseEntity<>(resultado, HttpStatus.CONFLICT);
        }
        resultado.mensaje="se genero el token para admin";
        resultado.respuesta= login.getJwt();
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PostMapping("/free/create-admin")
    public ResponseEntity<Resultado> createAdmin(@Valid @RequestBody AdminRequest adminRequest)  {
        Resultado resultado =new Resultado();
       Boolean adminCreate= adminLayerService.createAdmin(adminRequest);
        if (adminCreate) {
            resultado.mensaje="el usuario ya existe";
            resultado.respuesta= false;
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }
        resultado.mensaje="se creo usuario admin";
        resultado.respuesta= true;
        return new ResponseEntity<>(resultado, HttpStatus.CONFLICT);


    }

}
