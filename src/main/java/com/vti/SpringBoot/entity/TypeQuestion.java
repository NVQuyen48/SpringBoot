package com.vti.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "type_question")
public class TypeQuestion {
    @Column(name = "type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    @Column(name = "type_name")
    private String typeName;
}
