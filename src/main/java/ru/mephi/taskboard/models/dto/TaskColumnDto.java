package ru.mephi.taskboard.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mephi.taskboard.models.Task;

import javax.persistence.*;
import java.util.List;

@Data
public class TaskColumnDto {
    private Long id;
    private String name;
    private Integer numberTasks;
   // private List<Task> tasks;

}
