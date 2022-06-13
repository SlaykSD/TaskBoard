package ru.mephi.taskboard.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "columns")
@Getter
@Setter
public class TaskColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public TaskColumn(String name) {
        this.name = name;
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number_tasks")
    private Integer numberTasks;

    @Override
    public String toString() {
        return "TaskColumn{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", numberTasks=" + numberTasks +
            '}';
    }
/// В Task column_id -> id в TaskColumn
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn( name = "column_id")
    private List<Task> tasks;
}
