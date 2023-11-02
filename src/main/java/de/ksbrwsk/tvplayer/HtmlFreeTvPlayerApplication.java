package de.ksbrwsk.tvplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HtmlFreeTvPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtmlFreeTvPlayerApplication.class, args);
    }

}
