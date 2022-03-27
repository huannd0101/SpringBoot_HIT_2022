package com.example.call_api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Province {
    private String name;
    private String slug;
    private String type;
    private String name_with_type;
    private String code;
}
