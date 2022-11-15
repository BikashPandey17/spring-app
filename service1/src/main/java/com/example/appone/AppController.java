package com.example.appone;

import com.example.appone.payload.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/service1")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public String getMethod() {
        /**
         * Returns "Up" if the service is up
         */
        return "Up";
    }

    @PostMapping
    public ResponseEntity postMethod(@Valid @RequestBody Name name, Errors errors) throws Exception {
        /**
         * Returns the concatenated response from service2 get and service3 post
         */
        //call to service3 post to receive a concatenated text
        //call to service2 get to wrap with hello
        ResponseEntity resp = appService.logic(name);
        return resp;
    }
}
