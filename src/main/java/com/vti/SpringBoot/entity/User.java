package com.vti.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address addressId;


}
