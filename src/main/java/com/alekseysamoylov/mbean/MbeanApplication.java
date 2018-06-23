package com.alekseysamoylov.mbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MbeanApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MbeanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (MbeanService.waitMbeanMethodInvoke) {}
    }
}
