package com.mathsena.timetodo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeTodoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(TimeTodoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {}
}
