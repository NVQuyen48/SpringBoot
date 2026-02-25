package com.vti.SpringBoot.controller;

import com.vti.SpringBoot.dto.request.ApiResponse;
import com.vti.SpringBoot.entity.Department;
import com.vti.SpringBoot.repository.IDepartmentRepository;
import com.vti.SpringBoot.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {

    DepartmentService departmentService;


    @PostMapping
    ApiResponse<Department> createDepartment(@RequestBody @Valid Department res) {
        ApiResponse<Department> apiResponse = new ApiResponse<>();

        apiResponse.setResult(departmentService.createDepartment(res));

        return apiResponse;

    }

    @GetMapping
    List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{departmentId}")
    Department getDepartment(@PathVariable("departmentId") String userId) {
        return departmentService.getDepartmentById(userId);
    }

    @PutMapping("/{departmentCode}")
    public Department updateDepartment(@PathVariable("departmentCode")
                                       String departmentCode, @RequestBody Department res) {
        return departmentService.updateDepartment(departmentCode, res);

    }

    @DeleteMapping("/{departmentCode}")
    public void deleteDepartment(@PathVariable String departmentCode) {
        departmentService.deleteDepartment(departmentCode);
    }


    @GetMapping("/getAll")
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentService.findAllDepartments(pageable);
    }
}
