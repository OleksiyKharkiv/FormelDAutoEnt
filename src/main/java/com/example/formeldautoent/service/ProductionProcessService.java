package com.example.formeldautoent.service;

import com.example.formeldautoent.entity.ProductionProcess;

public interface ProductionProcessService {
    ProductionProcess getProductionProcessById(Long id);

    ProductionProcess createProductionProcess(ProductionProcess productionProcess);

    ProductionProcess updateProductionProcess(Long id, ProductionProcess productionProcess);

    void deleteProductionProcess(Long id);
}