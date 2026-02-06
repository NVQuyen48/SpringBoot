package com.vti.SpringBoot.repository;

import com.vti.SpringBoot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, String> {
}
