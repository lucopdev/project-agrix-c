package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.PersonResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Person controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  /**
   * Instantiates a new Person controller.
   *
   * @param personService the person service
   */
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create person person response dto.
   *
   * @param person the person
   * @return the person response dto
   */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public PersonResponseDto createPerson(@RequestBody Person person) {
    Person personCreated = personService.create(person);

    return new PersonResponseDto(personCreated.getId(), personCreated.getRole(),
        personCreated.getUsername());
  }
}
