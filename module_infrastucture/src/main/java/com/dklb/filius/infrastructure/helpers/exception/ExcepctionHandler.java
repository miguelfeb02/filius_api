package com.dklb.filius.infrastructure.helpers.exception;

import com.dklb.filius.infrastructure.helpers.models.general.Resultado;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.UnexpectedTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;



@RestControllerAdvice()
@Slf4j
public class ExcepctionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException methodArgumentNotValidException){
        log.info(methodArgumentNotValidException.getMessage());
        Resultado resultado = new Resultado();
        resultado.setMensaje(methodArgumentNotValidException.getMessage());
        resultado.respuesta=null;
        return new ResponseEntity<>(resultado,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGeneralException(HttpServletRequest request,Exception exception){
        log.info(exception.getClass().toString());
        Resultado resultado = new Resultado();
        resultado.setMensaje(exception.getMessage());
        resultado.respuesta=null;
        return new ResponseEntity<>(resultado,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handlerGeneralException(HttpServletRequest request,BadCredentialsException exception){

        Resultado resultado = new Resultado();
        resultado.setMensaje("Credenciales incorrectas");
        resultado.respuesta=null;
        return new ResponseEntity<>(resultado,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> handlerGeneralException(HttpServletRequest request,NoHandlerFoundException exception){

        Resultado resultado = new Resultado();
        resultado.setMensaje("No found");
        resultado.respuesta=null;
        return new ResponseEntity<>(resultado,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FirebaseAuthException.class)
    public ResponseEntity<?> handlerFirebaseAuthException(HttpServletRequest request,FirebaseAuthException exception){

        Resultado resultado = new Resultado();
        resultado.setMensaje(exception.getMessage());
        resultado.respuesta=null;
        return new ResponseEntity<>(resultado,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> handlerBindException(HttpServletRequest request,UnexpectedTypeException exception){

        Resultado resultado = new Resultado();
        resultado.setMensaje(exception.getMessage());
        resultado.respuesta=null;
        return new ResponseEntity<>(resultado,HttpStatus.BAD_REQUEST);
    }







    
}
