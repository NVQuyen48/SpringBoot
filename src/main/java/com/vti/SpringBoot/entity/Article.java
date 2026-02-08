package com.vti.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.spi.Status;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    private String title;

    private Status status;
}
