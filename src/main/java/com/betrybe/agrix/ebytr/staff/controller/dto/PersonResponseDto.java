package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.security.Role;

public record PersonResponseDto(Long id, Role role, String username) {

}
