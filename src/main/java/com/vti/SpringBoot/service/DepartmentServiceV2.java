package com.vti.SpringBoot.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentServiceV2 {
    DepartmentRepositoryV1 dDepartmentRepositoryv1;

    public DepartmentServiceV2() {
        dDepartmentRepositoryv1 = new DepartmentRepositoryV1();

    }

    public List<String> getAllDepartments() {
        return dDepartmentRepositoryv1.getAllDepartments();
    }

    public List<String> processDepartments() {
        List<String> departments = getAllDepartments();
        return departments;
    }
}
