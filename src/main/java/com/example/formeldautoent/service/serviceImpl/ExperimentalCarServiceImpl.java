package com.example.formeldautoent.service.serviceImpl;

import com.example.formeldautoent.entity.ExperimentalCar;
import com.example.formeldautoent.repository.ExperimentalCarRepository;
import com.example.formeldautoent.service.ExperimentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperimentalCarServiceImpl implements ExperimentalCarService {

    private final ExperimentalCarRepository experimentalCarRepository;

    @Autowired
    public ExperimentalCarServiceImpl(ExperimentalCarRepository experimentalCarRepository) {
        this.experimentalCarRepository = experimentalCarRepository;
    }

    @Override
    public ExperimentalCar getExperimentalCarById(Long id) {
        Optional<ExperimentalCar> optionalExperimentalCar = experimentalCarRepository.findById(id);
        return optionalExperimentalCar.orElse(null);
    }

    @Override
    public ExperimentalCar createExperimentalCar(ExperimentalCar experimentalCar) {
        return experimentalCarRepository.save(experimentalCar);
    }

    @Override
    public ExperimentalCar updateExperimentalCar(Long id, ExperimentalCar experimentalCar) {
        ExperimentalCar existingExperimentalCar = getExperimentalCarById(id);
        if (existingExperimentalCar != null) {
            existingExperimentalCar.setTestParameters(experimentalCar.getTestParameters());
            existingExperimentalCar.setTestResults(experimentalCar.getTestResults());
            return experimentalCarRepository.save(existingExperimentalCar);
        }
        return null;
    }

    @Override
    public void deleteExperimentalCar(Long id) {
        experimentalCarRepository.deleteById(id);
    }
}