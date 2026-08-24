package com.cl.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter

public class BaseClass {
    private UUID id;  //GIVES UNIQUE ID ALWAYS
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
