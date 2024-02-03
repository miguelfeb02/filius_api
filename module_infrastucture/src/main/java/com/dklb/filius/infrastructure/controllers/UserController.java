package com.dklb.filius.infrastructure.controllers;

import com.dklb.filius.infrastructure.helpers.models.request.loginRequest.LoginRequest;
import com.dklb.filius.infrastructure.helpers.models.request.userReuqest.ActiveUserRequest;
import com.dklb.filius.infrastructure.helpers.models.request.userReuqest.UserRequest;
import com.dklb.filius.infrastructure.service.UserLayerService;
import com.google.firebase.auth.FirebaseAuthException;
import com.dklb.filius.infrastructure.helpers.models.general.Resultado;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping("/filiusApi")
public class UserController {

    @Autowired
    private UserLayerService userLayerService;

    @PostMapping("/admin/create-user")
    public ResponseEntity<Resultado> createUser(@Valid @RequestBody UserRequest userRequest) throws FirebaseAuthException {
        Resultado resultado =new Resultado();
        resultado.mensaje="se creo el usuario user";
        userLayerService.createUserFirebaseYJpa(userRequest);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PostMapping("/admin/cambiar-estado-user")
    public ResponseEntity<Resultado> cambiarEstadoUser(@Valid @RequestBody ActiveUserRequest activeUserRequest)  {
        Resultado resultado =new Resultado();
        resultado.mensaje="se cambio el estado del usuario";
        userLayerService.cambiarEstado(activeUserRequest);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/free/login-user")
    public ResponseEntity<Resultado> loginUser(@Valid @RequestBody LoginRequest loginRequest) throws FirebaseAuthException {
        Resultado resultado =new Resultado();
        resultado.mensaje="se genero el token para user";
        resultado.respuesta= userLayerService.loginUser(loginRequest.getUid());
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }



}
