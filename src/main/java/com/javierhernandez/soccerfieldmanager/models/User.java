package com.javierhernandez.soccerfieldmanager.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

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
    private String emal;

    @Column(unique = true)
    private String username;

    private String name;
    private String surname;
    private String password;
    private String profilePhoto;
}
