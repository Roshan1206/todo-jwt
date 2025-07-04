package com.example.todos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TodoRequest {

    @NotEmpty(message = "Title is mandatory")
    @Size(min = 3, max = 30, message = "Title should be at least 3 characters long")
    private String name;

    @NotEmpty(message = "Description is mandatory")
    @Size(min = 3, max = 30, message = "Description should be at least 3 characters long")
    private String description;

    @Min(1)
    @Max(5)
    private int priority;

    public TodoRequest(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
