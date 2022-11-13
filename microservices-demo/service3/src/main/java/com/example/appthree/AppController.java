package com.example.appthree;

import com.example.appthree.payload.Name;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("api/v1/service3")
public class AppController {

    private static Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * Returns the concatenated response for firsName and lastName
     * will throw if bad request
     */
    @PostMapping
    public String postMethod(@Valid @RequestBody Name name, Errors errors) throws Exception {
        logger.info("Service 3 post request: " + name.getFirstName() + " " + name.getLastName());
        if (errors.hasErrors()) {
            // Extract ConstraintViolation list from body errors
            List<ConstraintViolation<?>> violationsList = new ArrayList<>();
            for (ObjectError e : errors.getAllErrors()) {
                violationsList.add(e.unwrap(ConstraintViolation.class));
            }

            String exceptionMessage = "";

            // Construct a helpful message for each input violation
            for (ConstraintViolation<?> violation : violationsList) {
                exceptionMessage += violation.getPropertyPath() + " " + violation.getMessage() + "\n";
            }
            throw new Exception(String.format("Request input is invalid:\n%s", exceptionMessage));
        }
        return name.getFirstName() + " " + name.getLastName();
    }
}
