package com.vti.SpringBoot.dto.request;

import com.vti.SpringBoot.entity.Department;
import com.vti.SpringBoot.entity.Position;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

public class AccountRequest {

    @NotBlank(message = "Không được để trống")
    @Email(message = "Email k được định dạng")
    private String email;

    @NotBlank(message = "User Không được để trống")
    @Size(min = 6, max = 50, message = "User phải từ 6-50 kí tự")
    private String userName;


    @NotBlank(message = "Fullname không được trống")
    @Size(max = 50, message = "Fullname tối đa 50 ký tự")
    private String fullName;

    @NotBlank(message = "Department name không được trống")
    private String departmentName;

    @PastOrPresent(message = "CreateDate không được lớn hơn hiện tại")
    private Date createDate;
}
