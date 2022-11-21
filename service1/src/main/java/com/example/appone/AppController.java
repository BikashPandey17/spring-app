package com.example.appone;

import com.example.appone.payload.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.net.ConnectException;
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

    /**
     * Returns "Up" if the service is up
     */
    @GetMapping
    public String getMethod() {
        return "Up";
    }

    /**
     * Returns the concatenated response from service2 get and service3 post
     */
    @PostMapping
    public ResponseEntity<String> postMethod(@Valid @RequestBody Name name, Errors errors) throws Exception, ConnectException {
        return appService.logic(name);
    }
}
