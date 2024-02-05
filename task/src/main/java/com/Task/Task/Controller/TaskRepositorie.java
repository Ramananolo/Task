package com.Task.Task.Controller;

import com.Task.Task.Model.Task;

import java.util.List;

public interface TaskRepositorie {
    List<Task> getAllTask();
    Task getTaskById(int id);
    void insert(Task task);
}
