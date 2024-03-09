package com.app.compartz.domain.product.repository;

import com.app.compartz.domain.product.model.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaffleRepository extends JpaRepository<Raffle, Long> {
    Optional<Raffle> findFirstByOrderByCreatedDatetimeDesc();
}
