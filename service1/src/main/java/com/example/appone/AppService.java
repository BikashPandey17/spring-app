package com.example.appone;

import com.example.appone.payload.Name;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Validated
@Service
public class AppService {
    private final RestTemplate restTemplate;
    private final ServiceTwoConfig serviceTwoConfig;
    private final ServiceThreeConfig serviceThreeConfig;

    private static Logger logger = LoggerFactory.getLogger(AppService.class);

    @Autowired
    public AppService(RestTemplate restTemplate, ServiceTwoConfig serviceTwoConfig, ServiceThreeConfig serviceThreeConfig) {
        this.restTemplate = restTemplate;
        this.serviceTwoConfig = serviceTwoConfig;
        this.serviceThreeConfig = serviceThreeConfig;
    }

    public ResponseEntity logic(Name name) throws Exception {
        logger.info("Service 1 post request: " + name.getFirstName() + " " + name.getLastName());
        try {
            String serviceThreeResp = restTemplate.postForObject(
                    serviceThreeConfig.getUri(),
                    name,
                    String.class
            );
            String resp = restTemplate.getForObject(
                    serviceTwoConfig.getUri() + "/{name}",
                    String.class,
                    serviceThreeResp
            );
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (HttpClientErrorException  | HttpServerErrorException httpClientOrServerExc) {
            return new ResponseEntity(httpClientOrServerExc.getMessage(), httpClientOrServerExc.getStatusCode());
        } //TODO catch java.net.ConnectException, and appropriate response
    }
}
