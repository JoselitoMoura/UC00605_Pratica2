package pt.uc00605.pratica2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {

    @GetMapping("/")

    public String hello() {
        return "Olá formador";
    }
    
    @GetMapping("/paula")
    public String paula() {
        return "Olá Paula";
    }

    @GetMapping("/moura")
    public String moura() {
        return "Olá Moura";
    }

}
