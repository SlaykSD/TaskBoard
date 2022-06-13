package ru.mephi.taskboard.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetTime;

@NoArgsConstructor
@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Task(String name, String description, TaskColumn taskColumn) {
        this.name = name;
        this.description = description;
        this.taskColumn = taskColumn;
    }

    @Column(name = "name", nullable = false)
    private String  name;

    @Column(name = "description")
    private String description;

    @Column(name = "cr_date")
    private LocalDate crDate;

    @Column(name = "cl_date")
    private LocalDate clDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "column_id")
    private TaskColumn taskColumn;

    @Column(name = "mark_id")
    private Long markId;

}
