package ru.mephi.taskboard.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mephi.taskboard.mappers.TaskColumnMapping;
import ru.mephi.taskboard.mappers.TaskMapping;
import ru.mephi.taskboard.models.Task;
import ru.mephi.taskboard.models.TaskColumn;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping
    public String taskBoard(Model model) {

        return "user";
    }
}
