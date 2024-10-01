package com.example.demo;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;

public class User {
    private Long id;

    @NotEmpty(message = "Имя не может быть пустым")
    private String name;

    @Min(value = 18, message = "Возраст должен быть больше 18 лет")
    private int age;

    User() {}

    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
