package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

public record PersonDto(Long id, Role role, String username, String password) {

  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getRole(),
        person.getUsername(),
        person.getPassword()
    );
  }

  public Person toEntity() {
    Person person = new Person();
    person.setId(id);
    person.setRole(role);
    person.setUsername(username);
    person.setPassword(password);
    return person;
  }
}
