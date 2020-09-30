package com.practice.propertiesdemo.controller;

import com.practice.propertiesdemo.properties.PracticeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PropertyController {

    @Autowired
    private PracticeProperties properties;

    @GetMapping
    public PracticeProperties getProperties() {
        return this.properties;
    }
}
