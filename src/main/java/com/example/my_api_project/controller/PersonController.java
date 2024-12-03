package com.example.my_api_project.controller;

import com.example.my_api_project.model.Person;
import com.example.my_api_project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person createPerson(@RequestBody Person person) {
        Person personSave = new Person();
        personSave.setFirstName(person.getFirstName());
        personSave.setLastName(person.getLastName());
        personSave.setAddress(person.getAddress());
        personSave.setGender(person.getGender());
        System.out.println("CREATED");

        return personRepository.save(personSave);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public  Person upPerson(@RequestBody Person person){
        Person personUpdate = personRepository.findById(person.getId()).orElseThrow();
        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setLastName(person.getLastName());
        personUpdate.setAddress(person.getAddress());
        personUpdate.setGender(person.getGender());
        return personRepository.save(personUpdate);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable (value = "id") String id){
        Person personDelete = personRepository.findById(id).orElseThrow();
        personRepository.delete(personDelete);
        System.out.println("DELETED - route" + id);
    }
}
