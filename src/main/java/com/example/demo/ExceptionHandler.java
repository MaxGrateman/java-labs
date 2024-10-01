package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandler {
    @GetMapping("/throwException")
    public String throwException() {
        throw new Exception("Истекло время запроса");
    }
}
