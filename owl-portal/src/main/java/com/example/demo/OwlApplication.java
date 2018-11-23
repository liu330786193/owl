package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class OwlApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cax =
                new SpringApplicationBuilder(OwlApplication.class).web(WebApplicationType.NONE).run(args);
        log.info(cax.getId() + "isActive: " + cax.isActive());

        /**
         * ConfigService
         */
        /*if (cax.getEnvironment().containsProperty("configService")){
            new SpringApplicationBuilder()
        }*/

    }
}
