package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
 
@Configuration
public class SwaggerConfig {
 
    @Bean //Create and manage the object returned by this method.
    public OpenAPI assessmentTrackerAPI() {
 
        return new OpenAPI()
                .info(new Info()
                        .title("Assessment Tracker API")
                        .description("Spring Boot REST API for Assessment Tracker System")
                        .version("1.0"));
    }
 
}

//fixed url used for ruuning like postman
//http://localhost:<port>/swagger-ui/index.html

