package com.example.appOne;

import com.example.appOne.payload.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AppService {
    private final RestTemplate restTemplate;
    private final AppConfig appConfig;

    @Autowired
    public AppService(RestTemplate restTemplate, AppConfig appConfig) {
        this.restTemplate = restTemplate;
        this.appConfig = appConfig;
    }

    public String logic(Name name) {
        String resp = restTemplate.getForObject(
                appConfig.getUri() + "/{name}",
                String.class,
                name.getFirstName() + " " + name.getLastName()
        );
        return resp;
    }
}
