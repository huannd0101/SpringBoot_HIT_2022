package com.hit.buoi5.repository;

import com.hit.buoi5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //search
    List<User> findAllByPasswordContaining(String key);

    @Query(value = "select * from Users where id < 2", nativeQuery = true)
    List<User> customQuery();

    User findByUsername(String username);


}
