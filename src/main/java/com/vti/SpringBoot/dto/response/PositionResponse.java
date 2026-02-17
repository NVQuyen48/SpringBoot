package com.vti.SpringBoot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionResponse {
    private Integer positionId;
    private String positionName;
}
