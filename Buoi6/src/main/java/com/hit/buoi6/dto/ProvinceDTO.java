package com.hit.buoi6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//ctrl + alt + L: intel window
//ctrl + shift + O: eclipse

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDTO {
    private String name;
    private String type;
    private Long code;
}
