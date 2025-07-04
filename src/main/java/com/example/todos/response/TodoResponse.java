package com.example.todos.response;

public class TodoResponse {

    private long id;
    private String name;
    private String description;
    private int priority;
    private boolean complete;

    public TodoResponse(long id, String name, String description, int priority, boolean complete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
