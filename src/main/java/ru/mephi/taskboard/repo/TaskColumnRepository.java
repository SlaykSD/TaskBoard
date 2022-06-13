package ru.mephi.taskboard.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mephi.taskboard.models.TaskColumn;

public interface TaskColumnRepository extends CrudRepository<TaskColumn,Long> {
}
