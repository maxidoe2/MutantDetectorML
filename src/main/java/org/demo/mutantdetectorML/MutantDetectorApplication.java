package org.demo.mutantdetectorML;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantDetectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutantDetectorApplication.class, args);

        System.out.println("RUNNING");
    }

}
