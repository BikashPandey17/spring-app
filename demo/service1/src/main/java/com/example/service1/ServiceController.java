package com.example.service1;

import com.example.service1.payload.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/service1")
public class ServiceController {

    @GetMapping
    public String getMethod() {
        /**
         * Returns "Up" if the service is up
         */
        return "Up";
    }

    @PostMapping
    public Map<String, String>  postMethod(@RequestBody Payload payload) {
        /**
         * Returns the concatenated response from service2 get and service3 post
         */
        //call to service3 post to receive a concatenated text
        //call to service1 get to wrap with hello
        return Map.of("test", "test");
    }

}
