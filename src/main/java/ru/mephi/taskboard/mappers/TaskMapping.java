package ru.mephi.taskboard.mappers;

import ru.mephi.taskboard.models.Task;
import ru.mephi.taskboard.models.TaskColumn;
import ru.mephi.taskboard.models.dto.TaskColumnDto;
import ru.mephi.taskboard.models.dto.TaskDto;

public class TaskMapping {
    //from entity to Object
    public static TaskDto mapToTaskDto(Task task){
        TaskDto dto = new TaskDto();
        dto.setTaskColumnId(task.getTaskColumn().getId());
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setClDate(task.getClDate());
        dto.setCrDate(task.getCrDate());
        dto.setDescription(task.getDescription());

        return dto;
    }

    //from entity to Object
    public static  Task mapToTask(TaskDto taskDto){
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(task.getDescription());
        task.setCrDate(taskDto.getCrDate());
        task.setClDate(taskDto.getClDate());
        task.setId(task.getId());
        TaskColumn taskColumn =  new TaskColumn();
        taskColumn.setId(taskDto.getId());
        task.setTaskColumn(taskColumn);


        return task;
    }
}
