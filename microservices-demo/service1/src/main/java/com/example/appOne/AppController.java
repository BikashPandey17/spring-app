package com.example.appOne;

import com.example.appOne.payload.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, String>  postMethod(@RequestBody Name name) {
        /**
         * Returns the concatenated response from service2 get and service3 post
         */
        //call to service3 post to receive a concatenated text
        //call to service2 get to wrap with hello
        String resp = appService.logic(name);
        return Map.of("response", resp);
    }
}
