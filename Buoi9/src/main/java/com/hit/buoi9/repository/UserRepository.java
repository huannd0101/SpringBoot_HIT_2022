package com.hit.buoi9.repository;

import com.hit.buoi9.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u where u.fullName like concat('%', ?1, '%')")
    List<User> findAllByFullNameContaining(String name);


}
