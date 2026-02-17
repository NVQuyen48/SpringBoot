package com.vti.SpringBoot.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountReponse {
    private Integer accountId;
    private String userName;
    private String email;
    private DepartmentResponse department;
    private PositionResponse position;
}
