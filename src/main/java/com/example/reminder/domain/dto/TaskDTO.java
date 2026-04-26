package com.example.reminder.domain.dto;

import com.example.reminder.domain.entity.TaskPriority;
import com.example.reminder.domain.entity.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(
    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status
) {
}
