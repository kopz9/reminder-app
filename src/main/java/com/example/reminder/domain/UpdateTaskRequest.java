package com.example.reminder.domain;

import com.example.reminder.domain.entity.TaskPriority;
import com.example.reminder.domain.entity.TaskStatus;

import java.time.LocalDateTime;

public record UpdateTaskRequest(
    String title,
    String description,
    LocalDateTime dueDate,
    TaskStatus status,
    TaskPriority priority
) {
}
