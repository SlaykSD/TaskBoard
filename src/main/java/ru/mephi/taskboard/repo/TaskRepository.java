package ru.mephi.taskboard.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mephi.taskboard.models.Task;

public interface TaskRepository extends CrudRepository<Task,Long> {
}
