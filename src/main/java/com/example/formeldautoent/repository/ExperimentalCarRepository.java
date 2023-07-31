package com.example.formeldautoent.repository;

import com.example.formeldautoent.entity.ExperimentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperimentalCarRepository extends JpaRepository<ExperimentalCar, Long> {
    List<ExperimentalCar> findByCarModelId(Long carModelId);
}