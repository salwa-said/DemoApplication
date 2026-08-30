package com.cl.demo.responseobjects;

import com.cl.demo.entities.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonUpdateResponse {

    String personId;
    String userName;
    String email;


    public static PersonUpdateResponse convert(Person person) {
        if (person == null || person.getId() == null) return null;

        PersonUpdateResponse response = new PersonUpdateResponse();
        response.setPersonId(person.getId().toString());
        response.setEmail(person.getEmail());
        response.setUserName(
                person.getUserName() != null ? person.getUserName().getActiveUserName() : null
        );
        return response;
    }


    public static List<PersonUpdateResponse> convert(List<Person> personList){
        List<PersonUpdateResponse> responseList = new ArrayList<>();
        for (Person p:personList){
            responseList.add(convert(p));
        }
        return responseList;
    }
}
