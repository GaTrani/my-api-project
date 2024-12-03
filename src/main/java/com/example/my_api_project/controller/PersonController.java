package com.example.my_api_project.controller;

import com.example.my_api_project.model.Person;
import com.example.my_api_project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id){
        return personRepository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        Person personSave = new Person();
        personSave.setFirstName(person.getFirstName());
        personSave.setLastName(person.getLastName());
        personSave.setAddress(person.getAddress());
        personSave.setGender(person.getGender());
        System.out.println("CREATED");

        return personRepository.save(personSave);
    }

    @PutMapping("/update")
    public Person upPerson(@RequestBody Person person) {
        Person personUpdate = personRepository.findById(person.getId()).orElseThrow();
        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setLastName(person.getLastName());
        personUpdate.setAddress(person.getAddress());
        personUpdate.setGender(person.getGender());
        return personRepository.save(personUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Person personDelete = personRepository.findById(id).orElseThrow();
        personRepository.delete(personDelete);
        return ResponseEntity.noContent().build();
    }
}
