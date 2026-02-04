package com.vti.SpringBoot.repository;

import com.vti.SpringBoot.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryV1 {
    public DepartmentRepositoryV1() {

    }

    public List<String> getAllDepartments() {
        List<String> departments = new ArrayList<>();
        departments.add("Sale");
        departments.add("Salary");
        return departments;
    }

    public void createDepartment() {

    }
}
