package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * The type Person dto.
 */
public record PersonDto(Long id, Role role, String username, String password) {

  /**
   * From entity person dto.
   *
   * @param person the person
   * @return the person dto
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getRole(),
        person.getUsername(),
        person.getPassword()
    );
  }

  /**
   * To entity person.
   *
   * @return the person
   */
  public Person toEntity() {
    Person person = new Person();
    person.setId(id);
    person.setRole(role);
    person.setUsername(username);
    person.setPassword(password);
    return person;
  }
}
