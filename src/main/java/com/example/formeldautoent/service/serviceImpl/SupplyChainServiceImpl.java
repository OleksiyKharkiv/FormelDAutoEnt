package com.example.formeldautoent.service.serviceImpl;

import com.example.formeldautoent.entity.SupplyChain;
import com.example.formeldautoent.repository.SupplyChainRepository;
import com.example.formeldautoent.service.SupplyChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyChainServiceImpl implements SupplyChainService {

    private final SupplyChainRepository supplyChainRepository;

    @Autowired
    public SupplyChainServiceImpl(SupplyChainRepository supplyChainRepository) {
        this.supplyChainRepository = supplyChainRepository;
    }

    @Override
    public SupplyChain getSupplyChainById(Long id) {
        Optional<SupplyChain> optionalSupplyChain = supplyChainRepository.findById(id);
        return optionalSupplyChain.orElse(null);
    }

    @Override
    public SupplyChain createSupplyChain(SupplyChain supplyChain) {
        return supplyChainRepository.save(supplyChain);
    }

    @Override
    public SupplyChain updateSupplyChain(Long id, SupplyChain supplyChain) {
        SupplyChain existingSupplyChain = getSupplyChainById(id);
        if (existingSupplyChain != null) {
            existingSupplyChain.setComponent(supplyChain.getComponent());
            existingSupplyChain.setProductionProcess(supplyChain.getProductionProcess());
            existingSupplyChain.setSupplier(supplyChain.getSupplier());
            return supplyChainRepository.save(existingSupplyChain);
        }
        return null;
    }

    @Override
    public void deleteSupplyChain(Long id) {
        supplyChainRepository.deleteById(id);
    }

    @Override
    public List<SupplyChain> getSupplyChainsByComponentId(Long componentId) {
        return supplyChainRepository.findByComponentId(componentId);
    }

    @Override
    public List<SupplyChain> getSupplyChainsByProductionProcessId(Long productionProcessId) {
        return supplyChainRepository.findByProductionProcessId(productionProcessId);
    }
}