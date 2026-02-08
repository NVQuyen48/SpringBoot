package com.vti.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;


}
