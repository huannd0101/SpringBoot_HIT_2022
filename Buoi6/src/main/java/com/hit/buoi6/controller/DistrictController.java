package com.hit.buoi6.controller;

import com.github.slugify.Slugify;
import com.hit.buoi6.base.RestApiV1;
import com.hit.buoi6.base.UrlConstant;
import com.hit.buoi6.dto.DistrictDTO;
import com.hit.buoi6.exception.DuplicateException;
import com.hit.buoi6.exception.NotFoundException;
import com.hit.buoi6.model.District;
import com.hit.buoi6.model.Province;
import com.hit.buoi6.repository.DistrictRepository;
import com.hit.buoi6.repository.ProvinceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestApiV1
public class DistrictController {
    @Autowired private DistrictRepository districtRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private Slugify slugify;

    @GetMapping(UrlConstant.District.DISTRICTS)
    public ResponseEntity<?> getAllDistrict() {
        return ResponseEntity.status(200).body(districtRepository.findAll());
    }

    @PostMapping(UrlConstant.District.DISTRICTS)
    public ResponseEntity<?> createNewDistrict(@RequestBody DistrictDTO districtDTO) {
        if(checkDistrictExists(districtDTO.getCode())) {
            throw new DuplicateException("Duplicate district by code: " + districtDTO.getCode());
        }
        Province province = getProvinceByCode(districtDTO.getParentCode());

        District district = modelMapper.map(districtDTO, District.class);
        district.setSlug(slugify.slugify(district.getName()));
        district.setNameWithType(district.getType() + " " + district.getName());
        district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());

        return ResponseEntity.status(201).body(districtRepository.save(district));
    }

    @GetMapping(UrlConstant.District.DISTRICT_WITH_CODE)
    public ResponseEntity<?> getAllDistrict(@PathVariable("code") Long code) {
        return ResponseEntity.status(200).body(getDistrictByCode(code));
    }

    @PatchMapping(UrlConstant.District.DISTRICT_WITH_CODE)
    public ResponseEntity<?> editDistrictByCode(@PathVariable("code") Long code,
                                                @RequestBody DistrictDTO districtDTO) {
        District district = getDistrictByCode(code);
        Province province = getProvinceByCode(districtDTO.getParentCode());

        district.setName(districtDTO.getName());
        district.setSlug(slugify.slugify(district.getName()));
        district.setNameWithType(district.getType() + " " + district.getName());
        district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());
        district.setParentCode(districtDTO.getParentCode());

        return ResponseEntity.status(201).body(districtRepository.save(district));
    }

    @DeleteMapping(UrlConstant.District.DISTRICT_WITH_CODE)
    public ResponseEntity<?> deleteDistrictByCode(@PathVariable("code") Long code) {
        District district = getDistrictByCode(code);

        districtRepository.delete(district);

        return ResponseEntity.status(200).body(district);
    }

    @PostMapping(UrlConstant.District.COLLECTION)
    public ResponseEntity<?> addCollection(@RequestBody List<DistrictDTO> districtDTOS) {
        List<District> districts = new ArrayList<>();
        districtDTOS.forEach(item -> {
            if(checkDistrictExists(item.getCode())) {
                throw new DuplicateException("Duplicate district by code: " + item.getCode());
            }
            Province province = getProvinceByCode(item.getParentCode());

            District district = modelMapper.map(item, District.class);
            district.setSlug(slugify.slugify(district.getName()));
            district.setNameWithType(district.getType() + " " + district.getName());
            district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());
            district.setProvince(province);

            districts.add(districtRepository.save(district));
        });

        return ResponseEntity.status(201).body(districts);
    }


    private District getDistrictByCode(Long code) {
        Optional<District> optional = districtRepository.findById(code);
        if (optional.isEmpty()) {
            throw new NotFoundException("Can not find district by code: " + code);
        }
        return optional.get();
    }

    private Boolean checkDistrictExists(Long code) {
        Optional<District> optional = districtRepository.findById(code);
        return optional.isPresent();
    }

    private Province getProvinceByCode(Long code) {
        Optional<Province> optional = provinceRepository.findById(code);
        if (optional.isEmpty()) {
            throw new NotFoundException("Can not find province by code: " + code);
        }
        return optional.get();
    }
}
