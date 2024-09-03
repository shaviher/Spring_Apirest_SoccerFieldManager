package com.javierhernandez.soccerfieldmanager.DTOs;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDTO implements Serializable{

    private String Id;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Ingresa una dirrecion de correo valida")
    private String email;
    @NotBlank(message = "La contraseña es obligatorio")
    private String password;
    @NotBlank(message = "El usuario es obligatorio")
    private String username;
    private String name;
    private String surname;
}
