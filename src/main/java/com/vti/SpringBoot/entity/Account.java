package com.vti.SpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int departmentId;
    private int positionId;
    private Date createdDate;

}
