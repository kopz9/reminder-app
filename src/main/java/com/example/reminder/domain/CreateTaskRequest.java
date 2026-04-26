package com.example.reminder.domain;

import com.example.reminder.domain.entity.TaskPriority;

import java.time.LocalDateTime;

public record CreateTaskRequest(
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority
) {
}
