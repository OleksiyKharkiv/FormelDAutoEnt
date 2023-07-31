package com.example.formeldautoent.controller;

import com.example.formeldautoent.entity.SupplyChain;
import com.example.formeldautoent.service.SupplyChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplyChains")
public class SupplyChainController {

    private final SupplyChainService supplyChainService;

    @Autowired
    public SupplyChainController(SupplyChainService supplyChainService) {
        this.supplyChainService = supplyChainService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyChain> getSupplyChainById(@PathVariable Long id) {
        SupplyChain supplyChain = supplyChainService.getSupplyChainById(id);
        if (supplyChain != null) {
            return ResponseEntity.ok(supplyChain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SupplyChain> createSupplyChain(@RequestBody SupplyChain supplyChain) {
        SupplyChain createdSupplyChain = supplyChainService.createSupplyChain(supplyChain);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplyChain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplyChain> updateSupplyChain(@PathVariable Long id, @RequestBody SupplyChain supplyChain) {
        SupplyChain updatedSupplyChain = supplyChainService.updateSupplyChain(id, supplyChain);
        if (updatedSupplyChain != null) {
            return ResponseEntity.ok(updatedSupplyChain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplyChain(@PathVariable Long id) {
        supplyChainService.deleteSupplyChain(id);
        return ResponseEntity.noContent().build();
    }
}