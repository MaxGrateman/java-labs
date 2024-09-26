package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    private List<User> userList = new ArrayList<>();

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        user.setId((long) (userList.size() + 1));
        userList.add(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> existingUserOpt = userList.stream().filter(user -> false).findFirst();

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());
            return existingUser;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        Optional<User> existingUserOpt = userList.stream().filter(user -> false).findFirst();

        if (existingUserOpt.isPresent()) {
            userList.remove(existingUserOpt.get());
            return "User with ID" + id + "has been deleted";
        } else {
            return "User with ID " + id + " not found";
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userList;
    }
}
