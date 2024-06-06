package com.example.newDemo.service;

import com.example.newDemo.dto.TaskDTO;
import com.example.newDemo.model.Task;
import com.example.newDemo.repo.TaskRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<TaskDTO> getAllTasks(){
        List<Task> taskList = taskRepo.findAll();
        return modelMapper.map(taskList,new TypeToken<List<TaskDTO>>(){}.getType());
    }

    public TaskDTO getTaskByID(Integer taskId){
        Task task = taskRepo.getTaskById(taskId);
        return modelMapper.map(task,TaskDTO.class);
    }

    public TaskDTO saveTask(TaskDTO taskDTO){
        taskRepo.save(modelMapper.map(taskDTO,Task.class));
        return taskDTO;
    }

    public TaskDTO updateTask(TaskDTO taskDTO){
        taskRepo.save(modelMapper.map(taskDTO,Task.class));
        return taskDTO;
    }

    public String deleteTask(Integer userId){
        taskRepo.deleteById(userId);
        return "Task deleted";
    }
}
