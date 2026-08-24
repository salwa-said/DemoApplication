package com.cl.demo.services;


import com.cl.demo.DemoApplication;
import com.cl.demo.entities.Person;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    public  static final  String USERNAME_OR_EMAIL_ALREADY_TAKEN="USERNAME OR EMAIL ALREADY TAKEN";
    public  static final  String PERSON_SAVED="PERSON SAVED";



    public Map<String, String> addPerson(Person person) {
        Map<String, String> response = new HashMap<>();

        if (!DemoApplication.emails.add(person.getEmail())|| !DemoApplication.userNames.add(person.getUserName())){
            response.put("response", USERNAME_OR_EMAIL_ALREADY_TAKEN);
            return response;
        }

        person.setId(UUID.randomUUID());
        person.setIsActive(Boolean.TRUE);
        person.setCreatedDate(new Date());


        Boolean result = DemoApplication.personList.add(person);
        if(result){
            response.put("response", PERSON_SAVED);
        }
        return response;
    }

    public Person getPersonById(String uuid){
        for (Person p: DemoApplication.personList){
            if(p.getId().toString().equals(uuid)){
                return p;
            }
        }
        return new Person();
    }

    public Person updatePerson(String uuid, String nameToUpdate, String userNameToUpdate, String emailToUpdate){
       Person person = getPersonById(uuid);
       if(person.getId() == null){
           return person;
       }
       DemoApplication.personList.remove(person);

       person.setName(HelperUtils.compare(person.getName(), nameToUpdate));
        person.setUserName(HelperUtils.compare(person.getUserName(), userNameToUpdate));
        person.setEmail(HelperUtils.compare(person.getEmail(), emailToUpdate));

        DemoApplication.personList.add(person);
        return person;
    }

    public List<Person> getAllPersin(){
        return  DemoApplication.personList;
    }
}
