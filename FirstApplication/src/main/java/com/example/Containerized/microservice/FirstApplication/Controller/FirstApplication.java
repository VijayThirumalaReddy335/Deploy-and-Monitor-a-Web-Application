package com.example.Containerized.microservice.FirstApplication.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Containerized.microservice.FirstApplication.dto.Messagedto;

@RestController
public class FirstApplication {

    @GetMapping("/hello")
    public Messagedto getHelloMessage() {
        return new Messagedto("1", "Hello world");
    }
}
