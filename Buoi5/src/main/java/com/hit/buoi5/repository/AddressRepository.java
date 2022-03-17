package com.hit.buoi5.repository;

import com.hit.buoi5.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUser_Id(Long useId);
}
