package com.example.formeldautoent.controller;

import com.example.formeldautoent.entity.CarModel;
import com.example.formeldautoent.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carModels")
public class CarModelController {

    private final CarModelService carModelService;

    @Autowired
    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModel> getCarModelById(@PathVariable Long id) {
        CarModel carModel = carModelService.getCarModelById(id);
        return ResponseEntity.ok(carModel);
    }

    @PostMapping
    public ResponseEntity<CarModel> createCarModel(@RequestBody CarModel carModel) {
        CarModel createdCarModel = carModelService.createCarModel(carModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarModel);
    }
}
