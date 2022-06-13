package ru.mephi.taskboard.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mephi.taskboard.mappers.TaskColumnMapping;
import ru.mephi.taskboard.mappers.TaskMapping;
import ru.mephi.taskboard.models.Task;
import ru.mephi.taskboard.models.TaskColumn;
import ru.mephi.taskboard.service.TaskColumnService;
import ru.mephi.taskboard.service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/task-board/add-task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskColumnService taskColumnService;

    @PostMapping()
    public String addTask(@RequestParam(name = "titleTask") String titleTask ,
                          @RequestParam(name="description") String desc,
                          @RequestParam( name="numberOfColumn")Long numberOfColumn, Model model){


        Task task = new Task(titleTask,desc,
            taskColumnService.getTaskColumn(taskColumnService.getIdTaskColumnsByNumber((long)numberOfColumn)));
        task.setCrDate(LocalDate.now());
        taskService.saveTask(task);

        var  taskDtos = ((List<Task>)taskService.getTasks()).stream()
            .map(TaskMapping::mapToTaskDto).collect(Collectors.toList());
        var columnDtos = ((List<TaskColumn>)taskColumnService.getTaskColumns()).stream()
            .map(TaskColumnMapping::mapToTaskColumnDto).collect(Collectors.toList());


        model.addAttribute("Tasks", taskDtos);
        model.addAttribute("TaskColumns",columnDtos);
        return "taskBoard";
    }
}
