package com.app.compartz.domain.user.repository;

import com.app.compartz.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail);

    boolean existsByMail(String mail);


}
