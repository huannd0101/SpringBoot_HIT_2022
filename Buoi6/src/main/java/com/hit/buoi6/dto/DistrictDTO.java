package com.hit.buoi6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    private String name;
    private String type;
    private String path;
    private Long code;
    private Long parentCode;
}
