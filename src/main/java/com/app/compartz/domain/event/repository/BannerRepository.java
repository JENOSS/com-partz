package com.app.compartz.domain.event.repository;

import com.app.compartz.domain.event.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long> {
}
