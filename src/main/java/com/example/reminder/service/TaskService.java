package com.example.reminder.service;

import com.example.reminder.domain.CreateTaskRequest;
import com.example.reminder.domain.UpdateTaskRequest;
import com.example.reminder.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

  Task createtask(CreateTaskRequest request);

  List<Task> listTask();

  Task updateTask(UUID taskId, UpdateTaskRequest request);

  void deleteTask(UUID taskId);

}
