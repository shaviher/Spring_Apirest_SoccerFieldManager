package com.javierhernandez.soccerfieldmanager.models;


import java.io.Serializable;
import java.sql.Date;
import java.io.ObjectInputFilter.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="reservation")

public class Reservation implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startTime;
    private Date endTime;
    private String payment;

    private Status status;

    @ManyToOne // De esta clase a la otra (many la clase osea reservation y to one hacia la otra clase en este caso User obj user)
    private User user;

    @ManyToOne
    private SoccerField soccerField;

}
