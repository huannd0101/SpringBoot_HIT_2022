package com.hit.buoi12.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DateUtil {

//{"receiver":3,"sender":2,"lists":[1,2,3,4],"room":1}

  private Long receiver;
  private Long sender;
  private List<Long> lists;
  private Long room;

}
