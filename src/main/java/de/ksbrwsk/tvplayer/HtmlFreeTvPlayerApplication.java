package de.ksbrwsk.tvplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The HtmlFreeTvPlayerApplication class is the entry point of the Spring Boot application.
 * It is annotated with @SpringBootApplication which is a convenience annotation that adds all of the following:
 * @Configuration: Tags the class as a source of bean definitions for the application context.
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
 * @ComponentScan: Tells Spring to look for other components, configurations, and services in the 'de.ksbrwsk.tvplayer' package.
 * The class is also annotated with @EnableScheduling to enable Spring's scheduled task execution capability.
 */
@SpringBootApplication
@EnableScheduling
public class HtmlFreeTvPlayerApplication {

    /**
     * The main method uses Spring Boot’s SpringApplication.run() method to launch an application.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(HtmlFreeTvPlayerApplication.class, args);
    }

}