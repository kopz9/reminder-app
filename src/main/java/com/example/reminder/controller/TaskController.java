package com.example.reminder.controller;

import com.example.reminder.domain.CreateTaskRequest;
import com.example.reminder.domain.UpdateTaskRequest;
import com.example.reminder.domain.dto.CreateTaskRequestDTO;
import com.example.reminder.domain.dto.TaskDTO;
import com.example.reminder.domain.dto.UpdateTaskRequestDTO;
import com.example.reminder.domain.entity.Task;
import com.example.reminder.mapper.TaskMapper;
import com.example.reminder.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;
  private final TaskMapper taskMapper;

  @PostMapping
  public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody CreateTaskRequestDTO createTaskRequestDTO) {
    CreateTaskRequest createTaskRequest = taskMapper.fromDTO(createTaskRequestDTO);
    Task task = taskService.createtask(createTaskRequest);
    TaskDTO createdTaskDTO = taskMapper.toDTO(task);
    return new ResponseEntity<>(createdTaskDTO, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TaskDTO>> listTasks() {
    List<Task> tasks = taskService.listTask();
    List<TaskDTO> taskDTOS = tasks.stream().map(taskMapper::toDTO).toList();
    return ResponseEntity.ok(taskDTOS);
  }

  @PutMapping("/{taskId}")
  public ResponseEntity<TaskDTO> updateTask(@PathVariable UUID taskId, @Valid @RequestBody UpdateTaskRequestDTO updateTaskRequestDTO) {
    UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDTO);
    var task = taskService.updateTask(taskId, updateTaskRequest);
    var taskDTO = taskMapper.toDTO(task);

    return ResponseEntity.ok(taskDTO);
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
    taskService.deleteTask(taskId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
