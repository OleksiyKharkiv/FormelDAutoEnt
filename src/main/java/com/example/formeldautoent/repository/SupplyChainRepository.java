package com.example.formeldautoent.repository;

import com.example.formeldautoent.entity.SupplyChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyChainRepository extends JpaRepository<SupplyChain, Long> {
    List<SupplyChain> findByComponentId(Long componentId);

    List<SupplyChain> findByProductionProcessId(Long productionProcessId);
}