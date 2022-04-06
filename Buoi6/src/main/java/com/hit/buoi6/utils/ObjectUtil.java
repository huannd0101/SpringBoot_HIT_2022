package com.hit.buoi6.utils;

import com.github.slugify.Slugify;
import com.hit.buoi6.dto.ProvinceDTO;
import com.hit.buoi6.model.Province;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ObjectUtil {
    @Autowired private static ModelMapper modelMapper;
    @Autowired private static Slugify slugify;

    public static Province convertProvince(Province province, ProvinceDTO provinceDTO) {
        Province newProvince;
        if(province == null) { //TH thêm
            newProvince = modelMapper.map(provinceDTO, Province.class);
        } else { //TH sửa
            newProvince = province;
            newProvince.setName(provinceDTO.getName());
            newProvince.setType(provinceDTO.getType());
        }

        newProvince.setSlug(slugify.slugify(newProvince.getName()));
        newProvince.setNameWithType(newProvince.getType() + " " + newProvince.getName());

        return newProvince;
    }
}
