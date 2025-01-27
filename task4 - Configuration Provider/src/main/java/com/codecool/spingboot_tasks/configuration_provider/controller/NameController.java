package com.codecool.spingboot_tasks.configuration_provider.controller;

import com.codecool.spingboot_tasks.configuration_provider.service.NameService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@Scope("${name_controller.scope:singleton}")
public class NameController {

    private final NameService nameService;

    @PostConstruct
    public void init(){
        System.out.println("NameService created");
    }

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("${name_controller.about:/about}")
    public String about(){
        return nameService.getName();
    }
}
