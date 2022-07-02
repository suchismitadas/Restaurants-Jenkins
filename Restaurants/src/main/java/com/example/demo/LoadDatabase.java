package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RestaurantRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Restaurant("Haldirams", "Jaipur", 4.5)));
            log.info("Preloading " + repository.save(new Restaurant("Subway", "New Delhi", 4)));
            log.info("Preloading " + repository.save(new Restaurant("KFC", "Bangalore", 4.3)));
            log.info("Preloading " + repository.save(new Restaurant("Taco Bell", "Bombay", 4.6)));
        };
    }
}

