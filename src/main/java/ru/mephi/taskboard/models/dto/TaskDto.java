package ru.mephi.taskboard.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mephi.taskboard.models.TaskColumn;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetTime;
@Data
public class TaskDto {

    private Long id;
    private String  name;
    private String description;
    private LocalDate crDate;
    private LocalDate clDate;
    private Long taskColumnId;
   // private Integer markId;

}
