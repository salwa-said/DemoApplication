package com.cl.demo.responseobjects;

import com.cl.demo.entities.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskCreateResponse {
     String taskId;
     String title;
     String description;
     String taskNumber;
     String taskStatus;
     String dueDate;
     Boolean isAssigned;

    public static TaskCreateResponse convert(Task task) {
        if (task == null || task.getId() == null) return null;
        TaskCreateResponse response = new TaskCreateResponse();
        response.setTaskId(task.getId().toString());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setTaskNumber(task.getTaskNumber());
        response.setTaskStatus(task.getTaskStatus().toString());
        response.setDueDate(task.getDueDate() != null ? task.getDueDate().toString() : null);
        response.setIsAssigned(task.getIsAssigned());
        return response;
    }

    public static List<TaskCreateResponse> convert(List<Task> taskList){
        List<TaskCreateResponse> responseList = new ArrayList<>();
        for (Task t : taskList) {
            TaskCreateResponse res = convert(t);
            if (res != null) responseList.add(res);
        }
        return responseList;
    }
}


