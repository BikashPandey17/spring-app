package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/service4")
public class AppController {

    private static Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * Returns the concatenated response for firsName and lastName
     * will throw if bad request
     */
}
