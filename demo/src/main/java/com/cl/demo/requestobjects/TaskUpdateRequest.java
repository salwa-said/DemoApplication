package com.cl.demo.requestobjects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskUpdateRequest {
    String uuid;
    String titleToUpdate;
    String descriptionToUpdate;
   String taskStatusToUpdate;
    String dueDateToUpdate;
    Boolean isAssignedToUpdate;

}
