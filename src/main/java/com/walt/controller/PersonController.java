package com.walt.controller;

import com.walt.model.Person;
import com.walt.repository.PersonRepository;
import com.walt.result.ResponseMessage;
import com.walt.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    /**
     * 根据演员名查询Person实体
     */
    @RequestMapping("/get")
    public List<Person> getPersons(@RequestParam(value = "name") String name) {
        return personRepository.findByName(name);
    }

    /**
     * 创建一个演员节点
     */
    @PostMapping("/save")
    public ResponseResult savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseResult(ResponseMessage.OK);
    }


}
