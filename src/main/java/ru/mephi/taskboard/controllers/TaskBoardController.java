package ru.mephi.taskboard.controllers;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mephi.taskboard.mappers.TaskColumnMapping;
import ru.mephi.taskboard.mappers.TaskMapping;
import ru.mephi.taskboard.models.Task;
import ru.mephi.taskboard.models.TaskColumn;
import ru.mephi.taskboard.models.dto.TaskDto;
import ru.mephi.taskboard.repo.TaskColumnRepository;
import ru.mephi.taskboard.repo.TaskRepository;
import ru.mephi.taskboard.service.TaskColumnService;
import ru.mephi.taskboard.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/task-board")
@RequiredArgsConstructor
public class TaskBoardController {
    private final TaskService taskService;
    private final TaskColumnService taskColumnService;
//("/task-board")
    @GetMapping
    public String taskBoard(Model model) {
        model.addAttribute("title", "Страница Задач");
        var  taskDtos = ((List<Task>)taskService.getTasks()).stream()
            .map(TaskMapping::mapToTaskDto).collect(Collectors.toList());
        var columnDtos = ((List<TaskColumn>)taskColumnService.getTaskColumns()).stream()
            .map(TaskColumnMapping::mapToTaskColumnDto).collect(Collectors.toList());


        model.addAttribute("Tasks", taskDtos);
        model.addAttribute("TaskColumns",columnDtos);
        return "taskBoard";
    }


    @PostMapping
    public String addColumn(@RequestParam(name = "titleColumn")  String titleColumn, Model model){
        TaskColumn taskColumn =  new TaskColumn(titleColumn);

        taskColumnService.saveTaskColumn(new TaskColumn(titleColumn));
        System.out.println(titleColumn);
        System.out.println(taskColumn);

        return taskBoard(model);
    }


    //TODO: Нужно добавить DELETE и Возможность редачить данные

//
//    /**
//     * DELETE запрос
//     * Удаляет книгу и связь между ней и автором
//     * <p>
//     * После удаления переносит в /authors
//     *
//     * @param id      уникальный идентификатор книги, которую будем удалять
//     * @param request необходим для возврата на предыдущие страницы после удаления книги
//     * @return переход на страницу со всеми книгами
//     */
//    @RequestMapping( method = RequestMethod.DELETE)
//    public String delete(@PathVariable String id, HttpServletRequest request) {
//        authorBookService.delete(authorBookService.getByIdBook(Long.parseLong(id, 10)).getId());
//        bookService.delete(Long.parseLong(id, 10));
//        Path link = Paths.get(request.getHeader("Referer")).getParent();
//        return "redirect:/" + link;
//    }

    //TODO: Как сделать удаление? Мы какую форму получаем? Надо гулить реалиации думаю put елает аналогично

//    /**
//     * PUT запрос для обновления
//     * Изменяет книгу только если она есть
//     *
//     * @param id   уникальный идентификатор книги
//     * @param book новые данные
//     * @return измененную книгу
//     */
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public Book update(@PathVariable String id, @RequestBody Book book) throws BookNotFound {
//        bookService.update(book, Long.parseLong(id, 10));
//        return bookService.getBook(id);
//    }
//
//    /**
//     * Получает автора по id книги
//     *
//     * @param id уникальный идентификатор книги
//     * @return автора, которому принадлежит эта книга
//     */
//    public Author getAuthor(Long id) {
//        return authorService.getAuthor(authorBookService.getByIdBook(id).getIdAuthor().toString());
//    }

//    @PostMapping("/task-board")
//    public String addTaskColumn(@RequestParam  String titleColumn){
//        //taskColumnService.saveTaskColumn(new TaskColumn(titleColumn));
//        System.out.println(titleColumn);
//        return null;
//    }

//    @PostMapping("")
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.saveUser(user));
//    }
//    @PostMapping("/task-board")
//    public String addTaskColumn(@RequestParam String titleColumn, Model model){
//        TaskColumn taskColumn = new TaskColumn(titleColumn);
//        taskColumn.setId(1);
//        taskColumn.setNumberTasks(1);
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+taskColumn.toString());
//        taskColumnRepository.save(taskColumn);
//        return "";
//    }

//    @PostMapping("/task-board")
//    public String addTask(@RequestParam String titleTask,
//                          @RequestParam  String description,
//                          @RequestParam Integer numberOfColumn,
//                          Model model){
//        Task task = new Task(titleTask,description,numberOfColumn);
//        taskRepository.save(task);
//        return "";
//    }

//    private final UserService userService;
//
//    @GetMapping("")
//    public ResponseEntity<Iterable<UserDto>> getUsers() {
//        return ResponseEntity.ok(userService.getUsers());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.getUser(id));
//    }
//
//    @PostMapping("")
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.saveUser(user));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
}
