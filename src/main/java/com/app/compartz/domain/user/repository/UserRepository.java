package com.app.compartz.domain.user.repository;

import com.app.compartz.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
