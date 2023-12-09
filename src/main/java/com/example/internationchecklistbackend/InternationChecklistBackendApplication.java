package com.example.internationchecklistbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com.example.internationchecklistbackend.repositories"})
public class InternationChecklistBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternationChecklistBackendApplication.class, args);
    }

}
