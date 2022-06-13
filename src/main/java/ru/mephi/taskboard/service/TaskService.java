package ru.mephi.taskboard.service;

import org.springframework.stereotype.Service;
import ru.mephi.taskboard.models.Task;
import ru.mephi.taskboard.models.TaskColumn;
import ru.mephi.taskboard.repo.TaskRepository;
import ru.mephi.taskboard.repo.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Task saveTask(Task taskColumn) {
        return taskRepository.save(taskColumn);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


}
