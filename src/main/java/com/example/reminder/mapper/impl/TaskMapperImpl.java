package com.example.reminder.mapper.impl;

import com.example.reminder.domain.CreateTaskRequest;
import com.example.reminder.domain.UpdateTaskRequest;
import com.example.reminder.domain.dto.CreateTaskRequestDTO;
import com.example.reminder.domain.dto.TaskDTO;
import com.example.reminder.domain.dto.UpdateTaskRequestDTO;
import com.example.reminder.domain.entity.Task;
import com.example.reminder.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

  @Override
  public CreateTaskRequest fromDTO(CreateTaskRequestDTO dto) {
    return new CreateTaskRequest(
        dto.title(),
        dto.description(),
        dto.dueDate(),
        dto.priority()
    );
  }

  @Override
  public UpdateTaskRequest fromDto(UpdateTaskRequestDTO dto) {
    return new UpdateTaskRequest(
        dto.title(),
        dto.description(),
        dto.dueDate(),
        dto.status(),
        dto.priority()
    );
  }


  @Override
  public TaskDTO toDTO(Task task) {
    return new TaskDTO(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getDueDae(),
        task.getPriority(),
        task.getStatus()
    );
  }
}
