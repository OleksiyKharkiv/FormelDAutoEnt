package com.example.formeldautoent.controller;


import com.example.formeldautoent.entity.ExperimentalCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experimentalCars")
public class ExperimentalCarController {

    private final ExperimentalCarService experimentalCarService;

    @Autowired
    public ExperimentalCarController(ExperimentalCarService experimentalCarService) {
        this.experimentalCarService = experimentalCarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperimentalCar> getExperimentalCarById(@PathVariable Long id) {
        ExperimentalCar experimentalCar = experimentalCarService.getExperimentalCarById(id);
        return ResponseEntity.ok(experimentalCar);
    }

    @PostMapping
    public ResponseEntity<ExperimentalCar> createExperimentalCar(@RequestBody ExperimentalCar experimentalCar) {
        ExperimentalCar createdExperimentalCar = experimentalCarService.createExperimentalCar(experimentalCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExperimentalCar);
    }
}