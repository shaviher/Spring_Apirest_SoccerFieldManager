package com.javierhernandez.soccerfieldmanager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javierhernandez.soccerfieldmanager.DTOs.UserRegisterDTO;
import com.javierhernandez.soccerfieldmanager.services.AuthService;
import com.javierhernandez.soccerfieldmanager.services.CloudinaryService;

import jakarta.validation.Valid;

//Logs registros 
//param parametro dentro de la ruta 
//Req es la petidcion 
//Res todo lo que el api me responde 

@RestController
@RequestMapping("soccerfield/v1/auth") // Para buscar la clasa es como una direccion para buscar un metodo en
                                       // especifico (url general)
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
        @RequestPart("profilePicture") MultipartFile profilePicture,
        @Valid @ModelAttribute UserRegisterDTO userDto, // los valida y los manda
        BindingResult result){

        Map<String, Object> res = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .collect(Collectors.toList());
        res.put("Errores", errors);
        return new ResponseEntity<>(res, HttpStatus.SC_BAD_REQUEST);
        }

        try{
            logger.info("Enviando el archivo a cloudinary");
            Map<String,Object> uploadResult = CloudinaryService.uploadImg(profilePicture,"profiles");
            String profilePhoto.sub
        }catch(IOException e){
            logger.error("Error de entrada de archivos");
            res.put("Mensaje", "Error al subir imagen");
            res.put("Error",e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }catch(CannotCreateTransactionException e){
            logger.error("Error de entrada de archivos");
            res.put("Mensaje","Error al subir imagen");
            res.put("Error",e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SC_SERVICE_UNAVAILABLE);
        }catch(DataAccessException e){
            logger.error("Error de entrada de archivos");
            res.put("Mensaje","Error al subir imagen");
            res.put("Error",e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SC_SERVICE_UNAVAILABLE);
        }
    }
}