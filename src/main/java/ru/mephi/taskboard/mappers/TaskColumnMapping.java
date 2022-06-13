package ru.mephi.taskboard.mappers;

import ru.mephi.taskboard.models.TaskColumn;
import ru.mephi.taskboard.models.dto.TaskColumnDto;

public class TaskColumnMapping {
    //from entity to dto
    public static TaskColumnDto mapToTaskColumnDto(TaskColumn taskColumn){
        TaskColumnDto dto = new TaskColumnDto();
        dto.setId(taskColumn.getId());
        dto.setNumberTasks(taskColumn.getNumberTasks());
        //dto.setTasks(taskColumn.getTasks());
        dto.setName(taskColumn.getName());
        return dto;
    }

    public static TaskColumn mapToTaskColumn(TaskColumnDto taskColumnDto){
        TaskColumn taskColumn = new TaskColumn();
        taskColumn.setId(taskColumnDto.getId());
        taskColumn.setNumberTasks(taskColumnDto.getNumberTasks());
        //dto.setTasks(taskColumn.getTasks());
        taskColumn.setName(taskColumnDto.getName());
        return taskColumn;
    }
}
