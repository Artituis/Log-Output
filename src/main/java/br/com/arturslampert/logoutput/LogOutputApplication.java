package br.com.arturslampert.logoutput;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class LogOutputApplication {

    private String randomString;

    public static void main(String[] args) {
        SpringApplication.run(LogOutputApplication.class, args);
    }

    @PostConstruct
    public void generateRandomString() {
        randomString = UUID.randomUUID().toString();
    }

    @Scheduled(fixedRate = 5000)
    public void printRandomString() {
        System.out.println(Instant.now() + ": " + randomString);
    }
}
