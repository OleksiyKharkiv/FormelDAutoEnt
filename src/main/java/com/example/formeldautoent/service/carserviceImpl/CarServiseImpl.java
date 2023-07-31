package com.example.formeldautoent.service.carserviceImpl;

import com.example.formeldautoent.entity.CarModel;
import com.example.formeldautoent.entity.ExperimentalCar;
import com.example.formeldautoent.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelServiceImpl implements CarModelService {

    private final CarModelRepository carModelRepository;
    private final ExperimentalCarRepository experimentalCarRepository;

    @Autowired
    public CarModelServiceImpl(CarModelRepository carModelRepository, ExperimentalCarRepository experimentalCarRepository) {
        this.carModelRepository = carModelRepository;
        this.experimentalCarRepository = experimentalCarRepository;
    }

    @Override
    public CarModel getCarModelById(Long id) {
        Optional<CarModel> optionalCarModel = carModelRepository.findById(id);
        return optionalCarModel.orElse(null);
    }

    @Override
    public CarModel createCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public CarModel updateCarModel(Long id, CarModel carModel) {
        CarModel existingCarModel = getCarModelById(id);
        if (existingCarModel != null) {
            existingCarModel.setName(carModel.getName());
            existingCarModel.setDescription(carModel.getDescription());
            existingCarModel.setTechnicalParameters(carModel.getTechnicalParameters());
            return carModelRepository.save(existingCarModel);
        }
        return null;
    }

    @Override
    public void deleteCarModel(Long id) {
        carModelRepository.deleteById(id);
    }

    @Override
    public List<ExperimentalCar> getExperimentalCarsByCarModelId(Long carModelId) {
        return experimentalCarRepository.findByCarModelId(carModelId);
    }

    @Override
    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }
}