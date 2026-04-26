package com.example.reminder.service.impl;

import com.example.reminder.domain.CreateTaskRequest;
import com.example.reminder.domain.UpdateTaskRequest;
import com.example.reminder.domain.entity.Task;
import com.example.reminder.domain.entity.TaskStatus;
import com.example.reminder.exception.TaskNotFoundException;
import com.example.reminder.repository.TaskRepository;
import com.example.reminder.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  @Override
  public Task createtask(CreateTaskRequest request) {
    Instant now = Instant.now();

    var task = new Task(
        null,
        request.title(),
        request.description(),
        request.dueDate(),
        TaskStatus.OPEN,
        request.priority(),
        now,
        now
    );

    return taskRepository.save(task);
  }

  @Override
  public List<Task> listTask() {
    return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
  }

  @Override
  public Task updateTask(UUID taskId, UpdateTaskRequest request) {
    var task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));

    task.setTitle(request.title());
    task.setDescription(request.description());
    task.setDueDae(request.dueDate());
    task.setStatus(request.status());
    task.setPriority(request.priority());
    task.setUpdatedAt(Instant.now());

    return taskRepository.save(task);
  }

  @Override
  public void deleteTask(UUID taskId) {
    taskRepository.deleteById(taskId);
  }
}
