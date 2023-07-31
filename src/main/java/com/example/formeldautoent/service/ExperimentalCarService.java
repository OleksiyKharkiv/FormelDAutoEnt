package com.example.formeldautoent.service;

import com.example.formeldautoent.entity.ExperimentalCar;

public interface ExperimentalCarService {
    ExperimentalCar getExperimentalCarById(Long id);

    ExperimentalCar createExperimentalCar(ExperimentalCar experimentalCar);

    ExperimentalCar updateExperimentalCar(Long id, ExperimentalCar experimentalCar);

    void deleteExperimentalCar(Long id);
}