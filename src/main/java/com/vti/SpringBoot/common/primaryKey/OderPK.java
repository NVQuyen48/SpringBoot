package com.vti.SpringBoot.common.primaryKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class OderPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name = "position_id")
    private int positionId;

    @Column(name = "department_id")
    private int departmentId;
}
