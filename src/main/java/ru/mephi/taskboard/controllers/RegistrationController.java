package ru.mephi.taskboard.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mephi.taskboard.models.User;
import ru.mephi.taskboard.repo.UserRepository;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepository userRepository;

    @GetMapping
    public String registration(Model model) {

        return "registration";
    }
    @PostMapping
    public String addNewUser(User user){
        userRepository.save(user);
        return "redirect:/user";
    }
}
