package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;
import ru.tbank.safedeckteam.spectre.model.Role;

@Data
public class EmployeeTestParticipationDTO {

    private Long id;

    private EmployeeDTO employee;

    private TestDTO test;

    private Role role;

    private String notes;
}
