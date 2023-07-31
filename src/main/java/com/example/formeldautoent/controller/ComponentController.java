package com.example.formeldautoent.controller;

import com.example.formeldautoent.entity.Component;
import com.example.formeldautoent.service.serviceImpl.ComponentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/components")
public class ComponentController {

    private final ComponentServiceImpl componentService;

    @Autowired
    public ComponentController(ComponentServiceImpl componentService) {
        this.componentService = componentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Component> getComponentById(@PathVariable Long id) {
        Component component = componentService.getComponentById(id);
        return ResponseEntity.ok(component);
    }

    @PostMapping
    public ResponseEntity<Component> createComponent(@RequestBody Component component) {
        Component createdComponent = componentService.createComponent(component);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComponent);
    }
}