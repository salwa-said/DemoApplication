package com.cl.demo.requestobjects;

import com.cl.demo.entities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TaskCreateRequest {
     String title;
     String description;
     String taskNumber;
     Date dueDate;
     Date startDate;
     Date endDate;
     TaskStatus taskStatus;
     Boolean isAssigned;


}
