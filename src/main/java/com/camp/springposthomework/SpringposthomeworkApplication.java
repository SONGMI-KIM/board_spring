package com.camp.springposthomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringposthomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringposthomeworkApplication.class, args);
    }

}
