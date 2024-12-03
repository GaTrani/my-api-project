package com.example.my_api_project.controller;

import com.example.my_api_project.mapper.MyMapper;
import com.example.my_api_project.model.Person;
import com.example.my_api_project.repository.PersonRepository;
import com.example.my_api_project.vo.v1.PersonVO;
import com.example.my_api_project.vo.v2.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personVO")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private static MyMapper mapper;

    @GetMapping("/all")
    public List<PersonVO> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        List<PersonVO> personVOList = mapper.parseListObjects(personList, PersonVO.class);
        return personVOList;
    }

    @GetMapping("/{id}")
    public PersonVO getPerson(@PathVariable String id){
        PersonVO personVO = mapper.parseObject(personRepository.findById(id).orElseThrow(), PersonVO.class);
        return personVO;
    }

    @PostMapping("/create")
    public PersonVO createPerson(@RequestBody PersonVO personVO) {

        Person person  = mapper.parseObject(personVO, Person.class);
        Person personSave = new Person();
        personSave.setFirstName(person.getFirstName());
        personSave.setLastName(person.getLastName());
        personSave.setAddress(person.getAddress());
        personSave.setGender(person.getGender());
        personRepository.save(personSave);
        System.out.println("CREATED");

        return personVO;
    }

    @PostMapping("/v2/create")
    public PersonVOV2 createPerson(@RequestBody PersonVOV2 personVOV2) {

        Person person  = mapper.parseObject(personVOV2, Person.class);
        Person personSave = new Person();
        personSave.setFirstName(person.getFirstName());
        personSave.setLastName(person.getLastName());
        personSave.setAddress(person.getAddress());
        personSave.setGender(person.getGender());
        //personSave.setGender(person.getBirthDay());
        personRepository.save(personSave);
        System.out.println("CREATED");

        return personVOV2;
    }

    @PutMapping("/update")
    public PersonVO upPerson(@RequestBody PersonVO personVO) {

        Person person = mapper.parseObject(personVO, Person.class);
        Person personUpdate = personRepository.findById(personVO.getId()).orElseThrow();

        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setLastName(person.getLastName());
        personUpdate.setAddress(person.getAddress());
        personUpdate.setGender(person.getGender());
        personRepository.save(personUpdate);
        System.out.println("UPDATED");

        return personVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Person personDelete = personRepository.findById(id).orElseThrow();
        personRepository.delete(personDelete);
        return ResponseEntity.noContent().build();
    }
}
