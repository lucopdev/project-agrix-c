package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(@RequestBody Person person) {
    Person personCreated = personService.create(person);

    return new PersonDto(personCreated.getId(), personCreated.getRole(),
        personCreated.getUsername());
  }
}
