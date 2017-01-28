package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by Jayne on 1/27/2017.
 */
// @SpringBootApplication is a convenience annotation that adds all of the following
        // @Configuration : tags the class as a source of bean definitions for the application context
        // @EnableAutoConfiguration tells SpringBoot to start adding beans based on classpath settings, other beans and various property settings
        // @ComponentScan tells Spring to look for other components, configurations and services in the package allowing it to find the controllers
@SpringBootApplication
public class Application {
    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }

}
