package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.Task;
import com.cl.demo.entities.TaskStatus;
import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.requestobjects.TaskUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.*;

@Service
public class TaskService {
        public static final String TASK_SAVED = "TASK SAVED";

        public Map<String, String> addTask(TaskCreateRequest requestObj) {
                Map<String, String> response = new HashMap<>();
                Task task = new Task();

                if (requestObj.getTitle() == null || requestObj.getTitle().isEmpty()
                        || requestObj.getDescription() == null || requestObj.getDescription().isEmpty()
                        || requestObj.getDueDate() == null) {
                        response.put("error", "Important fields cannot be empty");
                        return response;
                }

                task.setId(UUID.randomUUID());
                task.setIsActive(Boolean.TRUE);
                task.setCreatedDate(new Date());
                task.setTaskNumber(generateTaskNumber());

                task.setTitle(requestObj.getTitle());
                task.setDescription(requestObj.getDescription());
                task.setStartDate(requestObj.getStartDate());
                task.setDueDate(requestObj.getDueDate());
                task.setTaskStatus(requestObj.getTaskStatus());
                task.setIsAssigned(requestObj.getIsAssigned());

                Boolean result = DemoApplication.taskList.add(task);
                if (result) {
                        response.put("response", TASK_SAVED);
                }
                return response;
        }

        public Task getTaskById(String uuid) {
                for (Task t : DemoApplication.taskList) {
                        if (t.getId().toString().equals(uuid) && t.getIsActive()) {
                                return t;
                        }
                }
                return null;
        }

        public List<Task> getAllTasks() {
                List<Task> resultList = new ArrayList<>();
                for (Task t : DemoApplication.taskList) {
                        if (t.getIsActive()) { //boolean check
                                resultList.add(t);
                        }
                }
                return resultList;
        }

        public Task updateTask(TaskUpdateRequest updateObj) {
                Task task = getTaskById(updateObj.getUuid());
                if (task == null || task.getId() == null || !task.getIsActive()) {
                        return task;
                }
                DemoApplication.taskList.remove(task);

                task.setTitle(HelperUtils.compare(task.getTitle(), updateObj.getTitleToUpdate()));
                task.setDescription(HelperUtils.compare(task.getDescription(), updateObj.getDescriptionToUpdate()));

                if (updateObj.getTaskStatusToUpdate() != null) {
                        task.setTaskStatus(TaskStatus.valueOf(updateObj.getTaskStatusToUpdate()));
                }

                if (updateObj.getDueDateToUpdate() != null) {
                        task.setDueDate(updateObj.getDueDateToUpdate());
                }


                if (updateObj.getIsAssignedToUpdate() != null) {
                        task.setIsAssigned(updateObj.getIsAssignedToUpdate());
                }

                task.setUpdatedDate(new Date());
                DemoApplication.taskList.add(task);
                return task;
                
        }

        public Boolean deleteById(String uuid) {
                Task task = getTaskById(uuid);
                if (task == null || task.getId() == null || !task.getIsActive()) {
                        return false;
                } else {
                        DemoApplication.taskList.remove(task);
                        task.setIsActive(false);
                        task.setUpdatedDate(new Date());
                        DemoApplication.taskList.add(task);
                        return true;
                }
        }

        private String generateTaskNumber() {
                return "TASK-" + (DemoApplication.taskList.size() + 1);
        }
}