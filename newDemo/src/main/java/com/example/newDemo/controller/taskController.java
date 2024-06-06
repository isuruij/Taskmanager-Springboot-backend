package com.example.newDemo.controller;

import com.example.newDemo.dto.TaskDTO;
import com.example.newDemo.service.TaskService;
import org.apache.catalina.util.Introspection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1/")

public class taskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/gettasks")
    public List<TaskDTO> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/gettask/{taskId}")
    public TaskDTO getTaskByID(@PathVariable Integer taskId) {
        return taskService.getTaskByID(taskId);
    }

    @PostMapping("/savetask")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return taskService.saveTask(taskDTO);
    }

    @PutMapping("/updatetask")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskDTO);
    }

    @DeleteMapping("/deletetask/{userId}")
    public String deleteTask(@PathVariable Integer userId) {
        return taskService.deleteTask(userId);

    }
}
