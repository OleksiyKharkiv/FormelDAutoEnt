package com.example.formeldautoent.service.serviceImpl;

import com.example.formeldautoent.entity.ProductionProcess;
import com.example.formeldautoent.repository.ProductionProcessRepository;
import com.example.formeldautoent.service.ProductionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductionProcessServiceImpl implements ProductionProcessService {

    private final ProductionProcessRepository productionProcessRepository;

    @Autowired
    public ProductionProcessServiceImpl(ProductionProcessRepository productionProcessRepository) {
        this.productionProcessRepository = productionProcessRepository;
    }

    @Override
    public ProductionProcess getProductionProcessById(Long id) {
        Optional<ProductionProcess> optionalProductionProcess = productionProcessRepository.findById(id);
        return optionalProductionProcess.orElse(null);
    }

    @Override
    public ProductionProcess createProductionProcess(ProductionProcess productionProcess) {
        return productionProcessRepository.save(productionProcess);
    }

    @Override
    public ProductionProcess updateProductionProcess(Long id, ProductionProcess productionProcess) {
        ProductionProcess existingProductionProcess = getProductionProcessById(id);
        if (existingProductionProcess != null) {
            existingProductionProcess.setName(productionProcess.getName());
            existingProductionProcess.setDescription(productionProcess.getDescription());
            existingProductionProcess.setProductionStatus(productionProcess.getProductionStatus());
            return productionProcessRepository.save(existingProductionProcess);
        }
        return null;
    }

    @Override
    public void deleteProductionProcess(Long id) {
        productionProcessRepository.deleteById(id);
    }
}