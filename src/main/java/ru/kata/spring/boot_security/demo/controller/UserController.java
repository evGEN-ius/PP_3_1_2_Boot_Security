package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import java.security.Principal;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String HelloUser(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute(user);
        return "user";
    }

}
