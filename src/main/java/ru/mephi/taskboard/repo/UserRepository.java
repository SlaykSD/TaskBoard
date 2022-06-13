package ru.mephi.taskboard.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mephi.taskboard.models.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
