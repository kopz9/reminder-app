package com.example.reminder.mapper;

import com.example.reminder.domain.CreateTaskRequest;
import com.example.reminder.domain.UpdateTaskRequest;
import com.example.reminder.domain.dto.CreateTaskRequestDTO;
import com.example.reminder.domain.dto.TaskDTO;
import com.example.reminder.domain.dto.UpdateTaskRequestDTO;
import com.example.reminder.domain.entity.Task;
import jakarta.validation.Valid;

public interface TaskMapper {

  CreateTaskRequest fromDTO(CreateTaskRequestDTO dto);

  UpdateTaskRequest fromDto(UpdateTaskRequestDTO dto);

  TaskDTO toDTO(Task task);

}
