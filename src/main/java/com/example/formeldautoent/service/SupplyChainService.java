package com.example.formeldautoent.service;

import com.example.formeldautoent.entity.SupplyChain;

import java.util.List;

public interface SupplyChainService {
    SupplyChain getSupplyChainById(Long id);

    SupplyChain createSupplyChain(SupplyChain supplyChain);

    SupplyChain updateSupplyChain(Long id, SupplyChain supplyChain);

    void deleteSupplyChain(Long id);

    List<SupplyChain> getSupplyChainsByComponentId(Long componentId);

    List<SupplyChain> getSupplyChainsByProductionProcessId(Long productionProcessId);
}