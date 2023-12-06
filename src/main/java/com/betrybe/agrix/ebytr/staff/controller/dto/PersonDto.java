package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.security.Role;

public record PersonDto(Long id, Role role, String username) {

}
