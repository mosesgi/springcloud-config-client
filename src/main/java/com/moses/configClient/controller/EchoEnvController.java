package com.moses.configClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoEnvController {
    private final Environment environment;

    @Autowired
    public EchoEnvController(Environment environment){
        this.environment = environment;
    }

    //http://localhost:9090/echo/env/server.port/
    @GetMapping("/echo/env/{name}")
    public String environment(@PathVariable String name){
        return environment.getProperty(name);
    }
}
