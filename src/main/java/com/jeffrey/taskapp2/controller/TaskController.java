package com.jeffrey.taskapp2.controller;
import com.jeffrey.taskapp2.dto.ResponseDTO;
import com.jeffrey.taskapp2.entity.Task;
import com.jeffrey.taskapp2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    @Autowired
    private TaskService service;
    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTask());
    }
    @PostMapping
    public ResponseEntity<ResponseDTO> addTask(@RequestBody Task data){
        Task task = service.addTask(data);
        ResponseDTO response= new ResponseDTO();
        response.setMessage("Task Created successfully");
        response.setStatusCode(201);
        response.setData(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{idtask}")
    public ResponseEntity<ResponseDTO> updateTaskStatus(@PathVariable(name = "idtask") Long idtask){
        service.updateTaskStatus(idtask);
        ResponseDTO response= new ResponseDTO();
        response.setMessage("Task status changed successfully");
        response.setStatusCode(200);
        response.setData("");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{idtask}")
    public ResponseEntity<ResponseDTO> deleteTask(@PathVariable(name = "idtask") Long idtask){
        service.deleteTask(idtask);
        ResponseDTO response= new ResponseDTO();
        response.setMessage("Deleted task successfully");
        response.setStatusCode(200);
        response.setData("");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //post
    //public ResponseEntity<>
    //put
    //delete

}

