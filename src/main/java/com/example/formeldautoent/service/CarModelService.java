package com.example.formeldautoent.service;

import com.example.formeldautoent.entity.CarModel;
import com.example.formeldautoent.entity.ExperimentalCar;

import java.util.List;

public interface CarModelService {
    CarModel getCarModelById(Long id);
    CarModel createCarModel(CarModel carModel);
    CarModel updateCarModel(Long id, CarModel carModel);
    void deleteCarModel(Long id);
    List<ExperimentalCar> getExperimentalCarsByCarModelId(Long carModelId);
    List<CarModel> getAllCarModels();
