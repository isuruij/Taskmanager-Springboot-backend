package com.example.newDemo.repo;

import com.example.newDemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository <Task,Integer>{

    @Query(value = "SELECT * FROM Task WHERE id= ?1", nativeQuery = true)
    Task getTaskById(Integer taskId);
}
