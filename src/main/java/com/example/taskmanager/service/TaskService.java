package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public Task createTask(Task task) {
        String generatedId;

        // Loop until we find a truly unique ID
        do {
            generatedId = UUID.randomUUID().toString();
        } while (taskRepo.existsById(generatedId));

        // Set the unique ID and save the task
        task.setTaskId(generatedId);
        return taskRepo.save(task);
    }



    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(String id) {
        return taskRepo.findById(id).orElse(null);
    }

    public Task updateTask(String id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isPresent()) {
            Task existing = optionalTask.get();
            existing.setDescription(updatedTask.getDescription());
            existing.setSeverity(updatedTask.getSeverity());
            existing.setAssignee(updatedTask.getAssignee());
            existing.setStoryPoint(updatedTask.getStoryPoint());
            return taskRepo.save(existing);
        }
        return null;
    }

    public void deleteTask(String id) {
        taskRepo.deleteById(id);
    }
}
