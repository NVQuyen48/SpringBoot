package com.vti.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Account {
    @Id
    private int accountId;
    private String email;
    private String userName;
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;
    private Date createdDate;

 
}
