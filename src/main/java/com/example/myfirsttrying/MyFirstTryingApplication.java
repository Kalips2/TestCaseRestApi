package com.example.myfirsttrying;

import org.hibernate.HibernateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class MyFirstTryingApplication {

    public static void main(String[] args) throws HibernateException {
        SpringApplication.run(MyFirstTryingApplication.class, args);
    }

}
