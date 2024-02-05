package com.Task.Task.Controller;

import com.Task.Task.Model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Task")
public class TaskController {
    private final TaskRepositorie taskRepositorie;
    @Autowired
    public TaskController(TaskRepositorie taskRepositorie) {
        this.taskRepositorie = taskRepositorie;
    }
    @GetMapping
    public  List<Task> getAllTask(){ return taskRepositorie.getAllTask();}
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskRepositorie.getTaskById(id);
    }
    @PostMapping("/insert")
    public void insert(@RequestBody Task task){
        taskRepositorie.insert(task);
    }
}
