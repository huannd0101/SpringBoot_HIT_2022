package com.hit.buoi4_2.repository;

import com.hit.buoi4_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //đánh dấu cho spring biết đây là tầng thao tác vs CSDL -tạo bean
public interface UserRepository extends JpaRepository<User, Long> {
}
