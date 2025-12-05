package org.example.tp3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.example.tp3.constants.TaskStatus;

import java.util.UUID;

@AllArgsConstructor
@Getter
public final class Task {
    @NonNull
    private final UUID id;
    @NonNull
    private final String title;
    @NonNull
    private final String description;
    @NonNull
    private final TaskStatus status;
    @NonNull
    private final User assignee;


    public static Task newTodo(String title, String description) {
        return new Task(UUID.randomUUID(), title, description, TaskStatus.TODO, null);
    }

    public Task withStatus(TaskStatus newStatus) {
        return new Task(this.id, this.title, this.description, newStatus, this.assignee);
    }

    public Task withAssignee(User newAssignee) {
        return new Task(this.id, this.title, this.description, this.status, newAssignee);
    }

    public Task withTitle(String newTitle) {
        return new Task(this.id, newTitle, this.description, this.status, this.assignee);
    }

    public Task withDescription(String newDescription) {
        return new Task(this.id, this.title, newDescription, this.status, this.assignee);
    }
}