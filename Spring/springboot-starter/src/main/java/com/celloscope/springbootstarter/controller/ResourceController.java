package com.celloscope.springbootstarter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ResourceController {

    @GetMapping()
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello from Spring", HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> sayName(@PathVariable("name") String name) {
        return new ResponseEntity<>("Hello Celloscope from " + name, HttpStatus.OK);
    }


}