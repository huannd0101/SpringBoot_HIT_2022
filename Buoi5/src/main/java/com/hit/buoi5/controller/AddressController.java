package com.hit.buoi5.controller;

import com.hit.buoi5.dto.AddressDTO;
import com.hit.buoi5.exception.NotFoundException;
import com.hit.buoi5.model.Address;
import com.hit.buoi5.model.User;
import com.hit.buoi5.repository.AddressRepository;
import com.hit.buoi5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllAddress() {
        return ResponseEntity.status(200).body(addressRepository.findAll());
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<?> getAllAddressByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(200).body(
                addressRepository.findAllByUser_Id(userId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable("id") Long id) {
        return ResponseEntity.status(200).body(
                addressRepository.findById(id).get()
        );
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> createNewAddress(
            @PathVariable("userId") Long id,
            @RequestBody AddressDTO addressDTO
    ) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new NotFoundException("Không tìm thấy user id: " + id);
        }

        Address address = new Address();
        address.setVal(addressDTO.getVal());
        address.setUser(optionalUser.get());

        addressRepository.save(address);

        return ResponseEntity.status(201).body(addressRepository.save(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()) {
            throw new NotFoundException("Không tìm thấy address id: " + id);
        }

        //xóa
        addressRepository.deleteById(id);

        return ResponseEntity.status(200).build();
    }

}
