package com.example.taskmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String taskId;

    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;

    // Constructors
    public Task() {}

    public Task(String taskId, String description, int severity, String assignee, int storyPoint) {
        this.taskId = taskId;
        this.description = description;
        this.severity = severity;
        this.assignee = assignee;
        this.storyPoint = storyPoint;
    }

    // Getters and Setters
    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getSeverity() { return severity; }
    public void setSeverity(int severity) { this.severity = severity; }

    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

    public int getStoryPoint() { return storyPoint; }
    public void setStoryPoint(int storyPoint) { this.storyPoint = storyPoint; }
}
