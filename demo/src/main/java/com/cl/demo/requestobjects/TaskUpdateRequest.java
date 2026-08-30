package com.cl.demo.requestobjects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TaskUpdateRequest {
    String uuid;
    String titleToUpdate;
    String descriptionToUpdate;
   String taskStatusToUpdate;
    Date dueDateToUpdate;
    Boolean isAssignedToUpdate;

}
