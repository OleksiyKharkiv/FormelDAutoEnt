package com.example.formeldautoent.service;

import com.example.formeldautoent.entity.Component;

public interface ComponentService {

    Component getComponentById(Long id);

    Component createComponent(Component component);

    Component updateComponent(Long id, Component component);

    void deleteComponent(Long id);
}