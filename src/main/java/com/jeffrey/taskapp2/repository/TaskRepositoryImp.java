package com.jeffrey.taskapp2.repository;

import com.jeffrey.taskapp2.entity.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class TaskRepositoryImp implements TaskRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Task> findAllTasks() {
        String query = "FROM Task";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public Task saveTask(Task task) {
        return entityManager.merge(task);
    }
    @Override
    public void markedTask(Long id) {
        Query query = entityManager.createQuery("UPDATE Task t SET t.status = true WHERE t.id = :IdTask");
        query.setParameter("IdTask", id);
        query.executeUpdate();
    }
    @Override
    public void deleteTask(Long id) {
        Task task = entityManager.find(Task.class,id);
        entityManager.remove(task);
    }
}
