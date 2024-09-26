package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "hello";
    }

    @PostMapping("/add")
    public String printNumber(@RequestParam("number") int number, Model model) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            numbers.add(i);
        }
        model.addAttribute("numbers", numbers);
        return "hello";
    }

    @GetMapping("/random")
    public String randomNumber(Model model) {
        Random random = new Random();
        int randomNum = random.nextInt(500) + 1;
        model.addAttribute("randomNum", randomNum);
        return "hello";
    }

    @PostMapping("/reverse")
    public String reverseNumber(@RequestParam("word") String word, Model model) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        model.addAttribute("reversedWord", reversedWord);
        return "hello";
    }

    @PostMapping("/fibonacci")
    public String fibonacci(@RequestParam("number") int number, Model model) {
        int result = calculateFibonacci(number);
        model.addAttribute("fibonacciResult", result);
        return "hello";
    }

    private int calculateFibonacci(int number) {
        if (number <= 1) {
            return number;
        }
        return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
    }
}
