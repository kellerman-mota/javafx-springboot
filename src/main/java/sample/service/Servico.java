package sample.service;

import org.springframework.stereotype.Service;

@Service
public class Servico {
    public String getHelloWorld() {
        return "Hello World with Spring Boot!";
    }
}
