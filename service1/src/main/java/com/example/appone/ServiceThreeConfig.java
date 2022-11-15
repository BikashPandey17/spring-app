package com.example.appone;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@ConstructorBinding
@ConfigurationProperties(prefix = "service-three")
public class ServiceThreeConfig {

    String uri;

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
