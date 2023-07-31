package com.example.formeldautoent.service.serviceImpl;

import com.example.formeldautoent.entity.Component;
import com.example.formeldautoent.repository.ComponentRepository;
import com.example.formeldautoent.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public Component getComponentById(Long id) {
        Optional<Component> optionalComponent = componentRepository.findById(id);
        return optionalComponent.orElse(null);
    }

    @Override
    public Component createComponent(Component component) {
        return componentRepository.save(component);
    }

    @Override
    public Component updateComponent(Long id, Component component) {
        Component existingComponent = getComponentById(id);
        if (existingComponent != null) {
            existingComponent.setName(component.getName());
            existingComponent.setDescription(component.getDescription());
            existingComponent.setProductionStatus(component.getProductionStatus());
            return componentRepository.save(existingComponent);
        }
        return null;
    }

    @Override
    public void deleteComponent(Long id) {
        componentRepository.deleteById(id);
    }
}