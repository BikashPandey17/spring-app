package com.example.apptwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/service2")
public class AppController {

    private static Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * Returns the "Hello" concatenated with requested string
     */
    @GetMapping(path="{name}")
    public ResponseEntity getMethod(@PathVariable String name) {
        logger.info("Service 2 get request: " + name);
        return new ResponseEntity("Hello " +  name, HttpStatus.OK);
    }
}
