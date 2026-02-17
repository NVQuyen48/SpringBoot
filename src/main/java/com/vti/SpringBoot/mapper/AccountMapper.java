package com.vti.SpringBoot.mapper;

import com.vti.SpringBoot.dto.response.AccountReponse;
import com.vti.SpringBoot.dto.response.DepartmentResponse;
import com.vti.SpringBoot.dto.response.PositionResponse;
import com.vti.SpringBoot.entity.Account;

public class AccountMapper {
    public static AccountReponse toDTO(Account acc) {
        AccountReponse dto = new AccountReponse();
        dto.setAccountId(acc.getAccountId());
        dto.setUserName(acc.getUserName());
        dto.setEmail(acc.getEmail());

        if (acc.getDepartment() != null) {
            dto.setDepartment(
                    new DepartmentResponse(
                            acc.getDepartment().getDepartmentId(),
                            acc.getDepartment().getDepartmentName()
                    )
            );
        }

        if (acc.getPosition() != null) {
            dto.setPosition(
                    new PositionResponse(
                            acc.getPosition().getPositionId(),
                            acc.getPosition().getPositionName()
                    )
            );
        }

        return dto;
    }
}
