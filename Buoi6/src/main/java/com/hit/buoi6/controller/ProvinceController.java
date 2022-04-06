package com.hit.buoi6.controller;

import com.github.slugify.Slugify;
import com.hit.buoi6.base.RestApiV1;
import com.hit.buoi6.base.UrlConstant;
import com.hit.buoi6.dto.ProvinceDTO;
import com.hit.buoi6.exception.DuplicateException;
import com.hit.buoi6.exception.NotFoundException;
import com.hit.buoi6.model.Province;
import com.hit.buoi6.repository.ProvinceRepository;
import com.hit.buoi6.utils.ObjectUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestApiV1
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    //Lấy tất cả
    @GetMapping(UrlConstant.Province.PROVINCES)
    public ResponseEntity<?> getAllProvinces() {
        return ResponseEntity.status(200).body(provinceRepository.findAll());
    }

    //Thêm
    @PostMapping(UrlConstant.Province.PROVINCES)
    public ResponseEntity<?> createNewProvince(@RequestBody ProvinceDTO provinceDTO) {
        if (checkProvinceExists(provinceDTO.getCode())) {
            throw new DuplicateException("Duplicate province with code: " + provinceDTO.getCode());
        }

        Province province = provinceRepository.save(ObjectUtil.convertProvince(null, provinceDTO));

        return ResponseEntity.status(201).body(province);
    }

    // lấy theo code
    @GetMapping(UrlConstant.Province.PROVINCE_WITH_CODE)
    public ResponseEntity<?> getProvince(@PathVariable("code") Long code) {
        return ResponseEntity.status(200).body(getProvinceByCode(code));
    }

    @PatchMapping(UrlConstant.Province.PROVINCE_WITH_CODE)
    public ResponseEntity<?> editProvinceByCode(@PathVariable("code") Long code,
                                                @RequestBody ProvinceDTO provinceDTO) {
        Province province = getProvinceByCode(code);

        province = ObjectUtil.convertProvince(province, provinceDTO);

        return ResponseEntity.status(201).body(provinceRepository.save(province));
    }

    @DeleteMapping(UrlConstant.Province.PROVINCE_WITH_CODE)
    public ResponseEntity<?> deleteProvinceByCode(@PathVariable("code") Long code) {
        Province province = getProvinceByCode(code);

        provinceRepository.delete(province);

        return ResponseEntity.status(200).body(province);
    }

    // lấy district
    @GetMapping(UrlConstant.Province.DISTRICT_WITH_CODE_PROVINCE)
    public ResponseEntity<?> getDistrictsByProvinceCode(@PathVariable("code") Long code) {
        return ResponseEntity.status(200).body(getProvinceByCode(code).getDistricts());
    }

    @PostMapping(UrlConstant.Province.COLLECTION)
    @Transactional
    public ResponseEntity<?> addCollection(@RequestBody List<ProvinceDTO> provinceDTOS) {
        List<Province> provinces = new ArrayList<>();
//        for(ProvinceDTO item : provinceDTOS)
        provinceDTOS.forEach(item -> {
            if(checkProvinceExists(item.getCode())) {
                throw new DuplicateException("Duplicate province with code: " + item.getCode());
            }
            Province province = ObjectUtil.convertProvince(null, item);

            Province newProvince = provinceRepository.save(province);

            provinces.add(newProvince);
        });

        return ResponseEntity.status(201).body(provinces);
    }

    private Province getProvinceByCode(Long code) {
        Optional<Province> optional = provinceRepository.findById(code);
        if (optional.isEmpty()) {
            throw new NotFoundException("Can not find province by code: " + code);
        }
        return optional.get();
    }

    private Boolean checkProvinceExists(Long code) {
        Optional<Province> optional = provinceRepository.findById(code);
        return optional.isPresent();
    }
}
