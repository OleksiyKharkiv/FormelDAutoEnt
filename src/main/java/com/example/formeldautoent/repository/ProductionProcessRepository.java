package com.example.formeldautoent.repository;

import com.example.formeldautoent.entity.ProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionProcessRepository extends JpaRepository<ProductionProcess, Long> {
}