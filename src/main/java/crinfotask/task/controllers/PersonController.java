package crinfotask.task.controllers;


import crinfotask.task.domains.Person;
import crinfotask.task.domains.PersonDto;
import crinfotask.task.services.interfaces.PersonService;
import crinfotask.task.utils.PersonToDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/person/","/person"})
public class PersonController {

    @Autowired
    private PersonService personService;

    //register person
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto registerPerson(@RequestBody @Valid Person person) {
        person = personService.registerPerson(person);
        PersonDto personDto = PersonToDtoUtil.convertPerson(person);
        return personDto;
    }
}
