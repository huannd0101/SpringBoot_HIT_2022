package com.example.buoi11.repositories;

import com.example.buoi11.daos.Role;
import com.example.buoi11.daos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByNameRole(String name);
}
