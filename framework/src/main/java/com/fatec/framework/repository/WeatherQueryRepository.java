package com.fatec.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherQueryRepository extends JpaRepository<WeatherQueryEntity, Long> {
}
