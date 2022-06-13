package ru.mephi.taskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.taskboard.models.TaskColumn;
import ru.mephi.taskboard.repo.TaskColumnRepository;

import java.util.Collection;
import java.util.List;

@Service
public class TaskColumnService  {
    private final TaskColumnRepository taskColumnRepository;

    public TaskColumnService(TaskColumnRepository taskColumnRepository) {
        this.taskColumnRepository = taskColumnRepository;
    }

    public Iterable<TaskColumn> getTaskColumns(){ return taskColumnRepository.findAll();}
    public Long getIdTaskColumnsByNumber(Long number){
        var taskColumns = (List<TaskColumn>)taskColumnRepository.findAll();
        if((number > taskColumns.size()) || (number<=0))
            return (long)-1;
        return taskColumns.get(number.intValue()-1).getId();
    }

    public TaskColumn getTaskColumn(Long id){
        System.out.println("_______________" + id);
        var Opt = taskColumnRepository.findById(id);
        return  Opt.get();
    }

    public TaskColumn saveTaskColumn(TaskColumn taskColumn){ return taskColumnRepository.save(taskColumn);}

    public void deleteTaskColumn(Long id){
        taskColumnRepository.deleteById(id);
    }
}
