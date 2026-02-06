package com.vti.SpringBoot.service;

import com.vti.SpringBoot.entity.Department;
import com.vti.SpringBoot.repository.IDepartmentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService {
    IDepartmentRepository iDepartmentRepository;


    public Department createDepartment(Department res) {
        Department department = new Department();
        department.setId(UUID.randomUUID().toString());
        department.setDepartmentCode(res.getDepartmentCode());
        department.setDepartmentName(res.getDepartmentName());

        return iDepartmentRepository.save(department);
    }

    public List<Department> getDepartments() {
        return iDepartmentRepository.findAll();
    }

    public Department getDepartmentById(String id) {
        return iDepartmentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public Department updateDepartment(String departmentCode, Department res) {
        Department department = iDepartmentRepository.findById(departmentCode)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setDepartmentCode(res.getDepartmentCode());
        department.setDepartmentName(res.getDepartmentName());
        return iDepartmentRepository.save(department);

    }

    public void deleteDepartment(String departmentCode) {
        iDepartmentRepository.deleteById(departmentCode);
    }
}
