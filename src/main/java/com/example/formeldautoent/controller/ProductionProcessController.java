package com.example.formeldautoent.controller;

import com.example.formeldautoent.entity.ProductionProcess;
import com.example.formeldautoent.service.ProductionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productionProcesses")
public class ProductionProcessController {

    private final ProductionProcessService productionProcessService;

    @Autowired
    public ProductionProcessController(ProductionProcessService productionProcessService) {
        this.productionProcessService = productionProcessService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionProcess> getProductionProcessById(@PathVariable Long id) {
        ProductionProcess productionProcess = productionProcessService.getProductionProcessById(id);
        return ResponseEntity.ok(productionProcess);
    }

    @PostMapping
    public ResponseEntity<ProductionProcess> createProductionProcess(@RequestBody ProductionProcess productionProcess) {
        ProductionProcess createdProductionProcess = productionProcessService.createProductionProcess(productionProcess);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductionProcess);
    }
}