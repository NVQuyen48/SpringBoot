package com.vti.SpringBoot.controller;

import com.vti.SpringBoot.service.DepartmentServiceV2;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department-v2")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentControllerV2 {
    DepartmentServiceV2 departmentServiceV2;

    public DepartmentControllerV2() {
        departmentServiceV2 = new DepartmentServiceV2();
    }

    public void getAllDepartments() {
        List<String> departments = departmentServiceV2.processDepartments();
        System.out.println(departments);
    }
}
