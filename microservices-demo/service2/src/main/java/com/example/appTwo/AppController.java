package com.example.appTwo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/service2")
public class AppController {

    @GetMapping(path="{name}")
    public String getMethod(@PathVariable String name) {
        /**
         * Returns "Up" if the service is up
         */
        return "Hello " +  name;
    }
}
