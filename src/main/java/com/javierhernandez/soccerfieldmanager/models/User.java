package com.javierhernandez.soccerfieldmanager.models;

import java.io.Serializable;

import com.javierhernandez.soccerfieldmanager.DTOs.UserRegisterDTO;
import com.javierhernandez.soccerfieldmanager.utils.PasswordEncrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // para crear constuctor vacio  
@Entity
@Data 
@Table(name = "user")


public class User implements Serializable {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY) malas practicas
    private String id;

    @Email(message = "Debe de ingresar un emal valido")
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String name;
    private String surname;
    private String password;
    private String profilePhoto;

    public User(UserRegisterDTO userDto, String img){
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
        this.password = PasswordEncrypt.encryptPassword(userDto.getPassword());
        this.name = userDto.getName();
        this.surname = userDto.getSurname();
        this.profilePhoto = img;
    }
}
