package com.example.pksiv.resourceserver.persistence;

import com.example.pksiv.resourceserver.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
